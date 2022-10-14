package lecturaEscritura;

import lecturaEscritura.modelos.Alumno;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class LecturaEscrituraJAR {
    public static void main(String[] args) {
        ArrayList<Alumno> lista = new ArrayList<>();
        int opcion = 0;
        do {
            opcion = menu();
            switch (opcion){
                case 1:
                    lista.add(crearAlumno());
                    break;
                case 2:
                    try {
                        guardarAlumno(lista);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    try {
                        cargarAlumno();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    break;
            }
        } while (opcion != 4);
    }

    private static void cargarAlumno() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "HijoLecturaAlumno.jar");
        pb.redirectErrorStream(true);
        Process hijo = pb.start();

        // ----------- LECTURA ------------
        // Cojo la entrada Estandar del hijo
        InputStream isHijo = hijo.getInputStream(); // OJO SALIDA DEL HIJO
        // Creo un lecctor para la entrada
        InputStreamReader isrHijo = new InputStreamReader(isHijo, StandardCharsets.UTF_8);
        // Crearé un buffer para linea a linea
        BufferedReader brHijo = new BufferedReader(isrHijo); // LEE los SOUT del hijo

        System.out.println(brHijo.readLine());
        /*try {
            while (true){
                System.out.println(brHijo.readLine());
            }
        } catch (EOFException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


    }

    private static void guardarAlumno(ArrayList<Alumno> lista) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "HijoEscrituraAlumno.jar");
        pb.redirectErrorStream(true);
        Process hijo = pb.start();

        OutputStream os = hijo.getOutputStream();
        PrintStream ps = new PrintStream(os);

        for (Alumno a :
                lista) {
            ps.println(a.toString());
            ps.flush();
        }


        // ----------- LECTURA ------------
        // Cojo la entrada Estandar del hijo
        InputStream isHijo = hijo.getInputStream(); // OJO SALIDA DEL HIJO
        // Creo un lecctor para la entrada
        InputStreamReader isrHijo = new InputStreamReader(isHijo, StandardCharsets.UTF_8);
        // Crearé un buffer para linea a linea
        BufferedReader brHijo = new BufferedReader(isrHijo); // LEE los SOUT del hijo

        System.out.println(brHijo.readLine());
    }

    private static Alumno crearAlumno() {
        Scanner sc = new Scanner(System.in);
        String nombre;
        int id = 0;
        double nota = 0;
        System.out.println("Nombre: ");
        do {
            nombre = sc.nextLine().trim();
        } while (nombre.equals(""));


        System.out.println("Id: ");
        boolean error = true;
        do {
            try {
                    id = sc.nextInt();
                    error = false;
            } catch (Exception e){
                System.out.println("Introduzca una respuesta válida");
            }
        } while (error);

        System.out.println("Nota: ");
        error = true;
        do {
            try {
                nota = sc.nextDouble();
                error = false;
            } catch (Exception e){
                System.out.println("Introduzca una respuesta válida");
            }
        } while (error);

        return new Alumno(nombre, id, nota);
    }

    private static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Crear alumno");
        System.out.println("2. Guardar alumnos");
        System.out.println("3. Cargar alumnos");
        System.out.println("4. Salir");

        return sc.nextInt();
    }




}

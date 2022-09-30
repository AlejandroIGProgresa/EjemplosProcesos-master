package EjercicioCalculadora;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0, op = 0;
        int[] variables;

        boolean error;
        do {
            error = true;
            try {
                System.out.println("Elige el primer número");
                num1 = sc.nextInt();
                error = false;
                sc.nextLine();
            }
            catch (Exception e){
                System.out.println("ERROR");
            }
        } while (error);
        do {
            error = true;
            try {
                System.out.println("Elige el segundo número");
                num2 = sc.nextInt();
                error = false;
                sc.nextLine();
            }
            catch (Exception e){
                System.out.println("ERROR");
            }
        } while (error);
        do {
            error = true;
            try{
                System.out.println("Elije la operación:");
                System.out.println("1. Suma");
                System.out.println("2. Resta");
                System.out.println("3. Multiplicación");
                System.out.println("4. División");
                System.out.println("5. Todas");
                op = sc.nextInt();
                error = false;
                sc.nextLine();
            } catch (Exception e){
                System.out.println("ERROR");
            }

            ProcessBuilder pb;
            switch (op) {
                case 1 -> {
                    pb = new ProcessBuilder("java", "src/EjercicioCalculadora/Suma.java");
                    parir(pb, num1, num2);
                }
                case 2 -> {
                    pb = new ProcessBuilder("java", "src/EjercicioCalculadora/Resta.java");
                    parir(pb, num1, num2);
                }
                case 3 -> {
                    pb = new ProcessBuilder("java", "src/EjercicioCalculadora/Multiplicacion.java");
                    parir(pb, num1, num2);
                }
                case 4 -> {
                    pb = new ProcessBuilder("java", "src/EjercicioCalculadora/Division.java");
                    parir(pb, num1, num2);
                }
                case 5 -> {
                    parir(new ProcessBuilder("java", "src/EjercicioCalculadora/Suma.java"), num1, num2);
                    parir(new ProcessBuilder("java", "src/EjercicioCalculadora/Resta.java"), num1, num2);
                    parir(new ProcessBuilder("java", "src/EjercicioCalculadora/Multiplicacion.java"), num1, num2);
                    parir(new ProcessBuilder("java", "src/EjercicioCalculadora/Division.java"), num1, num2);
                }
                default -> {
                    System.out.println("Debes elegir una opción de la lista");
                    error = true;
                }
            }
        } while (error);
    }

    private static void parir(ProcessBuilder pb, int num1, int num2){
        pb.redirectErrorStream(true);

        try {
            Process hijo = pb.start();

            // ----------- LECTURA ------------
            // Cojo la entrada Estandar del hijo
            InputStream isHijo = hijo.getInputStream(); // OJO SALIDA DEL HIJO
            // Creo un lecctor para la entrada
            InputStreamReader isrHijo = new InputStreamReader(isHijo, StandardCharsets.UTF_8);
            // Crearé un buffer para linea a linea
            BufferedReader brHijo = new BufferedReader(isrHijo); // LEE los SOUT del hijo

            // ----------- ESCRITURA ----------
            OutputStream outputStream = hijo.getOutputStream(); // CAPTURA LA ENTRADA DEL HIJO (Scanner)
            PrintStream psHijo = new PrintStream(outputStream);

            psHijo.println(num1);
            psHijo.flush(); // INTRO
            psHijo.println(num2);
            psHijo.flush(); // INTRO


            String respuesta = brHijo.readLine();
            System.out.println(respuesta);

            isHijo.close();
            isrHijo.close();
            brHijo.close();
            outputStream.close();
            psHijo.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

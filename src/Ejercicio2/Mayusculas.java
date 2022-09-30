package Ejercicio2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Mayusculas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe una palabra en minúsculas");
        String palabra = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("java", "src/Ejercicio2/CambioMayusculas.java");
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

            psHijo.println(palabra);
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

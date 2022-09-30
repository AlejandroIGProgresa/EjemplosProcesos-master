package Ejemplo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Hijo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String lineas = br.readLine();
        int numero = Integer.parseInt(lineas);
        for (int i = 1; i <= numero; i++) {
            System.out.printf("Linea numero %d %n", i);
        }
        System.out.println("ADIOS PAPI");
    }
}

package Ejemplo1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class ProcesoHijo {

    public static void main(String[] args) throws InterruptedException, IOException {

        PrintWriter pw = new PrintWriter(new FileWriter("prueba.txt"));
        pw.println("ESTOY VIVO");
        pw.close();

        TimeUnit.SECONDS.sleep(60);

    }
}

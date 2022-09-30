package Ejemplo1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ejemplo1 {

    /**
     * App que abre el chrome con la página de progresa cargada
     * @param args
     */
    public static void main(String[] args) {
        // Commandos -> Array de String
        // Elemento 1 el programa
        // siguentes cada una de argumentos a arrancar
        String[] comando = {"open", "-a", "Google Chrome",  "www.youtube.com", "www.cieep.com"};
        String[] comando2 = {"open", "/System/Applications/Textedit.app"};
        String[] comandosWin = {"notepad", "nombredelfichero.txt"};
        String[] comandoChrome = {"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "www.youtube.com", "www.cieep.com"};
        // Crear el proceso con el ProcessBuilder
        String[] hijo = {"java", "src/Ejemplo1/ProcesoHijo.java"};
        ProcessBuilder pb = new ProcessBuilder(hijo);

        // Creamos el proceso Hijo
        try {
            Process pSafari = pb.start();
            if (pSafari.isAlive())
                TimeUnit.SECONDS.sleep(10);
            pSafari.destroy();
            TimeUnit.SECONDS.sleep(10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

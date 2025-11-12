// Main.java
public class Main {

    public static void main(String[] args) {
        // Obtener instancia (primera vez crea el singleton)
        Logger loggerMain = Logger.getInstance();
        loggerMain.log("Main: aplicación iniciada");

        // Llamada desde otra clase
        OtherComponent comp = new OtherComponent();
        comp.doWork();

        // Comprobar que getInstance devuelve la misma referencia en distintos puntos
        Logger loggerOtro = OtherComponentLoggerCheck();
        System.out.println("loggerMain == loggerOtro ? " + (loggerMain == loggerOtro));
        System.out.println("hashCode loggerMain: " + loggerMain.hashCode());
        System.out.println("hashCode loggerOtro:  " + loggerOtro.hashCode());
        loggerMain.log("Main: comprobación de la misma instancia (ver consola para hashCodes)");

        // Probar con varios hilos escribiendo simultáneamente
        Thread t1 = new Thread(new ThreadedTask("A"));
        Thread t2 = new Thread(new ThreadedTask("B"));
        Thread t3 = new Thread(new ThreadedTask("C"));

        t1.start();
        t2.start();
        t3.start();

        // Esperar a que terminen los hilos
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        loggerMain.log("Main: aplicación finalizada");
        System.out.println("Revisa el archivo bitacora.log para ver las entradas de log.");
    }

    // Método auxiliar para obtener la instancia desde otro punto
    private static Logger OtherComponentLoggerCheck() {
        // simula pedir Logger desde otro "lugar" del código
        return Logger.getInstance();
    }
}

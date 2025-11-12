public class Main {
    public static void main(String[] args) {
        Runnable tarea = () -> {
            ConexionBD conexion = ConexionBD.getInstancia();
            conexion.conectar();
            conexion.desconectar();
        };

        Thread hilo1 = new Thread(tarea, "Hilo-1");
        Thread hilo2 = new Thread(tarea, "Hilo-2");
        Thread hilo3 = new Thread(tarea, "Hilo-3");

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}

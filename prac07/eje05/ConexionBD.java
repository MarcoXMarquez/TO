public class ConexionBD {
    private static volatile ConexionBD instancia;
    private ConexionBD() {
        System.out.println("Instancia creada por el hilo: " + Thread.currentThread().getName());
    }

    public static ConexionBD getInstancia() {
        if (instancia == null) {
            synchronized (ConexionBD.class) {
                if (instancia == null) {
                    instancia = new ConexionBD();
                }
            }
        }
        return instancia;
    }

    public void conectar() {
        System.out.println("Conectando a la base de datos...");
    }

    public void desconectar() {
        System.out.println("Desconectando de la base de datos...");
    }
}

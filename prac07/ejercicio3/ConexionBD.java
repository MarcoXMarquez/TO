public class ConexionBD {
    private static ConexionBD instancia; // única instancia
    private boolean conectada = false;   // estado de la conexión

    // Constructor privado (evita nuevas instancias)
    private ConexionBD() {}

    // Método para obtener la única instancia
    public static synchronized ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD();
            System.out.println("Nueva conexión creada.");
        } else {
            System.out.println("Ya existe una conexión activa.");
        }
        return instancia;
    }

    public void conectar() {
        if (!conectada) {
            conectada = true;
            System.out.println("Conectado a la base de datos.");
        } else {
            System.out.println("Ya estaba conectado.");
        }
    }

    public void desconectar() {
        if (conectada) {
            conectada = false;
            System.out.println("Conexión cerrada.");
        } else {
            System.out.println("No hay conexión activa.");
        }
    }

    public void estado() {
        System.out.println("Estado: " + (conectada ? "Conectado" : "Desconectado"));
    }
}

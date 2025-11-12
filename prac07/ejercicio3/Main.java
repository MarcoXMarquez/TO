public class Main {
    public static void main(String[] args) {
        ConexionBD c1 = ConexionBD.getInstancia();
        c1.conectar();
        c1.estado();

        ConexionBD c2 = ConexionBD.getInstancia();
        c2.estado();

        c1.desconectar();
        c2.estado(); // misma instancia
    }
}

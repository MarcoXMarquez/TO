public class Main {
    public static void main(String[] args) {
        // Obtener la instancia singleton
        Configuracion c1 = Configuracion.getInstance();
        c1.setIdioma("es");
        c1.setZonaHoraria("America/Mexico_City");

        System.out.println("--- Desde c1 ---");
        c1.mostrar_configuracion();

        // Intentar obtener otra "instancia"
        Configuracion c2 = Configuracion.getInstance();
        System.out.println("\n--- Desde c2 (debe ser la misma instancia) ---");
        c2.mostrar_configuracion();

        // Verificar que son la misma referencia
        System.out.println();
        System.out.println("c1 == c2 ? " + (c1 == c2));
        System.out.println("identityHashCode c1: " + System.identityHashCode(c1));
        System.out.println("identityHashCode c2: " + System.identityHashCode(c2));
    }
}

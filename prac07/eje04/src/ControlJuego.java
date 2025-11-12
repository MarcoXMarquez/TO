package eje04;

public class ControlJuego {
    private static ControlJuego instancia;
    private int nivel;
    private int puntaje;
    private int vidas;

    // Constructor privado: evita instanciación externa
    private ControlJuego() {
        this.nivel = 1;
        this.puntaje = 0;
        this.vidas = 3;
    }

    // Método estático para obtener la única instancia
    public static ControlJuego getInstancia() {
        if (instancia == null) {
            instancia = new ControlJuego();
        }
        return instancia;
    }

    // Métodos de gestión del estado global del juego
    public void aumentarPuntaje(int puntos) {
        this.puntaje += puntos;
        System.out.println("Puntaje actual: " + puntaje);
    }

    public void perderVida() {
        if (vidas > 0) {
            vidas--;
        }
        System.out.println("Vidas restantes: " + vidas);
    }

    public void siguienteNivel() {
        nivel++;
        System.out.println("Has pasado al nivel " + nivel);
    }

    public void mostrarEstado() {
        System.out.println("=== ESTADO DEL JUEGO ===");
        System.out.println("Nivel: " + nivel);
        System.out.println("Puntaje: " + puntaje);
        System.out.println("Vidas: " + vidas);
        System.out.println("=========================");
    }
}

package eje04;

public class Main {
    public static void main(String[] args) {
        ControlJuego control = ControlJuego.getInstancia();

        Jugador jugador = new Jugador("Marco", 100);
        Enemigo enemigo1 = new Enemigo("Slime", 50);
        Enemigo enemigo2 = new Enemigo("Goblin", 60);

        control.mostrarEstado();

        // Simulación del juego
        jugador.actuar();
        enemigo1.actuar();
        jugador.actuar();
        enemigo2.actuar();
        control.siguienteNivel();

        // Verificar que todos usan la misma instancia del Singleton
        ControlJuego otroControl = ControlJuego.getInstancia();
        System.out.println("\n¿Es la misma instancia? " + (control == otroControl));

        otroControl.mostrarEstado();
    }
}

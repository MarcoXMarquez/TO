package eje04;

public class Jugador extends EntidadJuego {

    public Jugador(String nombre, int energia) {
        super(nombre, energia);
    }

    @Override
    public void actuar() {
        System.out.println(nombre + " derrota a un enemigo!");
        ControlJuego.getInstancia().aumentarPuntaje(100);
    }
}

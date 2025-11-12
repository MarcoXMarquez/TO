package eje04;

public class Enemigo extends EntidadJuego {

    public Enemigo(String nombre, int energia) {
        super(nombre, energia);
    }

    @Override
    public void actuar() {
        System.out.println(nombre + " ataca al jugador!");
        ControlJuego.getInstancia().perderVida();
    }
}

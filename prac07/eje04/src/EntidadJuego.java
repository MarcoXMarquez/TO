package eje04;

public abstract class EntidadJuego {
    protected String nombre;
    protected int energia;

    public EntidadJuego(String nombre, int energia) {
        this.nombre = nombre;
        this.energia = energia;
    }

    public abstract void actuar();
}

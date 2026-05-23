package unlar.edu.ar.ecoride_parcial.model;

public abstract class Usuario {

    private int id;
    private String nombre;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double aplicarDescuento(double total);
}

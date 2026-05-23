package unlar.edu.ar.ecoride_parcial.model;

public class UsuarioPremium extends Usuario {

    private double descuento;

    public UsuarioPremium(int id, String nombre, double descuento) {
        super(id, nombre);
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    public double aplicarDescuento(double total) {
        return total - (total * descuento);
    }
}
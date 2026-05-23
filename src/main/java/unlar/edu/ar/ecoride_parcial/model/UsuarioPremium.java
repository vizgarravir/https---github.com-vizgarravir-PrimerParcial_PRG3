package unlar.edu.ar.ecoride_parcial.model;

public class UsuarioPremium extends Usuario {

    private double descuento; // ej: 0.10 para 10%, 0.15 para 15%

    public UsuarioPremium(int id, String nombre, double descuento) {
        super(id, nombre);
        this.descuento = descuento;
    }

    @Override
    public double aplicarDescuento(double total) {
        return total - (total * descuento);
    }

    public double getDescuento() {
        return descuento;
    }
}

package unlar.edu.ar.ecoride_parcial.model;

public class UsuarioRegular extends Usuario {

    public UsuarioRegular(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public double aplicarDescuento(double total) {
        return total; // sin descuento
    }
}

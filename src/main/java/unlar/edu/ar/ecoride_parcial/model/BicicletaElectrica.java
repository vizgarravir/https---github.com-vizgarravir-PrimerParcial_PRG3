package unlar.edu.ar.ecoride_parcial.model;

public class BicicletaElectrica extends Vehiculo {

    private double capacidadCanasto; // en centímetros cúbicos

    public BicicletaElectrica(String patente, int bateria, double tarifaBase, double capacidadCanasto) {
        super(patente, bateria, tarifaBase);
        this.capacidadCanasto = capacidadCanasto;
    }

    public double getCapacidadCanasto() {
        return capacidadCanasto;
    }
}

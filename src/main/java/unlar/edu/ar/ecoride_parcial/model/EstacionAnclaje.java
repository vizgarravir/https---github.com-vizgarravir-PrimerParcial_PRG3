package unlar.edu.ar.ecoride_parcial.model;

import unlar.edu.ar.ecoride_parcial.exception.VehiculoNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class EstacionAnclaje {

    private String nombre;
    private List<Vehiculo> vehiculos;

    public EstacionAnclaje(String nombre) {
        this.nombre = nombre;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public Vehiculo buscarPorPatente(String patente) {
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                return v;
            }
        }
        throw new VehiculoNoEncontradoException("Vehículo No Encontrado");
    }

    public String getNombre() {
        return nombre;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}

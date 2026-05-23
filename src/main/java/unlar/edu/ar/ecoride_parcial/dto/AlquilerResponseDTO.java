package unlar.edu.ar.ecoride_parcial.dto;

public class AlquilerResponseDTO {

    private String patente;
    private double montoCobrado;
    private String mensaje;

    public AlquilerResponseDTO(String patente, double montoCobrado, String mensaje) {
        this.patente = patente;
        this.montoCobrado = montoCobrado;
        this.mensaje = mensaje;
    }

    public String getPatente() {
        return patente;
    }

    public double getMontoCobrado() {
        return montoCobrado;
    }

    public String getMensaje() {
        return mensaje;
    }
}
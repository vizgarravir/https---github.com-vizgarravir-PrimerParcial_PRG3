package unlar.edu.ar.ecoride_parcial.dto;

public class AlquilerRequestDTO {

    private int idUsuario;
    private String patente;
    private String metodoPago;

    public AlquilerRequestDTO() {}

    public AlquilerRequestDTO(int idUsuario, String patente, String metodoPago) {
        this.idUsuario = idUsuario;
        this.patente = patente;
        this.metodoPago = metodoPago;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
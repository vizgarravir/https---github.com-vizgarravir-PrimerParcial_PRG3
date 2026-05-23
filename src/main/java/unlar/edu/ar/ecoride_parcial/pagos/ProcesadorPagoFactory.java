package unlar.edu.ar.ecoride_parcial.pagos;
public class ProcesadorPagoFactory {

    public static ProcesadorPago obtener(String metodoPago) {
        if (metodoPago.equalsIgnoreCase("TARJETA")) {
            return new TarjetaDeCredito();
        } else if (metodoPago.equalsIgnoreCase("BILLETERA")) {
            return new BilleteraVirtual();
        } else {
            throw new IllegalArgumentException("Método de pago no reconocido: " + metodoPago);
        }
    }
}

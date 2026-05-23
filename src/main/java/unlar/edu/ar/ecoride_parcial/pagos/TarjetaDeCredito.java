package unlar.edu.ar.ecoride_parcial.pagos;

public class TarjetaDeCredito implements ProcesadorPago {

    @Override
    public void cobrar(double monto) {
        System.out.printf("Cobro exitoso de $%.2f realizado con Tarjeta de Crédito%n", monto);
    }
}

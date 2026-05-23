package unlar.edu.ar.ecoride_parcial.service;

import unlar.edu.ar.ecoride_parcial.dto.*;
import unlar.edu.ar.ecoride_parcial.exception.*;
import unlar.edu.ar.ecoride_parcial.model.*;
import unlar.edu.ar.ecoride_parcial.pagos.ProcesadorPago;
import unlar.edu.ar.ecoride_parcial.pagos.ProcesadorPagoFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlquilerService {

    private List<Usuario> usuarios;
    private EstacionAnclaje estacion;

    public AlquilerService() {
        usuarios = new ArrayList<>();
        estacion = new EstacionAnclaje("Estación Central");

        // Datos de prueba
        usuarios.add(new UsuarioRegular(1, "Juan Pérez"));
        usuarios.add(new UsuarioPremium(2, "María García", 0.15));

        estacion.agregarVehiculo(new Monopatin("ABC123", 80, 500.0, true));
        estacion.agregarVehiculo(new BicicletaElectrica("XYZ789", 10, 400.0, 1500.0));
        estacion.agregarVehiculo(new Monopatin("DEF456", 60, 450.0, false));
    }

    public AlquilerResponseDTO desbloquear(AlquilerRequestDTO request) {

        // 1. Localizar el vehículo en la estación por patente
        Vehiculo vehiculo = estacion.buscarPorPatente(request.getPatente());

        // 2. Validar batería >= 15%
        if (vehiculo.getBateria() < 15) {
            throw new BateriaInsuficienteException("Batería Insuficiente");
        }

        // 3. Buscar usuario y calcular importe con posible descuento
        Usuario usuario = buscarUsuarioPorId(request.getIdUsuario());
        double montoFinal = usuario.aplicarDescuento(vehiculo.getTarifaBase());

        // 4. Obtener procesador de pago via Factory
        ProcesadorPago procesador = ProcesadorPagoFactory.obtener(request.getMetodoPago());

        // 5. Efectuar el cobro
        procesador.cobrar(montoFinal);

        // 6. Retornar respuesta exitosa
        return new AlquilerResponseDTO(
                vehiculo.getPatente(),
                montoFinal,
                "Vehículo desbloqueado con éxito"
        );
    }

    private Usuario buscarUsuarioPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        throw new RuntimeException("Usuario no encontrado con id: " + id);
    }
}
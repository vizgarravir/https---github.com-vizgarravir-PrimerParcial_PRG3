package unlar.edu.ar.ecoride_parcial.controller;


import unlar.edu.ar.ecoride_parcial.dto.AlquilerRequestDTO;
import unlar.edu.ar.ecoride_parcial.dto.AlquilerResponseDTO;
import unlar.edu.ar.ecoride_parcial.exception.BateriaInsuficienteException;
import unlar.edu.ar.ecoride_parcial.exception.VehiculoNoEncontradoException;
import unlar.edu.ar.ecoride_parcial.service.AlquilerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alquileres")
public class AlquilerController {

    private final AlquilerService alquilerService;

    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @GetMapping("/desbloquear")
    public ResponseEntity<?> desbloquear(@RequestBody AlquilerRequestDTO request) {
        try {
            AlquilerResponseDTO response = alquilerService.desbloquear(request);
            return ResponseEntity.ok(response);
        } catch (VehiculoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BateriaInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

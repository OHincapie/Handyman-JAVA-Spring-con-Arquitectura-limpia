package co.com.ias.handyman.infranstructure.controllers;

import co.com.ias.handyman.infranstructure.models.ApplicationError;
import co.com.ias.handyman.infranstructure.models.ServiceDTO;
import co.com.ias.handyman.service.application.ports.input.QueryServiceByIdUseCase;
import co.com.ias.handyman.service.application.services.QueryServiceByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/services")
@CrossOrigin("*")
public class ServiceController {
    private final QueryServiceByIdUseCase queryServiceByIdUseCase;

    public ServiceController(QueryServiceByIdUseCase queryServiceByIdUseCase) {
        this.queryServiceByIdUseCase = queryServiceByIdUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        try {
            Optional<ServiceDTO> serviceDTO = queryServiceByIdUseCase.execute(id);
            if (serviceDTO.isPresent()) {
                return ResponseEntity.ok(serviceDTO.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        Map.of("status", "No exist service with this id")
                );
            }
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError(
                    "SystemError",
                    "Try more later",
                    Map.of()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }
}

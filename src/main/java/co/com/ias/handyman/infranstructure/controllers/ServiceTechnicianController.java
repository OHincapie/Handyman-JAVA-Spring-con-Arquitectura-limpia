package co.com.ias.handyman.infranstructure.controllers;

import co.com.ias.handyman.infranstructure.models.ApplicationError;
import co.com.ias.handyman.infranstructure.models.CalculatorHoursDTO;
import co.com.ias.handyman.infranstructure.models.ServiceTechnicianDTO;
import co.com.ias.handyman.serviceTechnician.application.ports.input.CalculatorHoursWorkUseCase;
import co.com.ias.handyman.serviceTechnician.application.ports.input.CreateServiceTechnicianUseCase;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/service-technician")
public class ServiceTechnicianController {

    private final CreateServiceTechnicianUseCase createServiceTechnicianUseCase;
    private final CalculatorHoursWorkUseCase calculatorHoursWorkUseCase;

    public ServiceTechnicianController(CreateServiceTechnicianUseCase createServiceTechnicianUseCase, CalculatorHoursWorkUseCase calculatorHoursWorkUseCase) {
        this.createServiceTechnicianUseCase = createServiceTechnicianUseCase;
        this.calculatorHoursWorkUseCase = calculatorHoursWorkUseCase;
    }

    @PostMapping
    public ResponseEntity<?> store(@RequestBody ServiceTechnicianDTO serviceTechnicianDTO) {
        try {
            ServiceTechnicianDTO output = createServiceTechnicianUseCase.execute(serviceTechnicianDTO);
            if(output.getStatus().equals("Can not be created")) {
                output.setStatus(output.getStatus() + " because the same service was recorded at this time or the technician has already performed a service at this time.");
                return ResponseEntity.status(BAD_REQUEST).body(output);
            } else {
                return ResponseEntity.status(CREATED).body(output);
            }

        } catch (NullPointerException | IllegalArgumentException e) {
            ApplicationError applicationError = new ApplicationError(
                    "InputDataValidationError",
                    "Bad input data",
                    Map.of("error", e.getMessage())
            );
            return ResponseEntity.status(BAD_REQUEST).body(applicationError);
        } catch (Exception e) {
            ApplicationError applicationError = new ApplicationError(
                    "SystemError",
                    "Try more later",
                    Map.of()
            );
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public ResponseEntity<?> calculate(@RequestParam(name = "idTechnician") Long idTechnician,
    @RequestParam("StartDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
    @RequestParam("FinalDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime finalDate) {
        try {
            ServiceTechnicianDTO serviceTechnicianDTO = new ServiceTechnicianDTO();
            serviceTechnicianDTO.setIdTechnician(idTechnician);
            serviceTechnicianDTO.setStartDate(startDate);
            serviceTechnicianDTO.setFinalDate(finalDate);
            Optional<List<CalculatorHoursDTO>> output = calculatorHoursWorkUseCase.execute(serviceTechnicianDTO);
            if(output.isPresent()) {
                return ResponseEntity.ok(output.get());
            } else {
                return ResponseEntity.status(BAD_REQUEST).body("The dates range aren't valid");
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            ApplicationError applicationError = new ApplicationError(
                    "InputDataValidationError",
                    "Bad input data",
                    Map.of("error", e.getMessage())
            );
            return ResponseEntity.status(BAD_REQUEST).body(applicationError);
        } catch (Exception e) {
            ApplicationError applicationError = new ApplicationError(
                    "SystemError",
                    "Try more later",
                    Map.of()
            );
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }
}

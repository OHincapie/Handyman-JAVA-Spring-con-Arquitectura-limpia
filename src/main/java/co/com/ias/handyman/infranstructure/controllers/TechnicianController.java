package co.com.ias.handyman.infranstructure.controllers;

import co.com.ias.handyman.infranstructure.models.ApplicationError;
import co.com.ias.handyman.infranstructure.models.TechnicianDTO;
import co.com.ias.handyman.technician.application.ports.input.QueryTechnicianByDocumentUseCase;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/technicians")
@CrossOrigin("*")
public class TechnicianController {

    private final QueryTechnicianByDocumentUseCase queryTechnicianByDocumentUseCase;

    public TechnicianController(QueryTechnicianByDocumentUseCase queryTechnicianByDocumentUseCase) {
        this.queryTechnicianByDocumentUseCase = queryTechnicianByDocumentUseCase;
    }

    @RequestMapping(value = "/document", method = RequestMethod.GET)
    public ResponseEntity<?> getTechnicianByDocument(@RequestParam(name = "type") String type, @RequestParam(name = "number") String number) {
        try {
            Pair<String, String> document = Pair.of(type, number);
            Optional<TechnicianDTO> technicianDTO = queryTechnicianByDocumentUseCase.execute(document);
            if (technicianDTO.isPresent()) {
                return ResponseEntity.ok(technicianDTO.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        Map.of("status", "Not found technician with this document")
                );
            }
        } catch (NullPointerException | IllegalArgumentException e) {
            ApplicationError applicationError = new ApplicationError(
                    "InputDataValidationError",
                    "Bad input data",
                    Map.of("error", e.getMessage())
            );
            System.out.println("Error get Technician by document: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception e) {
            ApplicationError applicationError = new ApplicationError(
                    "SystemError",
                    "Try later",
                    Map.of()
            );
            System.out.println("Error get Technician by document: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }


}

package co.com.ias.handyman.serviceTechnician.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceTechnicianIdTechnicianTest {

    @Test
    @DisplayName("Null Id Technician of ServiceTechnician should throw an error")
    void null_technician_id(){
        Long idTechnicianNull = null;
        assertThrows(NullPointerException.class, () -> {
            new ServiceTechnicianIdTechnician(idTechnicianNull);
        });
    }

    @Test
    @DisplayName("Valid technician id should not throw an error")
    void valid_technician_id(){
        Long idTechnicianValid = 2L;
        assertDoesNotThrow(() -> new ServiceTechnicianIdTechnician(idTechnicianValid));
    }
}
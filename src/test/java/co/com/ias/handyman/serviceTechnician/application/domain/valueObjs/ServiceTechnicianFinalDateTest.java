package co.com.ias.handyman.serviceTechnician.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceTechnicianFinalDateTest {

    @Test
    @DisplayName("The null final date of the Service Technician should throw an error")
    void null_final_date() {
        LocalDateTime finalDateNull = null;
        assertThrows(NullPointerException.class, ()-> {
            new ServiceTechnicianFinalDate(finalDateNull);
        });
    }

    @Test
    @DisplayName("The final date before a week ago should throw an error")
    void invalid_final_date_before_a_week() {
        LocalDateTime invalidDate = LocalDateTime.now().minusDays(8);
        assertThrows(IllegalArgumentException.class, ()-> {
            new ServiceTechnicianFinalDate(invalidDate);
        });
    }

    @Test
    @DisplayName("The final date after now should throw an error")
    void invalid_final_date_after_now() {
        LocalDateTime invalidDate = LocalDateTime.now().plusDays(1);
        assertThrows(IllegalArgumentException.class, ()-> {
            new ServiceTechnicianFinalDate(invalidDate);
        });
    }

    @Test
    @DisplayName("The valid final date of the Service Technician should not throw an error")
    void valid_final_date() {
        LocalDateTime finalDateValid = LocalDateTime.now();
        assertDoesNotThrow(() -> new ServiceTechnicianFinalDate(finalDateValid));
        //And now let's try with 2 days ago
        LocalDateTime finalDateValidTwoDays = LocalDateTime.now().minusDays(2);
        assertDoesNotThrow(() -> new ServiceTechnicianFinalDate(finalDateValidTwoDays));
    }
}
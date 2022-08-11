package co.com.ias.handyman.serviceTechnician.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceTechnicianStartDateTest {

    @Test
    @DisplayName("The null start date of the Service Technician should throw an error")
    void null_start_date() {
        LocalDateTime startDateNull = null;
        assertThrows(NullPointerException.class, ()-> {
            new ServiceTechnicianStartDate(startDateNull);
        });
    }

    @Test
    @DisplayName("The start date before a week ago should throw an error")
    void invalid_start_date_before_a_week() {
        LocalDateTime invalidDate = LocalDateTime.now().minusDays(8);
        assertThrows(IllegalArgumentException.class, ()-> {
            new ServiceTechnicianStartDate(invalidDate);
        });
    }

    @Test
    @DisplayName("The start date after now should throw an error")
    void invalid_start_date_after_now() {
        LocalDateTime invalidDate = LocalDateTime.now().plusDays(1);
        assertThrows(IllegalArgumentException.class, ()-> {
            new ServiceTechnicianStartDate(invalidDate);
        });
    }

    @Test
    @DisplayName("The valid start date of the Service Technician should not throw an error")
    void valid_start_date() {
        LocalDateTime startDateValid = LocalDateTime.now();
        assertDoesNotThrow(() -> new ServiceTechnicianStartDate(startDateValid));
        //And now let's try with 2 days ago
        LocalDateTime startDateValidTwoDays = LocalDateTime.now().minusDays(2);
        assertDoesNotThrow(() -> new ServiceTechnicianStartDate(startDateValidTwoDays));
    }
}
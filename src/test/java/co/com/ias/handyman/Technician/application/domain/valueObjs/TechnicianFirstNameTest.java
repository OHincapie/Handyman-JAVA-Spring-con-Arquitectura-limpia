package co.com.ias.handyman.Technician.application.domain.valueObjs;

import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianFirstName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TechnicianFirstNameTest {
    @Test
    @DisplayName("Null Technician First Name should throw an error")
    void null_technician_first_name() {
        String invalidName = null;

        assertThrows(NullPointerException.class, () -> {
            new TechnicianFirstName(invalidName);
        });
    }

    @Test
    @DisplayName("A name with length greater than 20 characters should throw an error")
    void invalid_first_name() {
        String invalidName = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaas";

        assertThrows(IllegalArgumentException.class, () -> {
            new TechnicianFirstName(invalidName);
        });
    }

}

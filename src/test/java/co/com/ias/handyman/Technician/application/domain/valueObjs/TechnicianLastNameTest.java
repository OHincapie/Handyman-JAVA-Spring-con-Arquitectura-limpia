package co.com.ias.handyman.Technician.application.domain.valueObjs;

import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianFirstName;
import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianLastName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TechnicianLastNameTest {
    @Test
    @DisplayName("Null Technician Last Name should throw an error")
    void null_technician_last_name() {
        String invalidLastName = null;

        assertThrows(NullPointerException.class, () -> {
            new TechnicianLastName(invalidLastName);
        });
    }

    @Test
    @DisplayName("A lastname with length greater than 20 characters should throw an error")
    void invalid_technician_last_name() {
        String invalidLastName = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        assertThrows(IllegalArgumentException.class, () ->{
           new TechnicianLastName(invalidLastName);
        });
    }
}

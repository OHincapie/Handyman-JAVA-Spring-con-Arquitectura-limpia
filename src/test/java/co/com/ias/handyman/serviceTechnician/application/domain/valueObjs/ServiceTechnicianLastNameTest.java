package co.com.ias.handyman.serviceTechnician.application.domain.valueObjs;

import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianLastName;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceTechnicianLastNameTest {
    @Test
    @DisplayName("Null lastName  should throw an error")
    void null_lastName() {
        String invalidateLastName = null;
        assertThrows(NullPointerException.class, () -> {
            new TechnicianLastName((invalidateLastName));
        });
    }
    @Test
    @DisplayName("Can't be no longer to 20 characters")
    void longerLastName(){
        String longLastName = "Esto es una prueba para mas de 20 caracteres";
        assertThrows(IllegalArgumentException.class, () ->{
            new TechnicianLastName(longLastName);
        });
    }
}

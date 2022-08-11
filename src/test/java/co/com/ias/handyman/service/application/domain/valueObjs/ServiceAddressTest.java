package co.com.ias.handyman.service.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceAddressTest {

    @Test
    @DisplayName("Null service address should throw an error")
    void nullServiceAddress() {
        String invalidAddress = null;
        assertThrows(NullPointerException.class, () -> new ServiceAddress(invalidAddress));
    }

    @Test
    @DisplayName("Valid service id should not throw an error")
    void validServiceAddress() {
        String validAddress= "Calle 25";
        assertDoesNotThrow(() -> new ServiceAddress(validAddress));
    }
}

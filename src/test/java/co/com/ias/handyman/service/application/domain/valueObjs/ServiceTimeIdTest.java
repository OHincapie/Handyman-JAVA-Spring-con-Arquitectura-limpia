package co.com.ias.handyman.service.application.domain.valueObjs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceTimeIdTest {

    @Test
    @DisplayName("Null service id should throw an error")
    void nullServiceId() {
        Long invalidTimeId = null;
        assertThrows(NullPointerException.class, () -> new ServiceTimeId(invalidTimeId));
    }

    @Test
    @DisplayName("Valid service id should not throw an error")
    void validServiceTimeId() {
        Long validId = 2L;
        assertDoesNotThrow(() -> new ServiceTimeId(validId));
    }
}

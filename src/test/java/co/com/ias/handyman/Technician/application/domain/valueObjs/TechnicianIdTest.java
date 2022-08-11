package co.com.ias.handyman.Technician.application.domain.valueObjs;

import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TechnicianIdTest {
    @Test
    @DisplayName("Null Techinician id should throw an error")
    void null_technician_id() {
        Long invalidId = null;

        assertThrows(NullPointerException.class, () ->{
            new TechnicianId(invalidId);
                });
    }
}

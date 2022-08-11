package co.com.ias.handyman.Technician.application.domain.valueObjs;

import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianDocumentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TechnicianDocumentTypeTest {
    @Test
    @DisplayName("Null Technician Document Type should throw an error")
    void null_technical_document_type() {
        String invalidDocumentType = null;

        assertThrows(NullPointerException.class, () -> {
            new TechnicianDocumentType(invalidDocumentType);
        });
    }
    @Test
    @DisplayName("A document type with length greater than 30 characters should throw an error")
    void invalid_document_type() {
        String invalidDocumentType = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        assertThrows(IllegalArgumentException.class, ()->{
           new TechnicianDocumentType(invalidDocumentType);
        });
    }
}

package co.com.ias.handyman.Technician.application.domain.valueObjs;

import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianDocumentNumber;
import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianDocumentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TechnicianDocumentNumberTest {
    @Test
    @DisplayName("Null Technician document number should throw an error")
    void null_technician_document_number() {
        String invalidDocumentNumber = null;

        assertThrows(NullPointerException.class, () ->{
            new TechnicianDocumentType(invalidDocumentNumber);
        });
    }

    @Test
    @DisplayName("A document number with length greater than 20 character should throw an error")
    void invalid_document_number() {
        String invalidDocumentNumber = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        assertThrows(IllegalArgumentException.class, ()->{
            new TechnicianDocumentNumber(invalidDocumentNumber);
        });
    }
}


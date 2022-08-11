package co.com.ias.handyman.technician.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class TechnicianDocumentNumber {
    private final String value;

    public TechnicianDocumentNumber(String value) {
        Validate.notNull(value, "Technician's document number can not be null");
        Validate.isTrue(value.length() <= 20, "Technician's document number can not be longer than 20 characters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DocumentNumberTechnician{" +
                "value='" + value + '\'' +
                '}';
    }
}

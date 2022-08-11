package co.com.ias.handyman.technician.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class TechnicianDocumentType {
    private final String value;

    public TechnicianDocumentType(String value) {
        Validate.notNull(value, "Technician's document type can not be null");
        Validate.isTrue(value.length() <= 30, "Technician's document type can not be longer than 30 characters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DocumentTypeTechnician{" +
                "value='" + value + '\'' +
                '}';
    }
}

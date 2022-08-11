package co.com.ias.handyman.technician.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class TechnicianFirstName {
    private final String value;

    public TechnicianFirstName(String value) {
        Validate.notNull(value, "Technician's first name can not be null");
        Validate.isTrue(value.length() <= 20, "Technician's first name can not be longer than 20 characters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "FirstNameTechnician{" +
                "value='" + value + '\'' +
                '}';
    }
}

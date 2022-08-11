package co.com.ias.handyman.technician.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class TechnicianId {
    private final Long value;

    public TechnicianId(Long value) {
        Validate.notNull(value, "Technician id can not be null");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TechnicianId{" +
                "value=" + value +
                '}';
    }
}

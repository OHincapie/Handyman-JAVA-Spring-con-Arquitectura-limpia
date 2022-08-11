package co.com.ias.handyman.serviceTechnician.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import java.util.Calendar;

public class ServiceTechnicianIdTechnician {
    private final Long value;

    public ServiceTechnicianIdTechnician(Long value) {
        Validate.notNull(value, "Technician id of Service Technician can not be null");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ServiceTechnicianIdTechnician{" +
                "value=" + value +
                '}';
    }
}

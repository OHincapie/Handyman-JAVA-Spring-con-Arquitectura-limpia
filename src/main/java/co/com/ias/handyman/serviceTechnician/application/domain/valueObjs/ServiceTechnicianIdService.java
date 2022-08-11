package co.com.ias.handyman.serviceTechnician.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ServiceTechnicianIdService {
    private final Long value;

    public ServiceTechnicianIdService(Long value) {
        Validate.notNull(value, "Id service of Service Technician can not be null");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ServiceTechnicianIdService{" +
                "value=" + value +
                '}';
    }
}

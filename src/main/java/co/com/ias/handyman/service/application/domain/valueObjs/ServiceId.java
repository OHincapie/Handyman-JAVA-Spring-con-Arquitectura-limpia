package co.com.ias.handyman.service.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ServiceId {
    private final Long value;

    public ServiceId(Long value) {
        Validate.notNull(value, "Service id can not be null");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ServiceId{" +
                "value=" + value +
                '}';
    }
}

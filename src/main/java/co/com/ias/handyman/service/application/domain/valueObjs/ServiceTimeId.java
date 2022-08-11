package co.com.ias.handyman.service.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ServiceTimeId {
    private final Long value;

    public ServiceTimeId(Long value) {
        Validate.notNull(value, "Time id can not be null");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ServiceTimeId{" +
                "value=" + value +
                '}';
    }
}

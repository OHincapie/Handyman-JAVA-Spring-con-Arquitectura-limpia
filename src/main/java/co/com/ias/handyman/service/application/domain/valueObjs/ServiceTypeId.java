package co.com.ias.handyman.service.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ServiceTypeId {

    private final Long value;

    public ServiceTypeId(Long value) {
        Validate.notNull(value, "Type service id can not be null");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ServiceTypeId{" +
                "value=" + value +
                '}';
    }
}

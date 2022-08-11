package co.com.ias.handyman.service.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ServiceUserId {
    private final Long value;

    public ServiceUserId(Long value) {
        Validate.notNull(value, "User id can not be null");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ServiceUserId{" +
                "value=" + value +
                '}';
    }
}

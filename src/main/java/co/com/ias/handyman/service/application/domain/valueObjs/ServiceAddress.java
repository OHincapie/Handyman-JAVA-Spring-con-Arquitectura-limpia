package co.com.ias.handyman.service.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class ServiceAddress {
    private final String value;

    public ServiceAddress(String value) {
        Validate.notNull(value, "The address can not be null");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ServiceAddress{" +
                "value='" + value + '\'' +
                '}';
    }
}

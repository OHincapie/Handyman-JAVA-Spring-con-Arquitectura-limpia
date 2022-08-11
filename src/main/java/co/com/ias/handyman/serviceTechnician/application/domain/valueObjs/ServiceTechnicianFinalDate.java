package co.com.ias.handyman.serviceTechnician.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

public class ServiceTechnicianFinalDate {
    private LocalDateTime value;

    public ServiceTechnicianFinalDate() {
    }

    public ServiceTechnicianFinalDate(LocalDateTime value) {
        Validate.notNull(value, "The final date can not be null");
        LocalDateTime auxDate = LocalDateTime.now().minusDays(7);
        Validate.isTrue(value.isAfter(auxDate), "The final date can not be before of seven days ago.");
        Validate.isTrue(value.isBefore(LocalDateTime.now()), "The final date can not be after of now.");
        this.value = value;
    }

    public LocalDateTime getValue() {
        return value;
    }

    public void setValue(LocalDateTime value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ServiceTechnicianFinalDate{" +
                "value=" + value +
                '}';
    }
}

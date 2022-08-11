package co.com.ias.handyman.service.application.ports.output;

import co.com.ias.handyman.service.application.domain.Service;
import co.com.ias.handyman.service.application.domain.valueObjs.ServiceId;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRepository {
    Optional<Service> get(ServiceId serviceId);
}

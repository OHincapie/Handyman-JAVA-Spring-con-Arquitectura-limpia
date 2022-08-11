package co.com.ias.handyman.service.application.services;

import co.com.ias.handyman.infranstructure.models.ServiceDTO;
import co.com.ias.handyman.service.application.domain.valueObjs.ServiceId;
import co.com.ias.handyman.service.application.ports.input.QueryServiceByIdUseCase;
import co.com.ias.handyman.service.application.ports.output.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryServiceByIdService implements QueryServiceByIdUseCase {

    private final ServiceRepository serviceRepository;

    public QueryServiceByIdService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Optional<ServiceDTO> execute(Long id) {
        ServiceId serviceId = new ServiceId(id);
        Optional<co.com.ias.handyman.service.application.domain.Service> service = serviceRepository.get(serviceId);
        return service.map(ServiceDTO::fromDomain);
    }
}

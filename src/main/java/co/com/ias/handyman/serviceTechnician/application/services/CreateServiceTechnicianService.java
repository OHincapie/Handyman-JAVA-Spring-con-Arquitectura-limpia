package co.com.ias.handyman.serviceTechnician.application.services;

import co.com.ias.handyman.infranstructure.models.ServiceTechnicianDTO;
import co.com.ias.handyman.serviceTechnician.application.domain.ServiceTechnician;
import co.com.ias.handyman.serviceTechnician.application.ports.input.CreateServiceTechnicianUseCase;
import co.com.ias.handyman.serviceTechnician.application.ports.output.ServiceTechnicianRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateServiceTechnicianService implements CreateServiceTechnicianUseCase {
    private final ServiceTechnicianRepository serviceTechnicianRepository;

    public CreateServiceTechnicianService(ServiceTechnicianRepository repository) {
        this.serviceTechnicianRepository = repository;
    }

    @Override
    public ServiceTechnicianDTO execute(ServiceTechnicianDTO serviceTechnicianDTO) {
        ServiceTechnician serviceTechnician = serviceTechnicianDTO.toDomain();

        boolean serviceExist = serviceExistsBetweenDates(serviceTechnician);
        boolean technicianExist = technicianExistBetweenDates(serviceTechnician);

        if(!(serviceExist || technicianExist)) {
            serviceTechnicianDTO.setStatus("Created");
            serviceTechnicianRepository.store(serviceTechnician);
        }
        return serviceTechnicianDTO;

    }

    public boolean serviceExistsBetweenDates(ServiceTechnician serviceTechnician) {
        return serviceTechnicianRepository.getServiceBetweenDates(
            serviceTechnician.getStartDate(),
            serviceTechnician.getFinalDate(),
            serviceTechnician.getIdService()
        ).isPresent();
    }

    public  boolean technicianExistBetweenDates(ServiceTechnician serviceTechnician) {
        return serviceTechnicianRepository.getTechnicianBetweenDates(
            serviceTechnician.getStartDate(),
            serviceTechnician.getFinalDate(),
            serviceTechnician.getIdTechnician()
        ).isPresent();
    }


}

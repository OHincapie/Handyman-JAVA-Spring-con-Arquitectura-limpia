package co.com.ias.handyman.infranstructure.models;

import co.com.ias.handyman.service.application.domain.Service;
import co.com.ias.handyman.serviceTechnician.application.domain.ServiceTechnician;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianFinalDate;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianIdService;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianIdTechnician;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianStartDate;

import java.time.LocalDateTime;

public class ServiceTechnicianDTO {
    private Long idService;
    private Long idTechnician;
    private LocalDateTime startDate;
    private LocalDateTime finalDate;
    private String status;

    public ServiceTechnicianDTO() {
    }

    public ServiceTechnicianDTO(Long idService, Long idTechnician, LocalDateTime startDate, LocalDateTime finalDate) {
        this.idService = idService;
        this.idTechnician = idTechnician;
        this.startDate = startDate;
        this.finalDate = finalDate;
    }

    public ServiceTechnician toDomain() {
        return new ServiceTechnician(
                new ServiceTechnicianIdService(idService),
                new ServiceTechnicianIdTechnician(idTechnician),
                new ServiceTechnicianStartDate(startDate),
                new ServiceTechnicianFinalDate(finalDate)
        );
    }

    public static ServiceTechnicianDTO fromDomain(ServiceTechnician serviceTechnician) {
        return  new ServiceTechnicianDTO(
                serviceTechnician.getIdService().getValue(),
                serviceTechnician.getIdTechnician().getValue(),
                serviceTechnician.getStartDate().getValue(),
                serviceTechnician.getFinalDate().getValue()
        );
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    public Long getIdTechnician() {
        return idTechnician;
    }

    public void setIdTechnician(Long idTechnician) {
        this.idTechnician = idTechnician;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDateTime finalDate) {
        this.finalDate = finalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServiceTechnicianDTO{" +
                "idService=" + idService +
                ", idTechnician=" + idTechnician +
                ", startDate=" + startDate +
                ", finalDate=" + finalDate +
                ", status='" + status + '\'' +
                '}';
    }
}

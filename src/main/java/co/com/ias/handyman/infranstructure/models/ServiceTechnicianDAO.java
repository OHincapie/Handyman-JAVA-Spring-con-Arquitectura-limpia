package co.com.ias.handyman.infranstructure.models;

import co.com.ias.handyman.service.application.domain.Service;
import co.com.ias.handyman.serviceTechnician.application.domain.ServiceTechnician;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianFinalDate;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianIdService;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianIdTechnician;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianStartDate;
import org.apache.tomcat.jni.Local;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ServiceTechnicianDAO {
    private Long idService;
    private Long idTechnician;
    private LocalDateTime startDate;
    private LocalDateTime finalDate;

    public ServiceTechnicianDAO() {
    }

    public ServiceTechnicianDAO(Long idService, Long idTechnician, LocalDateTime startDate, LocalDateTime finalDate) {
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

    public ServiceTechnician toDomainToDates() {
        ServiceTechnicianStartDate serviceTechnicianStartDate = new ServiceTechnicianStartDate();
        ServiceTechnicianFinalDate serviceTechnicianFinalDate = new ServiceTechnicianFinalDate();
        serviceTechnicianStartDate.setValue(startDate);
        serviceTechnicianFinalDate.setValue(finalDate);
        return new ServiceTechnician(
                new ServiceTechnicianIdService(idService),
                new ServiceTechnicianIdTechnician(idTechnician),
                serviceTechnicianStartDate,
                serviceTechnicianFinalDate
        );
    }

    public static ServiceTechnicianDAO fromDomain(ServiceTechnician serviceTechnician) {
        return  new ServiceTechnicianDAO(
                serviceTechnician.getIdService().getValue(),
                serviceTechnician.getIdTechnician().getValue(),
                serviceTechnician.getStartDate().getValue(),
                serviceTechnician.getFinalDate().getValue()
        );
    }

    public static ServiceTechnicianDAO fromResultSet(ResultSet resultSet) throws SQLException {
        return new ServiceTechnicianDAO(
                resultSet.getLong("service_id"),
                resultSet.getLong("technician_id"),
                resultSet.getTimestamp("start_date").toLocalDateTime(),
                resultSet.getTimestamp("final_date").toLocalDateTime()
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

    @Override
    public String toString() {
        return "ServiceTechnicianDAO{" +
                "idService=" + idService +
                ", idTechnician=" + idTechnician +
                ", startDate=" + startDate +
                ", finalDate=" + finalDate +
                '}';
    }
}

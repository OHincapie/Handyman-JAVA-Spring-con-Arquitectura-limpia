package co.com.ias.handyman.serviceTechnician.application.domain;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianFinalDate;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianIdTechnician;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianStartDate;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianIdService;
public class ServiceTechnician {

    private final ServiceTechnicianIdService idService;
    private final ServiceTechnicianIdTechnician idTechnician;
    private final ServiceTechnicianStartDate startDate;
    private final ServiceTechnicianFinalDate finalDate;

    public ServiceTechnician(ServiceTechnicianIdService idService, ServiceTechnicianIdTechnician idTechnician, ServiceTechnicianStartDate startDate, ServiceTechnicianFinalDate finalDate) {
        this.idService = idService;
        this.idTechnician = idTechnician;
        this.startDate = startDate;
        this.finalDate = finalDate;
    }

    public ServiceTechnicianIdService getIdService() {
        return idService;
    }

    public ServiceTechnicianIdTechnician getIdTechnician() {
        return idTechnician;
    }

    public ServiceTechnicianStartDate getStartDate() {
        return startDate;
    }

    public ServiceTechnicianFinalDate getFinalDate() {
        return finalDate;
    }

    @Override
    public String toString() {
        return "ServiceTechnician{" +
                "idService=" + idService +
                ", idTechnician=" + idTechnician +
                ", startDate=" + startDate +
                ", finalDate=" + finalDate +
                '}';
    }
}

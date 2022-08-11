package co.com.ias.handyman.infranstructure.models;

import co.com.ias.handyman.serviceTechnician.application.domain.ServiceTechnician;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianFinalDate;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianIdService;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianIdTechnician;
import co.com.ias.handyman.serviceTechnician.application.domain.valueObjs.ServiceTechnicianStartDate;

import java.time.LocalDateTime;

public class CalculatorHoursDTO {

    private Long idService;
    private Long idTechnician;
    private LocalDateTime startDate;
    private LocalDateTime finalDate;
    private Double regularHours;
    private Double nightHour;
    private Double sundayHour;
    private Double regularHourExtra;
    private Double nightHourExtra;
    private Double sundayHourExtra;
    private Double totalHoursByService;
    private Double totalHours;

    public CalculatorHoursDTO(Long idService, Long idTechnician, LocalDateTime startDate, LocalDateTime finalDate, Double regularHours, Double nightHour, Double sundayHour, Double regularHourExtra, Double nightHourExtra, Double sundayHourExtra, Double totalHoursByService,Double totalHours) {
        this.idService = idService;
        this.idTechnician = idTechnician;
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.regularHours = regularHours;
        this.nightHour = nightHour;
        this.sundayHour = sundayHour;
        this.regularHourExtra = regularHourExtra;
        this.nightHourExtra = nightHourExtra;
        this.sundayHourExtra = sundayHourExtra;
        this.totalHoursByService = totalHoursByService;
        this.totalHours = totalHours;
    }

    public CalculatorHoursDTO() {
    }


    public static CalculatorHoursDTO fromDomain(ServiceTechnician serviceTechnician) {

        return  new CalculatorHoursDTO(
                serviceTechnician.getIdService().getValue(),
                serviceTechnician.getIdTechnician().getValue(),
                serviceTechnician.getStartDate().getValue(),
                serviceTechnician.getFinalDate().getValue(),
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0
        );
    }

    public ServiceTechnician toDomain() {
        return new ServiceTechnician(
                new ServiceTechnicianIdService(idService),
                new ServiceTechnicianIdTechnician(idTechnician),
                new ServiceTechnicianStartDate(startDate),
                new ServiceTechnicianFinalDate(finalDate)
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

    public Double getRegularHours() {
        return regularHours;
    }

    public void setRegularHours(Double regularHours) {
        this.regularHours = regularHours;
    }

    public Double getNightHour() {
        return nightHour;
    }

    public void setNightHour(Double nightHour) {
        this.nightHour = nightHour;
    }

    public Double getSundayHour() {
        return sundayHour;
    }

    public void setSundayHour(Double sundayHour) {
        this.sundayHour = sundayHour;
    }

    public Double getRegularHourExtra() {
        return regularHourExtra;
    }

    public void setRegularHourExtra(Double regularHourExtra) {
        this.regularHourExtra = regularHourExtra;
    }

    public Double getNightHourExtra() {
        return nightHourExtra;
    }

    public void setNightHourExtra(Double nightHourExtra) {
        this.nightHourExtra = nightHourExtra;
    }

    public Double getSundayHourExtra() {
        return sundayHourExtra;
    }

    public void setSundayHourExtra(Double sundayHourExtra) {
        this.sundayHourExtra = sundayHourExtra;
    }

    public Double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(Double totalHours) {
        this.totalHours = totalHours;
    }

    public Double getTotalHoursByService() {
        return totalHoursByService;
    }

    public void setTotalHoursByService(Double totalHoursByService) {
        this.totalHoursByService = totalHoursByService;
    }

    @Override
    public String toString() {
        return "CalculatorHoursDTO{" +
                "idService=" + idService +
                ", idTechnician=" + idTechnician +
                ", startDate=" + startDate +
                ", finalDate=" + finalDate +
                ", regularHours=" + regularHours +
                ", nightHour=" + nightHour +
                ", sundayHour=" + sundayHour +
                ", regularHourExtra=" + regularHourExtra +
                ", nightHourExtra=" + nightHourExtra +
                ", sundayHourExtra=" + sundayHourExtra +
                ", totalHoursByService=" + totalHoursByService +
                ", totalHours=" + totalHours +
                '}';
    }
}

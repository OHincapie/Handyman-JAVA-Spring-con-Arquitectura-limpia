package co.com.ias.handyman.infranstructure.models;

import co.com.ias.handyman.service.application.domain.Service;
import co.com.ias.handyman.service.application.domain.valueObjs.*;

public class ServiceDTO {
    private Long id;
    private Long typeId;
    private String address;
    private Long timeId;
    private Long userId;

    public ServiceDTO(Long id, Long typeId, String address, Long timeId, Long userId) {
        this.id = id;
        this.typeId = typeId;
        this.address = address;
        this.timeId = timeId;
        this.userId = userId;
    }

    public ServiceDTO() {
    }

    public Service toDomain() {
        return new Service(
                new ServiceId(id),
                new ServiceTypeId(typeId),
                new ServiceAddress(address),
                new ServiceTimeId(timeId),
                new ServiceUserId(userId)
        );
    }

    public static ServiceDTO fromDomain(Service service){
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(service.getId().getValue());
        serviceDTO.setTypeId(service.getTypeId().getValue());
        serviceDTO.setAddress(service.getAddress().getValue());
        serviceDTO.setTimeId(service.getTimeId().getValue());
        serviceDTO.setUserId(service.getTimeId().getValue());
        return serviceDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTimeId() {
        return timeId;
    }

    public void setTimeId(Long timeId) {
        this.timeId = timeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ServiceDTO{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", address='" + address + '\'' +
                ", timeId=" + timeId +
                ", userId=" + userId +
                '}';
    }
}

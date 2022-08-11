package co.com.ias.handyman.service.application.domain;

import co.com.ias.handyman.service.application.domain.valueObjs.*;

public class Service {
    private final ServiceId id;
    private final ServiceTypeId typeId;
    private final ServiceAddress address;
    private final ServiceTimeId timeId;

    private final ServiceUserId userId;

    public Service(ServiceId id, ServiceTypeId typeId, ServiceAddress address, ServiceTimeId timeId, ServiceUserId userId) {
        this.id = id;
        this.address = address;
        this.timeId = timeId;
        this.typeId = typeId;
        this.userId = userId;
    }

    public ServiceId getId() {
        return id;
    }

    public ServiceAddress getAddress() {
        return address;
    }

    public ServiceTimeId getTimeId() {
        return timeId;
    }

    public ServiceTypeId getTypeId() {
        return typeId;
    }

    public ServiceUserId getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", address=" + address +
                ", timeId=" + timeId +
                ", typeId=" + typeId +
                ", userId=" + userId +
                '}';
    }
}

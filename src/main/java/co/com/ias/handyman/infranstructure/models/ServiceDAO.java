package co.com.ias.handyman.infranstructure.models;

import co.com.ias.handyman.service.application.domain.Service;
import co.com.ias.handyman.service.application.domain.valueObjs.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceDAO {
    private Long id;
    private Long typeId;
    private String address;
    private Long timeId;
    private Long userId;

    public ServiceDAO(Long id, Long typeId, String address, Long timeId, Long userId) {
        this.id = id;
        this.typeId = typeId;
        this.address = address;
        this.timeId = timeId;
        this.userId = userId;
    }

    public Service toDomain() {
        Service service = new Service(
                new ServiceId(id),
                new ServiceTypeId(typeId),
                new ServiceAddress(address),
                new ServiceTimeId(timeId),
                new ServiceUserId(userId)
        );
        return service;
    }
    public static ServiceDAO fromDomain(Service service){
        ServiceDAO serviceDAO = new ServiceDAO();
        serviceDAO.setId(service.getId().getValue());
        serviceDAO.setTypeId(service.getTypeId().getValue());
        serviceDAO.setAddress(service.getAddress().getValue());
        serviceDAO.setTimeId(service.getTimeId().getValue());
        serviceDAO.setUserId(service.getTimeId().getValue());
        return serviceDAO;

    }
    public static ServiceDAO fromResultSet(ResultSet resultSet) throws SQLException {
        return new ServiceDAO(
                resultSet.getLong("id"),
                resultSet.getLong("type_id"),
                resultSet.getString("address"),
                resultSet.getLong("time_id"),
                resultSet.getLong("user_id")
        );
    }
    public ServiceDAO() {
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
}

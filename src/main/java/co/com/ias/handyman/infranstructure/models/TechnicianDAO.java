package co.com.ias.handyman.infranstructure.models;

import co.com.ias.handyman.technician.application.domain.Technician;
import co.com.ias.handyman.technician.application.domain.valueObjs.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TechnicianDAO {

    private Long id;
    private String documentType;
    private String documentNumber;
    private String firstName;
    private String lastName;

    public TechnicianDAO(Long id, String documentType, String documentNumber, String firstName, String lastName) {
        this.id = id;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TechnicianDAO() {
    }

    public Technician toDomain() {
        return new Technician(
                new TechnicianId(id),
                new TechnicianDocumentType(documentType),
                new TechnicianDocumentNumber(documentNumber),
                new TechnicianFirstName(firstName),
                new TechnicianLastName(lastName)
        );
    }

    public static TechnicianDAO fromDomain(Technician technician) {
        TechnicianDAO technicianDAO = new TechnicianDAO();
        technicianDAO.setId(technician.getId().getValue());
        technicianDAO.setDocumentType(technician.getDocumentType().getValue());
        technicianDAO.setDocumentNumber(technician.getDocumentNumber().getValue());
        technicianDAO.setFirstName(technician.getFirstName().getValue());
        technicianDAO.setLastName(technician.getLastName().getValue());
        return technicianDAO;
    }

    public static TechnicianDAO fromResultSet(ResultSet resultSet) throws SQLException {
        return new TechnicianDAO(
                resultSet.getLong("id"),
                resultSet.getString("document_type"),
                resultSet.getString("document_number"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name")
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}



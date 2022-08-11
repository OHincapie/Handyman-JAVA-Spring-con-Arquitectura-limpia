package co.com.ias.handyman.infranstructure.models;

import co.com.ias.handyman.technician.application.domain.Technician;
import co.com.ias.handyman.technician.application.domain.valueObjs.*;

public class TechnicianDTO {
    private Long id;
    private String documentType;
    private String documentNumber;
    private String firstName;
    private String lastName;

    public TechnicianDTO(Long id, String documentType, String documentNumber, String firstName, String lastName) {
        this.id = id;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TechnicianDTO() {
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

    public static TechnicianDTO fromDomain(Technician technician) {
        TechnicianDTO technicianDTO = new TechnicianDTO();
        technicianDTO.setId(technician.getId().getValue());
        technicianDTO.setDocumentType(technician.getDocumentType().getValue());
        technicianDTO.setDocumentNumber(technician.getDocumentNumber().getValue());
        technicianDTO.setFirstName(technician.getFirstName().getValue());
        technicianDTO.setLastName(technician.getLastName().getValue());
        return  technicianDTO;
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

    @Override
    public String toString() {
        return "TechnicianDTO{" +
                "id=" + id +
                ", documentType='" + documentType + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

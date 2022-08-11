package co.com.ias.handyman.technician.application.domain;

import co.com.ias.handyman.technician.application.domain.valueObjs.*;

public class Technician {
    private final TechnicianId id;
    private final TechnicianDocumentType documentType;
    private final TechnicianDocumentNumber documentNumber;
    private final TechnicianFirstName firstName;
    private final TechnicianLastName lastName;

    public Technician(TechnicianId id, TechnicianDocumentType documentType, TechnicianDocumentNumber documentNumber, TechnicianFirstName firstName, TechnicianLastName lastName) {
        this.id = id;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public TechnicianId getId() {
        return id;
    }

    public TechnicianDocumentType getDocumentType() {
        return documentType;
    }

    public TechnicianDocumentNumber getDocumentNumber() {
        return documentNumber;
    }

    public TechnicianFirstName getFirstName() {
        return firstName;
    }

    public TechnicianLastName getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Technician{" +
                "id=" + id +
                ", documentType=" + documentType +
                ", documentNumber=" + documentNumber +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                '}';
    }
}

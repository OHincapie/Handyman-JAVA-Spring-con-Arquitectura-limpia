package co.com.ias.handyman.technician.application.ports.output;

import co.com.ias.handyman.technician.application.domain.Technician;
import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianDocumentNumber;
import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianDocumentType;

import java.util.Optional;

public interface TechnicianRepository {

    Optional<Technician> getByDocument(TechnicianDocumentType documentType, TechnicianDocumentNumber documentNumber);

}

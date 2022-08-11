package co.com.ias.handyman.technician.application.services;

import co.com.ias.handyman.infranstructure.models.TechnicianDTO;
import co.com.ias.handyman.technician.application.domain.Technician;
import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianDocumentNumber;
import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianDocumentType;
import co.com.ias.handyman.technician.application.ports.input.QueryTechnicianByDocumentUseCase;
import co.com.ias.handyman.technician.application.ports.output.TechnicianRepository;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryTechnicianByDocumentService implements QueryTechnicianByDocumentUseCase {

    private final TechnicianRepository technicianRepository;

    public QueryTechnicianByDocumentService(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @Override
    public Optional<TechnicianDTO> execute(Pair<String, String> technicianDocument) {
        TechnicianDocumentType technicianDocumentType = new TechnicianDocumentType(technicianDocument.getKey());
        TechnicianDocumentNumber technicianDocumentNumber = new TechnicianDocumentNumber(technicianDocument.getValue());
        Optional<Technician> technicianOptional = technicianRepository.getByDocument(technicianDocumentType,technicianDocumentNumber);
        return technicianOptional.map( technician -> TechnicianDTO.fromDomain(technician));
    }
}

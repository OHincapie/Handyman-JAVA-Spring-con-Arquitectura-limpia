package co.com.ias.handyman.technician.application.ports.input;

import co.com.ias.handyman.commons.UseCase;
import co.com.ias.handyman.infranstructure.models.TechnicianDTO;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;

public interface QueryTechnicianByDocumentUseCase extends UseCase<Pair<String, String>, Optional<TechnicianDTO>> {
}

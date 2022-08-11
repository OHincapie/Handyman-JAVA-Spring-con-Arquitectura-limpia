package co.com.ias.handyman.service.application.ports.input;

import co.com.ias.handyman.commons.UseCase;
import co.com.ias.handyman.infranstructure.models.ServiceDTO;

import java.util.Optional;

public interface QueryServiceByIdUseCase extends UseCase<Long, Optional<ServiceDTO>>{
}

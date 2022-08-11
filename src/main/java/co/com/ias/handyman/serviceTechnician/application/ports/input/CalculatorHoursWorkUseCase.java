package co.com.ias.handyman.serviceTechnician.application.ports.input;

import co.com.ias.handyman.commons.UseCase;
import co.com.ias.handyman.infranstructure.models.CalculatorHoursDTO;
import co.com.ias.handyman.infranstructure.models.ServiceTechnicianDTO;

import java.util.List;
import java.util.Optional;

public interface CalculatorHoursWorkUseCase extends UseCase<ServiceTechnicianDTO, Optional<List<CalculatorHoursDTO>>> {
}

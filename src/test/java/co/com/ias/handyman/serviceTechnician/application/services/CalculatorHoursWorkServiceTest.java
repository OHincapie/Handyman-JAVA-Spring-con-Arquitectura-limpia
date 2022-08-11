package co.com.ias.handyman.serviceTechnician.application.services;

import co.com.ias.handyman.infranstructure.models.CalculatorHoursDTO;
import co.com.ias.handyman.infranstructure.models.ServiceTechnicianDTO;
import co.com.ias.handyman.serviceTechnician.application.domain.ServiceTechnician;
import co.com.ias.handyman.serviceTechnician.application.ports.output.ServiceTechnicianRepository;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
class CalculatorHoursWorkServiceTest {

    @Mock
    private ServiceTechnicianRepository repository;

    @InjectMocks
    private CalculatorHoursWorkService calculatorHoursWorkService;


    @Test
    @DisplayName("ServiceTechnicianDTO  valid should return an ServiceTechnicianDTO")
    void createServiceTechnicianWhenDTOIsValid() {
        CalculatorHoursWorkService spy = mock(CalculatorHoursWorkService.class);
        CalculatorHoursDTO calculatorHoursDTO = mock(CalculatorHoursDTO.class);
        ServiceTechnicianDTO serviceTechnicianDTO = mock(ServiceTechnicianDTO.class);
        ServiceTechnician serviceTechnician = mock(ServiceTechnician.class);
        ServiceTechnicianDTO dtoServiceTechnician = new ServiceTechnicianDTO(2L, 2L, LocalDateTime.now().minusDays(5), LocalDateTime.now());
        ServiceTechnician serviceTechnician1 =dtoServiceTechnician.toDomain();
        when(serviceTechnicianDTO.toDomain()).thenReturn(serviceTechnician);
        when(calculatorHoursDTO.toDomain()).thenReturn(serviceTechnician);
    }

    @Test
    @DisplayName("The hour should be a regular hour when the hours of the week are lower than 48")
    void whenUseTheCalculateMethodReturnAMap() {
        CalculatorHoursWorkService spy = mock(CalculatorHoursWorkService.class);
        CalculatorHoursDTO calculatorHoursDTO = mock(CalculatorHoursDTO.class);
        Map<String, Double> hours = new HashMap<>();
        hours.put("NightHour", 7.0);
        doReturn(hours).when(spy).calculateHours(calculatorHoursDTO, LocalDateTime.now().minusDays(7), LocalDateTime.now(), 0.0);

    }

    @Test
    @DisplayName("The hour should be a regular hour when the hours of the week are lower than 48")
    void regularHour() {
        CalculatorHoursWorkService spy = mock(CalculatorHoursWorkService.class);

        doReturn("HNOREXTRA").when(spy).qualifyHours(LocalDateTime.of(2022, 10, 5,11,0), 0.0);
    }

    @Test
    @DisplayName("The hour should be an extra regular hour when the hours of the week are greater than 48")
    void regularExtraHour() {
        CalculatorHoursWorkService spy = mock(CalculatorHoursWorkService.class);

        doReturn("HNOREXTRA").when(spy).qualifyHours(LocalDateTime.of(2022, 10, 5,11,0), 48.0);
    }
}
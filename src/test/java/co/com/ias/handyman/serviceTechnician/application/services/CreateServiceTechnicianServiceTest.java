package co.com.ias.handyman.serviceTechnician.application.services;

import co.com.ias.handyman.infranstructure.models.ServiceTechnicianDTO;
import co.com.ias.handyman.serviceTechnician.application.domain.ServiceTechnician;
import co.com.ias.handyman.serviceTechnician.application.ports.output.ServiceTechnicianRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class CreateServiceTechnicianServiceTest {

    @Mock
    private ServiceTechnicianRepository repository;

    @InjectMocks
    private CreateServiceTechnicianService createServiceTechnicianService;

    @Test
    @DisplayName("ServiceTechnicianDTO  valid should return an ServiceTechnicianDTO")
    void createServiceTechnicianWhenDTOIsValid() {
        String status = "Created";
        CreateServiceTechnicianService spy = mock(CreateServiceTechnicianService.class);

        ServiceTechnicianDTO serviceTechnicianDTO = mock(ServiceTechnicianDTO.class);
        ServiceTechnician serviceTechnician = mock(ServiceTechnician.class);

        when(serviceTechnicianDTO.toDomain()).thenReturn(serviceTechnician);

        doReturn(false).when(spy).serviceExistsBetweenDates(serviceTechnician);
        doReturn(false).when(spy).technicianExistBetweenDates(serviceTechnician);

        when(serviceTechnicianDTO.getStatus()).thenReturn(status);

        doNothing().when(serviceTechnicianDTO).setStatus(status);

        doNothing().when(repository).store(serviceTechnician);

        assertNotNull(createServiceTechnicianService.execute(serviceTechnicianDTO));
        assertEquals(serviceTechnicianDTO, serviceTechnicianDTO);

    }

    @Test
    @DisplayName("if exist a service should return a ServiceTechnicianDTO with status by default")
    void createServiceTechnicianWhenServiceExists() {
        CreateServiceTechnicianService spy = mock(CreateServiceTechnicianService.class);

        ServiceTechnicianDTO serviceTechnicianDTO = mock(ServiceTechnicianDTO.class);
        ServiceTechnician serviceTechnician = mock(ServiceTechnician.class);

        when(serviceTechnicianDTO.toDomain()).thenReturn(serviceTechnician);

        doReturn(true).when(spy).serviceExistsBetweenDates(serviceTechnician);
        doReturn(false).when(spy).technicianExistBetweenDates(serviceTechnician);

        assertNotNull(createServiceTechnicianService.execute(serviceTechnicianDTO));
        assertEquals(serviceTechnicianDTO, serviceTechnicianDTO);

    }

    @Test
    @DisplayName("ServiceTechnicianDTO  if exist a technician should return a ServiceTechnicianDTO with the status by default")
    void createServiceTechnicianWhenTechnicianExist() {
        CreateServiceTechnicianService spy = mock(CreateServiceTechnicianService.class);

        ServiceTechnicianDTO serviceTechnicianDTO = mock(ServiceTechnicianDTO.class);
        ServiceTechnician serviceTechnician = mock(ServiceTechnician.class);

        when(serviceTechnicianDTO.toDomain()).thenReturn(serviceTechnician);

        doReturn(false).when(spy).serviceExistsBetweenDates(serviceTechnician);
        doReturn(true).when(spy).technicianExistBetweenDates(serviceTechnician);

        assertNotNull(createServiceTechnicianService.execute(serviceTechnicianDTO));
        assertEquals(serviceTechnicianDTO, serviceTechnicianDTO);

    }

    @Test
    @DisplayName("if exist a technician and a service should return a ServiceTechnicianDTO with the status by default")
    void createServiceTechnicianWhenTechnicianAndServiceExist() {
        CreateServiceTechnicianService spy = mock(CreateServiceTechnicianService.class);

        ServiceTechnicianDTO serviceTechnicianDTO = mock(ServiceTechnicianDTO.class);
        ServiceTechnician serviceTechnician = mock(ServiceTechnician.class);

        when(serviceTechnicianDTO.toDomain()).thenReturn(serviceTechnician);

        doReturn(true).when(spy).serviceExistsBetweenDates(serviceTechnician);
        doReturn(true).when(spy).technicianExistBetweenDates(serviceTechnician);

        assertNotNull(createServiceTechnicianService.execute(serviceTechnicianDTO));
        assertEquals(serviceTechnicianDTO, serviceTechnicianDTO);

    }

}





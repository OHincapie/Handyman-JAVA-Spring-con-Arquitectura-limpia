package co.com.ias.handyman.service.application.services;

import co.com.ias.handyman.infranstructure.models.ServiceDTO;
import co.com.ias.handyman.service.application.domain.Service;
import co.com.ias.handyman.service.application.domain.valueObjs.ServiceId;
import co.com.ias.handyman.service.application.ports.output.ServiceRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class QueryServiceByIdServiceTest {
    @Mock
    private ServiceRepository serviceRepository;

    @InjectMocks
    private QueryServiceByIdService queryServiceByIdService;

    @Test
    @DisplayName("Service id valid should return an Optional of ServiceDTO")
    void getServiceByIdValid() throws Exception {
        Long id = 8L;
        ServiceId serviceId = new ServiceId(id);
        ServiceDTO serviceDTO = new ServiceDTO(id, 2L, "Calle 12", 2L, 1L);

        Optional<Service> service = Optional.of(serviceDTO.toDomain());

        when(serviceRepository.get(any(ServiceId.class))).thenReturn(service);

        Optional<Service> result = serviceRepository.get(serviceId);

        Optional<ServiceDTO> serviceReturn = result.map(ServiceDTO::fromDomain);

        when(result.map(ServiceDTO::fromDomain)).thenReturn(serviceReturn);

        assertNotNull(result);
        assertEquals(serviceDTO.getId(), serviceReturn.get().getId());
    }

    @Test
    @DisplayName("Service id invalid should return an Optional empty")
    void getServiceByIdInValid() throws Exception {
        Long id = 2L;
        ServiceId serviceId = new ServiceId(id);

        Optional<Service> service = Optional.empty();

        when(serviceRepository.get(any(ServiceId.class))).thenReturn(service);

        Optional<Service> result = serviceRepository.get(serviceId);

        Optional<ServiceDTO> serviceReturn = result.map(ServiceDTO::fromDomain);

        when(result.map(ServiceDTO::fromDomain)).thenReturn(serviceReturn);

        assertNotNull(result);
        assertEquals(service, result);
    }
}

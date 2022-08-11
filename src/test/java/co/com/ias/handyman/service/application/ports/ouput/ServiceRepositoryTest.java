package co.com.ias.handyman.service.application.ports.ouput;

import co.com.ias.handyman.service.application.domain.Service;
import co.com.ias.handyman.service.application.domain.valueObjs.ServiceId;
import co.com.ias.handyman.service.application.ports.output.ServiceRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceRepositoryTest {

    @Autowired
    ServiceRepository serviceRepository;

    @Test
    @DisplayName("Service id exist should return an Optional of service")
    void getServiceSuccess() {

        ServiceId serviceId = new ServiceId(2L);

        Optional<Service> queryService = serviceRepository.get(serviceId);
        ServiceId resultServiceId = queryService.get().getId();

        assertNotNull(queryService);
        assertEquals(resultServiceId.getValue(), serviceId.getValue());

    }

    @Test
    @DisplayName("Service id does not exist should return an optional empty")
    void getServiceWhenIdDoesNotExist() {

        ServiceId serviceId = new ServiceId(0L);

        assertEquals(Optional.empty(), serviceRepository.get(serviceId));

    }
    @Test
    @DisplayName("Null serviceId should throw an exception")
    void getServiceWhenIdIsInvalid() {

        ServiceId serviceId = null;

        assertThrows(NullPointerException.class, () -> serviceRepository.get(serviceId));

    }

}

package co.com.ias.handyman.insfranstructure.adapters.output;


import co.com.ias.handyman.infranstructure.adapters.output.PostgreSqlServiceRepository;
import co.com.ias.handyman.service.application.domain.Service;
import co.com.ias.handyman.service.application.domain.valueObjs.ServiceId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostgreSqlServiceRepositoryTest {

    @Autowired
    private PostgreSqlServiceRepository postgreSqlServiceRepository;

    @Test
    @DisplayName("When serviceId is valid should return an Optional with data")
    void validServiceId() {
        ServiceId serviceId = new ServiceId(2L);

        Optional<Service> queryService = postgreSqlServiceRepository.get(serviceId);

        assertEquals(serviceId.getValue(), queryService.get().getId().getValue());

    }

    @Test
    @DisplayName("When serviceId does not exist should return an Optional empty")
    void invalidServiceId() {
        ServiceId serviceId = new ServiceId(1L);

        Optional<Service> queryService = postgreSqlServiceRepository.get(serviceId);

        assertEquals(Optional.empty(),queryService );
    }

    @Test
    @DisplayName("When service Id is null should throw an error ")
    void nulServiceId() {
        ServiceId serviceId = null;

        assertThrows(NullPointerException.class, () -> postgreSqlServiceRepository.get(serviceId));

    }

}

package co.com.ias.handyman.insfranstructure.controllers;

import co.com.ias.handyman.infranstructure.controllers.ServiceController;
import co.com.ias.handyman.infranstructure.models.ServiceDTO;
import co.com.ias.handyman.service.application.ports.input.QueryServiceByIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceControllerTest {


    private MockMvc mockMvc;
    @Mock
    private QueryServiceByIdUseCase queryServiceByIdUseCase;

    @InjectMocks
    private ServiceController serviceController;

    @BeforeEach
    void setUp() {

        Validator mockValidator = mock(Validator.class);
        mockMvc = MockMvcBuilders
                        .standaloneSetup(serviceController)
                        .setValidator(mockValidator)
                    .build();
    }

    @Test
    @DisplayName("Get service by id successfully")
    void findByIdWhenIsSuccess() throws Exception {
        Long id = 2L;
        ServiceDTO service = new ServiceDTO();
        Optional<ServiceDTO> result = Optional.of(service);

        when(queryServiceByIdUseCase.execute(any(Long.class))).thenReturn(result);

        mockMvc.perform(MockMvcRequestBuilders.get("/services/2"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(queryServiceByIdUseCase, times(1)).execute(id);
    }

    @Test
    @DisplayName("Get service by id when service does not exist")
    void findByIdWhenIdDoesNoExist() throws Exception {
        Long id = 2L;
        Optional<ServiceDTO> serviceDTO = Optional.empty();

        when(queryServiceByIdUseCase.execute(any(Long.class))).thenReturn(serviceDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/services/3"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Get service by id when id is null should throw an exception")
    void findByIdWhenIdIsInvalid() throws Exception {
        Long id = null;
        Optional<ServiceDTO> result = Optional.empty();

        when(queryServiceByIdUseCase.execute(id)).thenThrow(NullPointerException.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/services/2"))
                .andDo(print())
                .andExpect(status().is5xxServerError());

    }

}

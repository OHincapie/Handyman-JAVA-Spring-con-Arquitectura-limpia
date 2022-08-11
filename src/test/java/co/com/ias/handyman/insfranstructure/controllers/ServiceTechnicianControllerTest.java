package co.com.ias.handyman.insfranstructure.controllers;

import co.com.ias.handyman.infranstructure.controllers.ServiceTechnicianController;
import co.com.ias.handyman.infranstructure.controllers.TechnicianController;
import co.com.ias.handyman.infranstructure.models.CalculatorHoursDTO;
import co.com.ias.handyman.infranstructure.models.ServiceTechnicianDTO;
import co.com.ias.handyman.serviceTechnician.application.ports.input.CalculatorHoursWorkUseCase;
import co.com.ias.handyman.serviceTechnician.application.ports.input.CreateServiceTechnicianUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest(ServiceTechnicianController.class)
public class ServiceTechnicianControllerTest {
    @MockBean
    private CreateServiceTechnicianUseCase createServiceTechnicianUseCase;

    @MockBean
    private CalculatorHoursWorkUseCase calculatorHoursWorkUseCase;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Create Service Technician successfully")
    public void CreateTechnicianController(){


    }

    @Test
    @DisplayName("Calculate a ServiceTechnician return a List of CalculatorHourDTO")
    void successCalculate() throws Exception {
        List listHour = new ArrayList<>();
        CalculatorHoursDTO calculatorHoursDTO = new CalculatorHoursDTO();
        calculatorHoursDTO.setIdTechnician(2L);
        listHour.add(calculatorHoursDTO);
        Optional<List<CalculatorHoursDTO>> calculatorHoursDTOS = Optional.of(listHour);
        when(calculatorHoursWorkUseCase.execute(any(ServiceTechnicianDTO.class))).thenReturn(calculatorHoursDTOS);
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();


        this.mockMvc.perform(MockMvcRequestBuilders.get("/service-technician/calculate")
                .param("idTechnician", "4")
                .param("StartDate", "2022-07-04T00:00")
                .param("FinalDate", "2022-07-10T23:59")
        ).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("The controller should response with a status 400 when the optional is empty")
    void noSuccessCalculate() throws Exception {
        Optional<List<CalculatorHoursDTO>> calculatorHoursDTOS = Optional.empty();
        when(calculatorHoursWorkUseCase.execute(any(ServiceTechnicianDTO.class))).thenReturn(calculatorHoursDTOS);
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();


        this.mockMvc.perform(MockMvcRequestBuilders.get("/service-technician/calculate")
                        .param("idTechnician", "4")
                        .param("StartDate", "2022-07-04T00:00")
                        .param("FinalDate", "2022-07-10T23:59")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }
}

package co.com.ias.handyman.insfranstructure.controllers;

import co.com.ias.handyman.serviceTechnician.application.ports.output.ServiceTechnicianRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class TechnicianControllerTest {
    @MockBean
    private ServiceTechnicianRepository serviceTechnicianRepository;

    @Autowired
    private MockBean mockBean;

    @Test
    @DisplayName("Save Technician repository")
    public void SaveTechnicianRepository(){

    }
}

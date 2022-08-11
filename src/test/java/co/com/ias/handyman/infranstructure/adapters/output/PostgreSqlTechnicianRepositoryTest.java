package co.com.ias.handyman.infranstructure.adapters.output;
import co.com.ias.handyman.technician.application.domain.Technician;
import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianDocumentNumber;
import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianDocumentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@SpringBootTest
@RunWith(SpringRunner.class)
class PostgreSqlTechnicianRepositoryTest {

    @Autowired
    private PostgreSqlTechnicianRepository postgreSqlTechnicianRepository;

    @Test
    @DisplayName("When TechnicianId is valid")
    void valid_serviceTechnicianIdTechnician(){
        TechnicianDocumentType technicianDocumentType = new TechnicianDocumentType("this is a test");
        TechnicianDocumentNumber technicianDocumentNumber = new TechnicianDocumentNumber("this is a test");

        Optional<Technician> queryService = postgreSqlTechnicianRepository.getByDocument(technicianDocumentType, technicianDocumentNumber);

        assertEquals(technicianDocumentType.getValue(), queryService.get().getDocumentType().getValue());
        assertEquals(technicianDocumentNumber.getValue(), queryService.get().getDocumentNumber().getValue());
    }

    @Test
    @DisplayName("When TechnicianId does not exist should return an Optional empty")
    void invalid_serviceTechnicianIdTechnician() {
        TechnicianDocumentType technicianDocumentType = new TechnicianDocumentType("this is a test");
        TechnicianDocumentNumber technicianDocumentNumber = new TechnicianDocumentNumber("this is a test");

        Optional<Technician> queryService = postgreSqlTechnicianRepository.getByDocument(technicianDocumentType, technicianDocumentNumber);

        assertEquals(Optional.empty(),queryService );
    }

    @Test
    @DisplayName("When serviceTechnician Id is null should throw an error ")
    void null_serviceTechnicianIdTechnician() {
        TechnicianDocumentType technicianDocumentType = null;
        TechnicianDocumentNumber technicianDocumentNumber = null;

        assertThrows(SQLException.class, () -> technicianDocumentType.getValue());
        assertThrows(SQLException.class, () -> technicianDocumentNumber.getValue());

    }
}
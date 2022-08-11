package co.com.ias.handyman.infranstructure.adapters.output;

import co.com.ias.handyman.infranstructure.models.TechnicianDAO;
import co.com.ias.handyman.technician.application.domain.Technician;
import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianDocumentNumber;
import co.com.ias.handyman.technician.application.domain.valueObjs.TechnicianDocumentType;
import co.com.ias.handyman.technician.application.ports.output.TechnicianRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgreSqlTechnicianRepository implements TechnicianRepository {

    private final DataSource dataSource;

    public PostgreSqlTechnicianRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Technician> getByDocument(TechnicianDocumentType documentType, TechnicianDocumentNumber documentNumber) {
        String sql = "SELECT * FROM technician WHERE document_type = ? AND document_number = ? LIMIT 1";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, documentType.getValue());
            preparedStatement.setString(2, documentNumber.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                TechnicianDAO technicianDAO = TechnicianDAO.fromResultSet(resultSet);
                return Optional.of(technicianDAO.toDomain());
            } else {
                return Optional.empty();
            }
        } catch(SQLException exception){
            System.out.println("Error SELECT FORM technicians DB by Document: "  + exception.getMessage());
            throw new RuntimeException("Error select from technicians table by document", exception);
        }
    }
}

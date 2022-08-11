package co.com.ias.handyman.infranstructure.adapters.output;

import co.com.ias.handyman.infranstructure.models.ServiceDAO;
import co.com.ias.handyman.service.application.domain.Service;
import co.com.ias.handyman.service.application.domain.valueObjs.ServiceId;
import co.com.ias.handyman.service.application.ports.output.ServiceRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgreSqlServiceRepository implements ServiceRepository {

    private final DataSource dataSource;

    public PostgreSqlServiceRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Service> get(ServiceId serviceId) {
        String sql = "SELECT * FROM service WHERE id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, serviceId.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ServiceDAO serviceDAO = ServiceDAO.fromResultSet(resultSet);
                Service service = serviceDAO.toDomain();
                return Optional.of(service);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {

            throw new RuntimeException("Error querying database", exception);
        }
    }
}

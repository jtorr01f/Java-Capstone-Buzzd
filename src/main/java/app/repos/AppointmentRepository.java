package app.repos;

import app.entities.AppointmentsEntity;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<AppointmentsEntity, Integer> {
}

package app.repos;

import app.entities.ClientsEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientsEntity, Integer> {
}

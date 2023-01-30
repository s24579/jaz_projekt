package pl.edu.pjwstk.pizzaplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.pizzaplace.model.Client;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}

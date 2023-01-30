package pl.edu.pjwstk.pizzaplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.pizzaplace.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}

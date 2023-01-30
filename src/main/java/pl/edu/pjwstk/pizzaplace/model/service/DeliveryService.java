package pl.edu.pjwstk.pizzaplace.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.pizzaplace.model.Delivery;
import pl.edu.pjwstk.pizzaplace.repository.DeliveryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery createDelivery(Delivery delivery){
        return deliveryRepository.save(delivery);
    }

    public Optional<Delivery> findByDeliveryId(Long id){
        return deliveryRepository.findById(id);
    }

    public List<Delivery> getAllDeliveries(){
        return deliveryRepository.findAll();
    }

    public void deleteDeliveryById(Long id){
        deliveryRepository.deleteById(id);
    }

    public Delivery updateDelivery(Delivery delivery){
        if (deliveryRepository.findById(delivery.getId()).isPresent())
            return deliveryRepository.save(delivery);
        return null;
    }

}

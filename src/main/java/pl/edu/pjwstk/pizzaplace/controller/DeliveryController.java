package pl.edu.pjwstk.pizzaplace.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.pizzaplace.model.Delivery;
import pl.edu.pjwstk.pizzaplace.model.service.DeliveryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public ResponseEntity<List<Delivery>> getAllDeliveries(){
        return ResponseEntity.ok(deliveryService.getAllDeliveries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Delivery>> getDeliveryById(@PathVariable("id") Long id){
        return ResponseEntity.ok(deliveryService.findByDeliveryId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeliveryById(@PathVariable("id") Long id){
        deliveryService.deleteDeliveryById(id);
        return ResponseEntity.ok("usunieto");
    }

    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery){
        return ResponseEntity.ok(deliveryService.createDelivery(delivery));
    }

    @PutMapping
    public ResponseEntity<Delivery> updateDelivery(@RequestBody Delivery delivery){
        if (deliveryService.updateDelivery(delivery) != null)
            return new ResponseEntity<>(deliveryService.updateDelivery(delivery), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}

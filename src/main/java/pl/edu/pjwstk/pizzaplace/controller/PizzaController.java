package pl.edu.pjwstk.pizzaplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.pizzaplace.model.Pizza;
import pl.edu.pjwstk.pizzaplace.model.service.PizzaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizza")
public class PizzaController {
    PizzaService pizzaService;
    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }
    @GetMapping
    public ResponseEntity<List<Pizza>> getAllPizzas(){
        return ResponseEntity.ok(pizzaService.getAllPizzas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pizza>> getPizzaById(@PathVariable("id") Long id){
        return ResponseEntity.ok(pizzaService.getPizzaById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePizzaById(@PathVariable("id") Long id){
        pizzaService.deletePizzaById(id);
        return ResponseEntity.ok("usunieto");
    }

    @PostMapping
    public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza){
        return ResponseEntity.ok(pizzaService.createPizza(pizza));
    }

    @PutMapping
    public ResponseEntity<Pizza> updatePizza(@RequestBody Pizza pizza){
        if (pizzaService.updatePizza(pizza) != null)
            return new ResponseEntity<>(pizzaService.updatePizza(pizza), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}

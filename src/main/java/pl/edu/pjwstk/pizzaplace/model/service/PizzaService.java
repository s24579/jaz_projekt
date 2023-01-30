package pl.edu.pjwstk.pizzaplace.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.pizzaplace.model.Pizza;
import pl.edu.pjwstk.pizzaplace.repository.PizzaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public Pizza createPizza(Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    public List<Pizza> getAllPizzas(){
        return pizzaRepository.findAll();
    }

    public void deletePizzaById(Long id){ pizzaRepository.deleteById(id);}

    public Optional<Pizza> getPizzaById(Long id){
        return pizzaRepository.findById(id);
    }

    public Pizza updatePizza(Pizza pizza){
        if (pizzaRepository.findById(pizza.getId()).isPresent())
            return pizzaRepository.save(pizza);
        return null;
    }

}

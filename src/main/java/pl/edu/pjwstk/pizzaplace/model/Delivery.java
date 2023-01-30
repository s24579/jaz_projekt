package pl.edu.pjwstk.pizzaplace.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pizza pizzas;

    @ManyToOne
    private Client client;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pizza getPizzas() {
        return pizzas;
    }

    public void setPizzas(Pizza pizzas) {
        this.pizzas = pizzas;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
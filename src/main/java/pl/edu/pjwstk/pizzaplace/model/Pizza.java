package pl.edu.pjwstk.pizzaplace.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pizza")
public class Pizza {
    @Column(name = "pizza_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pizza_name")
    private String pizzaName;
    @Column(name = "price")
    private Float price;
    @Column(name = "size")
    private Integer size;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}

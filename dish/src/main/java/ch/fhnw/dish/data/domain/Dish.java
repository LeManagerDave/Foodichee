package ch.fhnw.dish.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dish")
public class Dish {


    // Represents the unique ID of the dish, e.g. "1", "2", "3", etc.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    // Represents the ingredients of the dish, e.g. "Tomato", "Cheese", "Pasta", etc.
    @Column(name = "dish_ingredients")
    private String dishIngredients;


    // Represents the name of the dish, e.g. "Pizza", "Pasta", "Salad", etc.
    @Column(name = "dish_name")
    private String dishName;


    // Many-to-one relationship with the Menu entity
    @ManyToOne
    private Menu menu;

    // Constructors, getters, and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishIngredients() {
        return dishIngredients;
    }

    public void setDishIngredients(String dishIngredients) {
        this.dishIngredients = dishIngredients;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    } 
    
}


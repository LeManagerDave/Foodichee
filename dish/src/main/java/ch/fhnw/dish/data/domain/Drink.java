package ch.fhnw.dish.data.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "drink")
public class Drink {


    // Represents the unique ID of the drink, e.g. "1", "2", "3", etc.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    // Represents the name of the drink, e.g. "Coke", "Fanta", "Beer", etc.
    @Column(name = "drink_name")
    private String drinkName;


    // Represents the type of the drink, e.g. "Beer", "Wine", "Soft Drink", etc.
    @Column(name = "drink_type")
    private String drinkType;

    // Represents the price of the drink, e.g. "10", "15", "20", etc.
    @Column(name = "drink_price")
    private double drinkPrice;

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

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(double d) {
        this.drinkPrice = d;
    }

}

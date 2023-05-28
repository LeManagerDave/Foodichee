package ch.fhnw.dish.data.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Menu {


    // Primary key for menu entity, the @JsonIgnore annotation excludes this field from the JSON representation of the entity
    @Id
    @JsonIgnore 
    private Long id;

    // One-to-many relationship with the Dish entity
    @OneToMany(mappedBy = "menu") 
    private List<Dish> dishList;

    // One-to-many relationship with the Drink entity
    @OneToMany(mappedBy = "menu")
    private List<Drink> drinkList;

    // Constructors, getters, and setters
    private String currentOffer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public String getCurrentOffer() {
        return currentOffer;
    }

    public void setCurrentOffer(String currentOffer) {
        this.currentOffer = currentOffer;
    }
    
}
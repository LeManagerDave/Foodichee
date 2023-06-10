package ch.fhnw.dish.business.service;

import ch.fhnw.dish.data.domain.Dish;
import ch.fhnw.dish.data.domain.Drink;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartService {
    private List<Dish> dishes;
    private List<Drink> drinks;

    public ShoppingCartService() {
        this.dishes = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public void addToCart(Dish dish) {
        dishes.add(dish);
    }

    public void addToCart(Drink drink) {
        drinks.add(drink);
    }

    public void removeFromCart(Dish dish) {
        dishes.remove(dish);
    }

    public void removeFromCart(Drink drink) {
        drinks.remove(drink);
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void clearCart() {
        dishes.clear();
        drinks.clear();
    }
}



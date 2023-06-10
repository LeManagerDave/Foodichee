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

    // addToCart allow adding dishes to the cart
    public void addToCart(Dish dish) {
        dishes.add(dish);
    }

    // addToCart allow adding drinks to the cart
    public void addToCart(Drink drink) {
        drinks.add(drink);
    }

    // remove from cart allow removing dishes from the cart
    public void removeFromCart(Dish dish) {
        dishes.remove(dish);
    }

    // remove from cart allow removing drinks from the cart
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



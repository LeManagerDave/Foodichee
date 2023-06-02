package ch.fhnw.dish.data.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Dish> dishList;
    private List<Drink> drinkList;

    public Order() {
        dishList = new ArrayList<>();
        drinkList = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishList.add(dish);
    }

    public void addDrink(Drink drink) {
        drinkList.add(drink);
    }

    public void removeDish(Dish dish) {
        dishList.remove(dish);
    }

    public void removeDrink(Drink drink) {
        drinkList.remove(drink);
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;

        for (Dish dish : dishList) {
            totalPrice += dish.getDishPrice();
        }

        for (Drink drink : drinkList) {
            totalPrice += drink.getDrinkPrice();
        }

        return totalPrice;
    }

}


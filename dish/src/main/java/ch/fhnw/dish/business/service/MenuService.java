package ch.fhnw.dish.business.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.dish.data.domain.Menu;
import ch.fhnw.dish.data.domain.Dish;
import ch.fhnw.dish.data.domain.Drink;
import ch.fhnw.dish.data.repository.DishRepository;
import ch.fhnw.dish.data.repository.DrinkRepository;

@Service
public class MenuService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    public Dish findDishById(Long id) {
        Dish dish = dishRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Dish not found"));
        return dish;
    }

    public List<Dish> getAllDishes() {
        List<Dish> dishList = dishRepository.findAll();
        return dishList;
    }

    public Dish addDish(Dish dish) throws Exception {
        if (dish.getDishName() != null) {
            if (dishRepository.findByDishName(dish.getDishName()) == null)
                return dishRepository.save(dish);
            throw new Exception("Dish " + dish.getDishName() + " already exists");
        }
        throw new Exception("Invalid dish name ");
    }

    public void deleteDish(Long id) {
        Dish dish = findDishById(id);
        dishRepository.delete(dish);
    }
    
    public Drink findDrinkById(Long id) {
        Drink drink = drinkRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Drink not found"));
        return drink;
    }

    public List<Drink> getAllDrinks() {
        List<Drink> drinkList = drinkRepository.findAll();
        return drinkList;
    }

    public Drink addDrink(Drink drink) throws Exception {
        if (drink.getDrinkName() != null) {
            if (drinkRepository.findByDrinkName(drink.getDrinkName()) == null)
                return drinkRepository.save(drink);
            throw new Exception("Drink " + drink.getDrinkName() + " already exists");
        }
        throw new Exception("Invalid drink name ");
    }

    public void deleteDrink(Long id) {
        Drink drink = findDrinkById(id);
        drinkRepository.delete(drink);
    }

    public Dish updateDish(Long id, Dish updatedDish) {
        Dish dish = findDishById(id);
        dish.setDishName(updatedDish.getDishName());
        dish.setDishIngredients(updatedDish.getDishIngredients());
        dish.setDishPrice(updatedDish.getDishPrice());
        // Update any other properties as needed
        return dishRepository.save(dish);
    }

    public Drink updateDrink(Long id, Drink updatedDrink) {
        Drink drink = findDrinkById(id);
        drink.setDrinkName(updatedDrink.getDrinkName());
        drink.setDrinkType(updatedDrink.getDrinkType());
        drink.setDrinkPrice(updatedDrink.getDrinkPrice());
        // Update any other properties as needed
        return drinkRepository.save(drink);
    }

    // Business Logic to get current offer according to the location of the user requesting the menu
    private String getCurrentOffer(String location) {
        String currentOffer = "No special offer";
        if ("Basel".equalsIgnoreCase(location))
            currentOffer = "10% off on all large dishes and drinks!!!";
        else if ("Brugg".equalsIgnoreCase(location))
            currentOffer = "Two for the price of One on all small dishes and drinks!!!";
        return currentOffer;
    }

    public Menu getMenuByLocation(String location) {
        String currentOffer = getCurrentOffer(location);
        List<Dish> dishList = getAllDishes();
        List<Drink> drinkList = getAllDrinks();
        Menu menu = new Menu();
        menu.setDishList(dishList);
        menu.setDrinkList(drinkList);
        menu.setCurrentOffer(currentOffer);
        return menu;
    }

}



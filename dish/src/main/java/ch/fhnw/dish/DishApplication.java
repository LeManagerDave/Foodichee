package ch.fhnw.dish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.dish.business.service.MenuService;
import ch.fhnw.dish.data.domain.Dish;
import ch.fhnw.dish.data.domain.Drink;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class DishApplication {

    @Autowired
    private MenuService menuService;

    public static void main(String[] args) {
        SpringApplication.run(DishApplication.class, args);
    }

    @GetMapping(value = "/")
    public String getWelcomeString() {
        return "Welcome to the Foodichee Kitchen!";
    }

    // Use this method to initialize placeholder data without using Postman
    // If you are persisting data in a file (see application.properties), initializing data that already exists will cause an error during starting the application
    // To resolve the error, delete the file and restart the application
    @PostConstruct
    private void initPlaceholderData() throws Exception {
        Dish dish = new Dish();
        dish.setDishName("Spaghetti Bolognese");
        dish.setDishIngredients("Spaghetti, Tomato sauce, Minced Beef, Basil, Parmesan, Onion, Garlic");
        menuService.addDish(dish);

        dish = new Dish();
        dish.setDishName("Riz Casimir");
        dish.setDishIngredients("Rice, Chicken, Pineapple, Apple, Curry, Cream, Onion, Garlic");
        menuService.addDish(dish);

        Drink drink = new Drink();
        drink.setDrinkName("Coca-Cola");
        drink.setDrinkType("Soda");
        menuService.addDrink(drink);

        drink = new Drink();
        drink.setDrinkName("Orange Juice");
        drink.setDrinkType("Juice");
        menuService.addDrink(drink);
    }

}


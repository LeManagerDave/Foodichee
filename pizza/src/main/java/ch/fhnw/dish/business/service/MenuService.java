package ch.fhnw.dish.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.dish.data.domain.Menu;
import ch.fhnw.dish.data.domain.Dish;
import ch.fhnw.dish.data.repository.DishRepository;

@Service
public class MenuService {

    @Autowired
    private DishRepository dishRepository;

    public Dish findDishById(Long id) {
        Dish dish = dishRepository.findById(id).get();
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

    // Business Logic to get current offer according to the location of the user requesting the menu
    private String getCurrentOffer(String location) {
        String currentOffer = "No special offer";
        if ("Basel".equalsIgnoreCase(location))
            currentOffer = "10% off on all large dishes!!!";
        else if ("Brugg".equalsIgnoreCase(location))
            currentOffer = "Two for the price of One on all small dishes!!!";
        return currentOffer;
    }

    public Menu getMenuByLocation(String location) {
        String currentOffer = getCurrentOffer(location);
        List<Dish> dishList = getAllDishes();
        Menu menu = new Menu();
        menu.setDishList(dishList);
        menu.setCurrentOffer(currentOffer);
        return menu;
    }

    // Additional methods, if needed

}


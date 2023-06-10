package ch.fhnw.dish.controller;
import ch.fhnw.dish.data.domain.Menu;
import ch.fhnw.dish.business.service.MenuService;
import ch.fhnw.dish.data.domain.Dish;
import ch.fhnw.dish.data.domain.Drink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(path="/dish/{id}", produces = "application/json")
    public ResponseEntity getDish(@PathVariable("id") Long id) {
        try{
            Dish dish = menuService.findDishById(id);
            return ResponseEntity.ok(dish);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(path="/dish", produces = "application/json")
    public List<Dish> getDishList() {
        List<Dish> dishList = menuService.getAllDishes();
        return dishList;
    }

    @PostMapping(path="/dish", consumes="application/json", produces = "application/json")
    public ResponseEntity addDish(@RequestBody Dish dish) {
        try{
            dish = menuService.addDish(dish);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
        return ResponseEntity.ok(dish);
    }
    
    @GetMapping(path="/drink/{id}", produces = "application/json")
    public ResponseEntity getDrink(@PathVariable("id") Long id) {
        try{
            Drink drink = menuService.findDrinkById(id);
            return ResponseEntity.ok(drink);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(path="/drink", produces = "application/json")
    public List<Drink> getDrinkList() {
        List<Drink> drinkList = menuService.getAllDrinks();
        return drinkList;
    }

    @PostMapping(path="/drink", consumes="application/json", produces = "application/json")
    public ResponseEntity addDrink(@RequestBody Drink drink) {
        try{
            drink = menuService.addDrink(drink);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
        return ResponseEntity.ok(drink);
    }

    @GetMapping(path="", produces = "application/json")
    public Menu getMenu(@RequestParam(value="location") String location) {
        return menuService.getMenuByLocation(location);
    }

    @DeleteMapping(path = "/dish/{id}", produces = "application/json")
    public ResponseEntity deleteDish(@PathVariable("id") Long id) {
        try {
            menuService.deleteDish(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping(path = "/drink/{id}", produces = "application/json")
    public ResponseEntity deleteDrink(@PathVariable("id") Long id) {
        try {
            menuService.deleteDrink(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    
}

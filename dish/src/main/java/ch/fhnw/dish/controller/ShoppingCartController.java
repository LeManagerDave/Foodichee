package ch.fhnw.dish.controller;

import ch.fhnw.dish.business.service.CheckoutService;
import ch.fhnw.dish.business.service.ShoppingCartService;
import ch.fhnw.dish.data.domain.Dish;
import ch.fhnw.dish.data.domain.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping(path="/add-dish", consumes="application/json", produces = "application/json")
    public ResponseEntity addToCart(@RequestBody Dish dish) {
        try{
            shoppingCartService.addToCart(dish);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add dish to cart", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok("Dish added to cart");
    }

    @PostMapping(path="/add-drink", consumes="application/json", produces = "application/json")
    public ResponseEntity addToCart(@RequestBody Drink drink) {
        try{
            shoppingCartService.addToCart(drink);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add drink to cart", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok("Drink added to cart");
    }

    @GetMapping(path="/items", produces = "application/json")
    public ResponseEntity<List<Object>> getCartItems() {
        List<Object> cartItems = shoppingCartService.getCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping(path="/clear", produces = "application/json")
    public ResponseEntity clearCart() {
        shoppingCartService.clearCart();
        return ResponseEntity.ok("Cart cleared");
    }
}

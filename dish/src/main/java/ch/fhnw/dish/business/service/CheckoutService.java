package ch.fhnw.dish.business.service;

import ch.fhnw.dish.data.domain.Dish;
import ch.fhnw.dish.data.domain.Drink;

import java.util.List;

public class CheckoutService {
    private ShoppingCartService shoppingCartService;
    private PaymentService paymentService;
    private DeliveryService deliveryService;

    public CheckoutService(ShoppingCartService shoppingCartService, PaymentService paymentService, DeliveryService deliveryService) {
        this.shoppingCartService = shoppingCartService;
        this.paymentService = paymentService;
        this.deliveryService = deliveryService;
    }

    /* The calculateTotalPrice method calculates the total price of the items in 
    the shopping cart by iterating over the list of dishes and drinks and summing up their prices. */
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        List<Dish> dishes = shoppingCartService.getDishes();
        List<Drink> drinks = shoppingCartService.getDrinks();

        for (Dish dish : dishes) {
            totalPrice += dish.getDishPrice();
        }

        for (Drink drink : drinks) {
            totalPrice += drink.getDrinkPrice();
        }

        return totalPrice;
    }

    /*The processPayment method calls the processPayment method of the PaymentService, 
    passing the total price and the selected payment method. */
    public void processPayment(String paymentMethod) {
        double totalPrice = calculateTotalPrice();
        paymentService.processPayment(totalPrice, paymentMethod);
    }

    /*The processDelivery method calls the processDelivery method of the DeliveryService, 
    passing the list of dishes, list of drinks, and the delivery address. */
    public void processDelivery(String deliveryAddress) {
        List<Dish> dishes = shoppingCartService.getDishes();
        List<Drink> drinks = shoppingCartService.getDrinks();
        deliveryService.processDelivery(dishes, drinks, deliveryAddress);
    }

    /*The checkout method coordinates the entire checkout process. It calls the processPayment method, 
    followed by the processDelivery method, and finally clears the shopping cart using the clearCart method of the ShoppingCartService. */
    public void checkout(String paymentMethod, String deliveryAddress) {
        processPayment(paymentMethod);
        processDelivery(deliveryAddress);
        shoppingCartService.clearCart();
    }
    
}



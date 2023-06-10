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

    public void processPayment(String paymentMethod) {
        double totalPrice = calculateTotalPrice();
        paymentService.processPayment(totalPrice, paymentMethod);
    }

    public void processDelivery(String deliveryAddress) {
        List<Dish> dishes = shoppingCartService.getDishes();
        List<Drink> drinks = shoppingCartService.getDrinks();
        deliveryService.processDelivery(dishes, drinks, deliveryAddress);
    }

    public void checkout(String paymentMethod, String deliveryAddress) {
        processPayment(paymentMethod);
        processDelivery(deliveryAddress);
        shoppingCartService.clearCart();
    }
}



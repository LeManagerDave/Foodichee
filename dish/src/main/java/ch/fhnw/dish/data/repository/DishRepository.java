package ch.fhnw.dish.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.dish.data.domain.Dish;

@Repository
//JpaRepository should be typed to the domain class and an ID type
public interface DishRepository extends JpaRepository<Dish, Long> {
    Dish findByDishName(String dishName);
    List<Dish> findAllByDishIngredientsContainsIgnoreCase(String ingredient);
}

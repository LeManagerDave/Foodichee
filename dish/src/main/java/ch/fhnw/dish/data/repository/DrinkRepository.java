package ch.fhnw.dish.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.dish.data.domain.Drink;

@Repository
//JpaRepository should be typed to the domain class and an ID type
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    Drink findByDrinkName(String drinkName);
    List<Drink> findAllByDrinkTypeContainsIgnoreCase(String type);
}

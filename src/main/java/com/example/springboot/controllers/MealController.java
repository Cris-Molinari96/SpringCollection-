package com.example.springboot.controllers;

import com.example.springboot.entities.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MealController {
    private List<Meal> specialChef = Arrays.asList(
            new Meal("chicken tikka", "description chicken", 12.00),
            new Meal("florentine", "description florentine", 15.00),
            new Meal("spigola", "description spigola", 17.99),
            new Meal("carbonara", "description carbonara: crema di tuorlo d'uovo e pecorino con un pò di pepe e tanto guanciale", 10.99),
            new Meal("amatriciana", "description amatriciana", 8.99),
            new Meal("genovese", "description genovese", 5.99),
            new Meal("cacio e pepe", "description cacio e pepe", 9.99)
    );

    private List<Meal> specialChefSoup = Arrays.asList(
            new Meal("chicken soup", "description chicken soup", 12.99),
            new Meal("fish soup", "description soup", 12.99),
            new Meal("porc soup", "description soup", 12.99),
            new Meal("meat soup", "description soup", 12.99),
            new Meal("minestrone soup", "description soup", 12.99),
            new Meal("lentil soup", "description soup", 12.99),
            new Meal("sauce soup", "description soup ", 12.99)
    );
    /** 1)
     * Create a GetMapping that returns a list of meals
     */
    @GetMapping(value = "/meals")
    public ResponseEntity<?> getMealsList() {
        return ResponseEntity.ok(specialChef);
    }
    /**
     * Exercise 2: Create a GetMapping that returns a meal by name
     */
    @GetMapping(value = "/meal/{mealName}")
    public ResponseEntity<?> getMealOfTheDayTry(@PathVariable("mealName") String mealName) {
        for (Meal meal : specialChef) {
            if (meal.getName().toLowerCase().equals(mealName)) {
                return ResponseEntity.ok(meal.getName() + " " + meal.getDescription());
            }
        }
        return null;
    }
    /**
     * Exercise 3: Create a GetMapping that returns a meal by any word of description
     */
    @GetMapping(value = "meal/description-meal/{phrase}")
    public ResponseEntity<String> getDescriptionMeal(@PathVariable("phrase")String phrase){
        for(Meal meal : specialChef){
            if(meal.getDescription().contains(phrase)){
                return ResponseEntity.ok(meal.getDescription());
            }
        }
        return null;
    }
    /**
     * Exercise 4: Create a GetMapping that returns a meal by price range
     */
    @GetMapping(value = "/meal/price")
    public ResponseEntity<?> getPricesMeal(@RequestParam("min") double min,
                                               @RequestParam("max") double max){
        List<Meal> mealRangePrice = specialChef.stream().filter(
                meal -> min < meal.getPrice() && max > meal.getPrice()).toList();
//        for (Meal meal : specialChef) {
//            // minimo 4€ massimo 10€
//            if(min < meal.getPrice() && max > meal.getPrice()){
//                mealRangePrice.add(meal);
//            }
//        }
                return ResponseEntity.ok(mealRangePrice);
    }

    // fine esercizi, da qui in poi sono esempi utili per me :)

    public void getPriceOfMeal(double min,double max){
        // tutti i pasti compresi tra 5, 10
        for (Meal meal : specialChef) {
            if(min < meal.getPrice() && max > meal.getPrice()){
                System.out.println(meal.getName() + " " + meal.getPrice());
            }
        }
    }
    //! Return a meals random
//    @GetMapping(value = "/get/special")
//    public ResponseEntity<Meal>indexRandom(){
//        return ResponseEntity.ok(
//                specialChef.get((int) Math.random() * specialChef.size())
//        );
//    }

    //! PathVARIABLE
//    @GetMapping(value = "/get/meals/{dayOfWeek}/{isSoup}")
//    public ResponseEntity<?> getSpecialMealWithPathVariable(@PathVariable("dayOfWeek") int dayOfWeek,
//                                                            @PathVariable("isSoup") boolean isSoup) {
//        if (dayOfWeek < 0 || dayOfWeek > 7) {
//            return ResponseEntity.badRequest().body("Invalid day of week. Invalid day of week, values from 0 to 7 are included.");
//        }
//        if (isSoup) {
//            return ResponseEntity.ok(specialChefSoup.get(dayOfWeek));
//        } else {
//            return ResponseEntity.ok(specialChef.get(dayOfWeek));
//        }
//    }

    //! RequestPARAM
//    @GetMapping(value = "/get/chef-specialRequestParam/")
//    public ResponseEntity<?> getSpecialMealWithRequestParam(@RequestParam("dayOfWeek") int dayOfWeek,
//                                                            @RequestParam("isSoup") boolean isSoup) {
//        if (dayOfWeek < 0 || dayOfWeek > 7) {
//            return ResponseEntity.badRequest().body("Invalid day of week. must be 0 to 6.");
//        }
//        if (isSoup) {
//            return ResponseEntity.ok(specialChefSoup.get(dayOfWeek));
//        } else {
//            return ResponseEntity.ok(
//                    specialChef.get(dayOfWeek)
//            );
//        }
//    }
}

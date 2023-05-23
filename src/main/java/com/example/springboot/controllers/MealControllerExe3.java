package com.example.springboot.controllers;

import com.example.springboot.entities.Meal;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/exeTre")
public class MealControllerExe3 {

    private List<Meal> meals = new ArrayList<>();

    @GetMapping(value = "/meals")
    public ResponseEntity<List<Meal>> getMeals(){
        return ResponseEntity.ok(meals);
    }

/**
 * Exercise 1: Create a PutMapping to add a new meal
 */
    @PutMapping(value = "put/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        meals.add(meal);
        return ResponseEntity.ok("Added with success");
    }
/**
* Exercise 2: Create a PostMapping to update a meal by name
*/
    @PostMapping(value = "/post/replace-meal")
    public ResponseEntity<String> postMeal(@RequestBody Meal meal){
        this.meals.removeIf(m -> m.getName().toLowerCase().equals(meal.getName().toLowerCase()));
        this.meals.add(meal);
        return ResponseEntity.ok("Update with success");
    }
/**
 * Exercise 3: Create a DeleteMapping to delete a meal by name
 */
    @DeleteMapping(value = "delete/meal-name/{mealName}")
    public ResponseEntity<String> deleteMeal(@PathVariable("mealName")String mealName){
        this.meals.removeIf(meal -> meal.getName().toLowerCase().equals(mealName.toLowerCase()));
        return ResponseEntity.ok("Meal deleted!");
    }

    /**
     * Exercise 4: Create a DeleteMapping to delete all meals above a certain price
     */
    @DeleteMapping(value = "delete/meal-price/{mealPrice}")
    public ResponseEntity<String> deleteMealForPrice(@PathVariable("mealPrice") double mealPrice ){
        meals.removeIf(m->m.getPrice() < mealPrice);
        if(meals.size() > 1){
        return ResponseEntity.ok("meals deleted");
        }else{
            return ResponseEntity.ok("meal deleted");
        }
    }

    /**
     * Exercise 5: Create a PutMapping to update the price of a meal by name
     */
@PutMapping(value = "meal/{mealName}/price")
public ResponseEntity<String> replaceMeal(@PathVariable("mealName") String mealName,
                                          @RequestBody Meal meal){

    this.meals.removeIf(m -> m.getName().toLowerCase().equals(mealName.toLowerCase()));
    this.meals.add(meal);
    return ResponseEntity.ok("update with success!");
}

// prove per me
    // filter per i prezzi
    @GetMapping(value = "get/meal-price/{mealPrice}")
    public ResponseEntity<?> getMealForPrice(@PathVariable("mealPrice") double mealPrice ){
        List<Meal>filterMeal = meals.stream().filter(m -> m.getPrice() < mealPrice).toList();
        return ResponseEntity.ok(filterMeal);
    }

    // update with set
    @PostMapping(value = "post/meal/{mealName}/{price}/price")
    public ResponseEntity<String> postMeal(@PathVariable("mealName") String mealName,
                                            @PathVariable("price") double price){

        for (Meal meal : meals) {
            if(meal.getName().equals(mealName.toLowerCase())){
                meal.setPrice(price);
            }
        return ResponseEntity.ok("update with success");
        }
        return null;
    }
}

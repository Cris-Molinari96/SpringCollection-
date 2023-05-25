package com.example.springboot.controllers;

import com.example.springboot.component.RestaurantConfig;
import com.example.springboot.entities.Meal;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autowired")
public class MealControllerExe4 {
    // avremo un servizio di pasti
    private MealService mealService;

    private RestaurantConfig restaurantConfig;

    @Autowired // --> accesso al servizio tramite cablaggio automatico
    public MealControllerExe4(MealService mealService, RestaurantConfig restaurantConfig){
        this.mealService = mealService;
        this.restaurantConfig = restaurantConfig;
    }

    @GetMapping(value = "/get/meals")
    public ResponseEntity<?> getMealsList() {
        return ResponseEntity.ok(mealService.getMeal());
    }

    @PutMapping("put/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        try {
            mealService.addMeal(meal);
            return ResponseEntity.ok("Meal added with success!");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

     @DeleteMapping("delete/meal/{mealName}")
    public ResponseEntity<String> deleteMeal(@PathVariable String mealName){
        this.mealService.deleteMeal(mealName);
        return ResponseEntity.ok("Meal deleted with success!!");
    }

     @PostMapping("/post/meal")
    public ResponseEntity<String> postMeal(@RequestBody Meal meal){
        this.mealService.updateMeal(meal);
        return ResponseEntity.ok("Update with success!");
     }

     @GetMapping("/get/restaurant-config")
    public ResponseEntity<RestaurantConfig> getRestaurantConfig(){
        return ResponseEntity.ok(restaurantConfig);
     }

     @PostMapping("/post/restaurant-config/{minPrice}/{discountToday}")
    public ResponseEntity<String> postRestaurantConfig(@PathVariable double minPrice,
                                                      @PathVariable double discountToday){
        if(minPrice <= 0 || discountToday < 0) {
            return ResponseEntity.ok( "For minPrice is not accept price <= " + minPrice +
                    "\n For discount is not accept number < 0 " + discountToday );
        }
        else {
            this.restaurantConfig.setDiscountToday(discountToday);
            this.restaurantConfig.setMinPrice(minPrice);
            return ResponseEntity.ok("update with success");
        }
     }
}

package com.example.springboot.controllers;

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


    @Autowired // --> accesso al servizio tramite cablaggio automatico
    public MealControllerExe4(MealService mealService){
        this.mealService = mealService;
    }

    @GetMapping(value = "/get/meals")
    public ResponseEntity<?> getMealsList() {
        return ResponseEntity.ok(mealService.getMeal());
    }

    @PutMapping("put/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        // exc
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
}

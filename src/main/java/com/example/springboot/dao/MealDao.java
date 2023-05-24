package com.example.springboot.dao;

import com.example.springboot.entities.Meal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MealDao {

    List<Meal> meals = new ArrayList<>();

    public void addMeal(Meal meal) {
        this.meals.add(meal);
    }

    public void deleteMeal(String mealName){
        meals.removeIf(m -> m.getName().toLowerCase().equals(mealName.toLowerCase()));
    }

    public void updateMeal(Meal meal){
        this.meals.removeIf(m -> m.getName().toLowerCase().equals(meal.getName().toLowerCase()));
        this.meals.add(meal);
    }

    public List<Meal> getMeal(){
        return this.meals;
    }

}

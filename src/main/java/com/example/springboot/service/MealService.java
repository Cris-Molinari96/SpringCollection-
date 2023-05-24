package com.example.springboot.service;

import com.example.springboot.dao.MealDao;
import com.example.springboot.entities.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {
// meal service aggiungeremo la logica per verificare se i dati passati dal controller siano in effetti reali
    // come ad esempio che non stiamo passando un oggetto null
    private MealDao mealDao;

    @Autowired // accesso al dao tramite cablaggio automatico
    public MealService(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    public void addMeal(Meal meal) {
        if(meal.getName().equals(null)) throw new IllegalArgumentException("Meal cannot be null");
    mealDao.addMeal(meal);
    }

    public void deleteMeal(String mealName){
        mealDao.deleteMeal(mealName);
    }

    public void updateMeal(Meal meal){
        mealDao.updateMeal(meal);
    }

    public List<Meal> getMeal(){
        return mealDao.getMeal();
    }

}

package com.example.springboot;

import java.util.Arrays;

import com.example.springboot.controllers.MealController;
import com.example.springboot.entities.Meal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		System.out.println("Hello spring");

		MealController mealController = new MealController();
		mealController.getPriceOfMeal(5.99, 10.99);
	}
}

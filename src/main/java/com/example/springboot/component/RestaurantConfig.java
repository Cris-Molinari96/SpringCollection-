package com.example.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class RestaurantConfig {
    private double discountToday = 20.5;
    private double minPrice = 10.5;

    public RestaurantConfig() {}

    public double getDiscountToday() {return discountToday;}
    public void setDiscountToday(double discountToday) {this.discountToday = discountToday;}

    public double getMinPrice() {return minPrice;}
    public void setMinPrice(double minPrice) {this.minPrice = minPrice;}
}

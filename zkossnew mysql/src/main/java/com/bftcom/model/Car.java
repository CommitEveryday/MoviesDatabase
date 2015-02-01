package com.bftcom.model;

/**
 * Created by 1121Len on 12.11.2014.
 */
public class Car {
    private String model ="123";
    private Integer price = 1234;

    public Car(String model, Integer price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public Integer getPrice() {
        return price;
    }
}

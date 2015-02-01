package com.bftcom.service;

import com.bftcom.model.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1121Len on 12.11.2014.
 */
public class CarService {
    private static Car cars[] = new Car[] {
            new Car("Nissan", 1),
            new Car("Audi", 2),
            new Car("BMW", 3)
    };

    public List<Car> find(String key) {
        List<Car> result = new ArrayList<Car>();
        for (Car car : cars) {
            if (car.getModel().contains(key)) {
                result.add(car);
            }
        }
        return result;
    }
}

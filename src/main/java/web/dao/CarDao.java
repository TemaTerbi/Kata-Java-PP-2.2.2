package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDao {
    private final List<Car> carList;

    {
        carList = new ArrayList<>();

        carList.add(new Car("Audi", "1992", 120));
        carList.add(new Car("Porshe", "1985", 200));
        carList.add(new Car("Ferari", "1990", 250));
        carList.add(new Car("Vaz", "1890", 80));
        carList.add(new Car("Formula 1", "2020", 450));
    }

    public List<Car> index() {
        return carList;
    }

    public List<Car> anyCount(int count) {
        List<Car> newList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            newList.add(carList.get(i));
        }

        return newList;
    }
}

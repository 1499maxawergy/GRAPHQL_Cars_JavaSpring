package ru.maxawergy.graphql_cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.maxawergy.graphql_cars.entity.Car;
import ru.maxawergy.graphql_cars.repository.CarRepository;

import java.util.List;

@Controller
public class BasicController {
    @Autowired
    private CarRepository carRepository;

    @QueryMapping
    List<Car> cars(){
        return carRepository.findAll();
    }

    @QueryMapping
    List<Car> findCarsByTitle(@Argument String title){
        return carRepository.findCarsByTitle(title);
    }

    @QueryMapping
    List<Car> findCarsByBrand(@Argument String brand){
        return carRepository.findCarsByBrand(brand);
    }

    @QueryMapping
    List<Car> findCarsByAge(@Argument Integer age){
        return carRepository.findCarsByAge(age);
    }

    @QueryMapping
    List<Car> findCarsByPrice(@Argument Integer price){
        return carRepository.findCarsByPrice(price);
    }

    @MutationMapping
    Car addCar(@Argument CarInput CInput){
        Car car = new Car(CInput.title, CInput.price, CInput.age, CInput.brand);
        return carRepository.save(car);
    }

    record CarInput(String title, Integer price, Integer age, String brand){}

}

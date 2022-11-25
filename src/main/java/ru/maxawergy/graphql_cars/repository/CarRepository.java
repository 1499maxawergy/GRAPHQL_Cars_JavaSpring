package ru.maxawergy.graphql_cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.maxawergy.graphql_cars.entity.Car;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarsByAge(Integer age);
    List<Car> findCarsByBrand(String brand);
    List<Car> findCarsByPrice(Integer price);
    List<Car> findCarsByTitle(String title);
}
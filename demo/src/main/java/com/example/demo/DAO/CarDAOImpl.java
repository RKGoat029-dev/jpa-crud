package com.example.demo.DAO;

import com.example.demo.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {

    private final EntityManager entityManager;

    @Autowired
    public CarDAOImpl(EntityManager entityManager) { this.entityManager = entityManager; }

    @Override @Transactional
    public void save(Car car) { this.entityManager.persist(car); }

    @Override
    @Transactional
    public Car findById(int id) { return this.entityManager.find(Car.class, id); }

    @Override
    @Transactional
    public List<Car> findAll() {
        TypedQuery<Car> allQuery = entityManager.createQuery("FROM Car", Car.class);
        return allQuery.getResultList();
    }

    @Override
    @Transactional
    public List<Car> findByManufacturer(String manufacturer) {
        TypedQuery<Car> manufacturerQuery = entityManager.createQuery(
                "FROM Car WHERE manufacturer=:manufacturer", Car.class
        );
        manufacturerQuery.setParameter("manufacturer", manufacturer);
        return manufacturerQuery.getResultList();
    }

    @Override
    @Transactional
    public List<Car> findByModel(String model) {
        TypedQuery<Car> modelQuery = entityManager.createQuery(
                "FROM Car WHERE model=:model", Car.class
        );
        modelQuery.setParameter("model", model);
        return modelQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Car car) {
        this.entityManager.merge(car);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Car car = findById(id);
        if (car != null) {
            this.entityManager.remove(car);
        } else {
            throw new EntityNotFoundException("Car with id " + id + " not found");
        }
    }
}

package com.example.demo.DAO;

import com.example.demo.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {

    private final EntityManager entityManager;

    @Autowired
    public CarDAOImpl( EntityManager entityManager ) { this.entityManager = entityManager; }

    @Override @Transactional
    public void save(Car car) { this.entityManager.persist(car); }

    @Override
    public Car findById(int id) { return this.entityManager.find(Car.class, id); }

    @Override
    public List<Car> findAll() {

        TypedQuery<Car> allQuery;

        allQuery = entityManager.createQuery("FROM Car", Car.class);

        return allQuery.getResultList();

    }

    @Override
    public List<Car> findByManufacter(String manufacter) {

        TypedQuery<Car> manufacterQuery;

        manufacterQuery = entityManager.createQuery(
                "FROM Car WHERE manufacter=:manufacter", Car.class
        );

        manufacterQuery.setParameter("manufacter", manufacter);

        return manufacterQuery.getResultList();

    }

    @Override
    public List<Car> findByModel(String model) {

        TypedQuery<Car> modelQuery;

        modelQuery = entityManager.createQuery(
                "FROM Car WHERE model=:model", Car.class
        );

        modelQuery.setParameter("model", model);

        return modelQuery.getResultList();

    }
}

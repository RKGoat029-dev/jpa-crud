package com.example.demo.DAO;

import com.example.demo.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAOImpl implements CarDAO {

    private final EntityManager entityManager;

    @Autowired
    public CarDAOImpl( EntityManager entityManager ) { this.entityManager = entityManager; }

    @Override @Transactional
    public void save(Car car) { this.entityManager.persist(car); }

    @Override
    public Car findById(int id) { return this.entityManager.find(Car.class, id); }

}

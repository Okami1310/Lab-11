package com.example.web115.dao;

import com.example.web115.entities.Car;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;

import java.util.List;

@Stateless
public class CarDao {

    @PersistenceContext
    private EntityManager em;

    public List<Car> findAll(){
       return em.createNamedQuery("Car.findAll", Car.class).getResultList();
    }
    public List<Car> searchMark(){
        return em.createNamedQuery("Car.searchMark", Car.class).getResultList();
    }

    public List<Car> sortPriceDownOrYearUp(){return em.createNamedQuery("Car.sortPriceDownOrYearUp", Car.class).getResultList();}
    public List<Car> sortMark(){
        return em.createNamedQuery("Car.sortMark", Car.class).getResultList();
    }

    public List<Car> searchCarsByMark(String inputMark) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        TypedQuery<Car> query = em.createNamedQuery("Car.searchMark", Car.class);
        query.setParameter("mark", inputMark); // Додано одинарні лапки
        List<Car> cars = query.getResultList();
        em.close();
        emf.close();
        return cars;
    }
    public List<Car> searchMarkAndYear(String inputMark, int inputYear) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        TypedQuery<Car> query = em.createNamedQuery("Car.searchMarkAndYear", Car.class);
        query.setParameter("mark", inputMark);
        query.setParameter("n", inputYear);
        List<Car> cars = query.getResultList();
        em.close();
        emf.close();
        return cars;
    }

    public List<Car> searchYearAndPrice(int inputYear, int inputPrice) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        TypedQuery<Car> query = em.createNamedQuery("Car.searchYearAndPrice", Car.class);
        query.setParameter("year", inputYear);
        query.setParameter("price", inputPrice);
        List<Car> cars = query.getResultList();
        em.close();
        emf.close();
        return cars;
    }
    public void addCar(String inputMark, String inputModel, int inputYear, int inputPrice, String inputNumber) {
        String sql = "INSERT INTO Car (mark, model, year, price, number) VALUES (?, ?, ?, ?, ?)";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, inputMark);
        query.setParameter(2, inputModel);
        query.setParameter(3, inputYear);
        query.setParameter(4, inputPrice);
        query.setParameter(5, inputNumber);
        query.executeUpdate();
    }

    public void deleteCar(int inputId) {
        String sql = "delete from car where id = ?";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1, inputId);
        query.executeUpdate();
    }
}

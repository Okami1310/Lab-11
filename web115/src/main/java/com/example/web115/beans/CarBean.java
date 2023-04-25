package com.example.web115.beans;

import com.example.web115.dao.CarDao;
import com.example.web115.entities.Car;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Named
@SessionScoped
public class CarBean implements Serializable {

    @EJB
    private CarDao carDao;
    private int inputId;
    private String inputMark ;
    private String inputModel ;
    private int inputYear;
    private int inputPrice;
    private String inputNumber;

    public List<Car> getCar(){
       return carDao.findAll();
    }
    public List<Car> getSearchMarkAndYear(){
       return carDao.searchMarkAndYear(inputMark, inputYear);
    }
    public List<Car> getSearchYearAndPrice(){
        return carDao.searchYearAndPrice(inputYear,inputPrice);
    }
    public List<Car> getSortPriceDownOrYearUp(){
        return carDao.sortPriceDownOrYearUp();
    }
    public List<Car> getSortMark(){
        return carDao.sortMark();
    }
    public List<Car> getSearchCarsByMark(){return carDao.searchCarsByMark(inputMark);}
    public void getAddCar(){carDao.addCar(inputMark, inputModel, inputYear, inputPrice, inputNumber);}
    public void getDeleteCar(){carDao.deleteCar(inputId);}
}

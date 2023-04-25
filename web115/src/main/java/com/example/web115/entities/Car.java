package com.example.web115.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "car")
@NamedQueries(value = {
        @NamedQuery(name = "Car.findAll", query = "select c from Car c"),
        @NamedQuery(name = "Car.searchMark", query = "SELECT c FROM Car c WHERE c.mark = :mark ORDER BY c.year ASC"),
       @NamedQuery(name = "Car.searchMarkAndYear", query = "select c from Car c where c.mark = :mark AND (2023 - c.year) > :n "),
        @NamedQuery(name = "Car.searchYearAndPrice", query = "select c from Car c where c.year = :year AND c.price > :price"),
        @NamedQuery(name = "Car.sortPriceDownOrYearUp", query = "select c from Car c ORDER BY c.price DESC, c.year ASC"),
        @NamedQuery(name = "Car.sortMark", query = "select c from Car c ORDER BY c.mark")


})


public class Car {



    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "mark", length = 50)
    private String mark;



    @Size(max = 50)
    @Column(name = "model", length = 50)
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "price")
    private Integer price;

    @Size(max = 50)
    @Column(name = "number", length = 50)
    private String number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }





    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
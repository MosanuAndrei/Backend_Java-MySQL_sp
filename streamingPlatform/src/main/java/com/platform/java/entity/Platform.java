package com.platform.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Platform")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPlatform")
    private int idPlatform;

    @Column(name = "NamePlatform")
    private String namePlatform;

    @Column(name = "PricePerMonth")
    private double pricePerMonth;


    public int getIdPlatform() {
        return idPlatform;
    }
    public void setIdPlatform(int idPlatform) {
        this.idPlatform = idPlatform;
    }
    public String getNamePlatform() {
        return namePlatform;
    }
    public void setNamePlatform(String namePlatform) {
        this.namePlatform = namePlatform;
    }
    public double getPricePerMonth() {
        return pricePerMonth;
    }
    public void setPricePerMonth(double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }
    
}

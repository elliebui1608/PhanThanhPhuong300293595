package com.example.phanthanhphuongcsis3275;

import java.math.BigDecimal;

public class Invesment {
    private int year;
    private BigDecimal startamount;
    private BigDecimal interest;
    private BigDecimal endblancer;

    public Invesment(int year, BigDecimal startamount, BigDecimal interest, BigDecimal endblancer) {
        this.year = year;
        this.startamount = startamount;
        this.interest = interest;
        this.endblancer = endblancer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getStartamount() {
        return startamount;
    }

    public void setStartamount(BigDecimal startamount) {
        this.startamount = startamount;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getEndblancer() {
        return endblancer;
    }

    public void setEndblancer(BigDecimal endblancer) {
        this.endblancer = endblancer;
    }
}

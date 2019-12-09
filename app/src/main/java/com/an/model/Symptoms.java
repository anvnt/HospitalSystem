package com.an.model;

import java.io.Serializable;

public class Symptoms implements Serializable {
    //private String Cate;
    private String symptoms;

    public String getSymptoms() {
        return symptoms;
    }

    public Symptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public Symptoms() {
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
    public String toString(){
        return this.symptoms;
    }
}

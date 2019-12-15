package com.an.model;

import java.io.Serializable;

public class DrugReminder implements Serializable {
    private int imgpacman;
    private String drugname;
    private int imglikeblank;


    public DrugReminder() {
    }


    public DrugReminder(int imgpacman, String drugname, int imglikeblank) {
        this.imgpacman = imgpacman;
        this.drugname = drugname;
        this.imglikeblank = imglikeblank;
    }

    public int getImgpacman() {
        return imgpacman;
    }

    public void setImgpacman(int imgpacman) {
        this.imgpacman = imgpacman;
    }

    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public int getImglikeblank() {
        return imglikeblank;
    }

    public void setImglikeblank(int imglikeblank) {
        this.imglikeblank = imglikeblank;
    }

}

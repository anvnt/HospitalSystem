package com.an.model;

import java.io.Serializable;

public class Test implements Serializable {
    private int imgTestIcon;
    private String txtTestName;

    public int getImgTestIcon() {
        return imgTestIcon;
    }

    public void setImgTestIcon(int imgTestIcon) {
        this.imgTestIcon = imgTestIcon;
    }

    public String getTxtTestName() {
        return txtTestName;
    }

    public void setTxtTestName(String txtTestName) {
        this.txtTestName = txtTestName;
    }

    public Test(int imgTestIcon, String txtTestName) {
        this.imgTestIcon = imgTestIcon;
        this.txtTestName = txtTestName;
    }

    public Test() {
    }
}

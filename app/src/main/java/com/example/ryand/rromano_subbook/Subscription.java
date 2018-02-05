package com.example.ryand.rromano_subbook;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ryand on 2018-02-03.
 */

public class Subscription {

    private String name;
    private Date date;
    private float charge;
    private String comment;

    //public Subscription();

    public Subscription(String name, Date date, Float charge, String comment) {
        this.name = name;
        this.date = date;
        this.charge = charge;
        this.comment = comment;
    }

    public String getSubName() {
        return name;
    }

    public Date getSubDate() {
        return date;
    }

    public float getSubCharge() {
        return charge;
    }

    public String getSubComment() {
        return comment;
    }





    public void setSubName(String name) {
        this.name = name;
    }

    public void setSubDate(Date date) {
        this.date = date;
    }

    public void setSubCharge(Float charge) {
        this.charge = charge;
    }

    public void setSubComment(String comment) {
        this.comment = comment;
    }

}





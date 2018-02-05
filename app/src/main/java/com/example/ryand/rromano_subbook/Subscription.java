/*
 * Subscription
 *
 * February 4, 2018
 *
 * Copyright © 2018. CMPUT 301. University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license un this project. Otherwise please contact contact@abc.ca
 */

package com.example.ryand.rromano_subbook;

/**
 * Created by ryand on 2018-02-03.
 */


/**
 * Represents the information regarding a subscription service
 */
public class Subscription {
    private String name;
    private String date;
    private float charge;
    private String comment;

    /**
     * Constructs a subscription from the Subscription class
     *
     * @param name subscription name
     * @param date subscription date
     * @param charge subscription monthly cost
     * @param comment additional comment for the subscription
     */
    public Subscription(String name, String date, Float charge, String comment) {
        this.name = name;
        this.date = date;
        this.charge = charge;
        this.comment = comment;
    }

    /**
     * Gets the name of a subscription object
     *
     * @return the subscription's name
     */
    public String getSubName() {
        return name;
    }

    /**
     * Gets the date of a subscription object
     *
     * @return the starting date of the subscription
     */
    public String getSubDate() {
        return date;
    }

    /**
     * Gets the monthly cost of a subscription object
     *
     * @return the monthly charge
     */
    public float getSubCharge() {
        return charge;
    }

    /**
     * Gets the OPTIONAL comment of a subscription object
     *
     * @return the comment associated with the subscription
     */
    public String getSubComment() {
        return comment;
    }

    /**
     * Allows the setting of the name for a subscription
     *
     * @param name the name that will be associated with a subscription
     */
    public void setSubName(String name) {
        this.name = name;
    }

    /**
     * Allows the setting of the date for a subscription
     *
     * @param date the date (in yyyy-MM-dd format) for a subscription
     */
    public void setSubDate(String date) {
        this.date = date;
    }

    /**
     * Allows the setting of the monthly cost for a subscription
     *
     * @param charge the monthly charge for a subscription
     */
    public void setSubCharge(Float charge) {
        this.charge = charge;
    }

    /**
     * Allows the setting of the additional comment for a subscription
     *
     * @param comment the optional message that
     */
    public void setSubComment(String comment) {
        this.comment = comment;
    }

    /**
     * Overrides the toString() function called when making the list view
     */
    @Override
    public String toString(){
        return ""+ this.name+":  " + this.date+ ",  " + String.format("$%.2f", this.charge);
    }

}





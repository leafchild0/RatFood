package com.ratcal.calc;

import java.util.ArrayList;

/**
 * Created by: vmalyshev
 * Project: RatFood
 * Date: 10/17/13
 * Time: 12:16 AM
 */
public class DayModel {

    //TODO: I don't know why String, improve this in future
    private ArrayList<FoodItem> breakfast;
    private ArrayList<FoodItem>  lunch;
    private ArrayList<FoodItem>  supper;
    private ArrayList<FoodItem>  nosh1;
    private ArrayList<FoodItem>  nosh2;

    public ArrayList<FoodItem> getNosh1() {
        return nosh1;
    }

    protected void setNosh1(ArrayList<FoodItem> nosh1) {
        this.nosh1 = nosh1;
    }

    public ArrayList<FoodItem> getNosh2() {
        return nosh2;
    }

    protected void setNosh2(ArrayList<FoodItem> nosh2) {
        this.nosh2 = nosh2;
    }

    public ArrayList<FoodItem> getBreakfast() {
        return breakfast;
    }

    protected void setBreakfast(ArrayList<FoodItem> breakfast) {
        this.breakfast = breakfast;
    }

    public ArrayList<FoodItem> getLunch() {
        return lunch;
    }

    protected void setLunch(ArrayList<FoodItem> lunch) {
        this.lunch = lunch;
    }

    public ArrayList<FoodItem> getSupper() {
        return supper;
    }

    protected void setSupper(ArrayList<FoodItem> supper) {
        this.supper = supper;
    }
}

package com.ratcal.calc;

/**
 * Created by: vmalyshev
 * Project: RatFood
 * Date: 10/16/13
 * Time: 11:23 PM
 */
public class FoodItem {

    //TODO: Add needed properties later
    private String name;
    private String foodType;
    private String usageType;
    private boolean isSweet;
    private boolean needPrepare;


    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getUsageType() {
        return usageType;
    }

    protected void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    protected boolean isSweet() {
        return isSweet;
    }

    public void setSweet(boolean sweet) {
        isSweet = sweet;
    }

    protected boolean isNeedPrepare() {
        return needPrepare;
    }

    public void setNeedPrepare(boolean needPrepare) {
        this.needPrepare = needPrepare;
    }
}

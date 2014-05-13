package com.ratcal.calc;

import com.ratcal.util.RatFoodManager;

/**
 * Created by: vmalyshev
 * Project: RatFood
 * Date: 10/16/13
 * Time: 11:20 PM
 */
public class RatFoodMain {

    public static void main(String[] args) {

        System.out.println("RatFood V 0.01 \nTool for food ration calculations");
        //Print calculated item to the console
        RatFoodManager.printFood(CalculationsManager.calculatesRationDays());

    }



}

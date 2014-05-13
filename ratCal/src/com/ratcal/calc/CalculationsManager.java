package com.ratcal.calc;

import java.util.ArrayList;

/**
 * Created by: vmalyshev
 * Project: RatFood
 * Date: 12/3/13
 * Time: 11:40 PM
 */
public class CalculationsManager {

    public static ArrayList<DayModel> calculatesRationDays(){

        ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
        ArrayList<DayModel> rationDays = new ArrayList<DayModel>();

        populateFoodList(foodItems);

        //Depends on how many days
        //For now only 1
        DayModel tempDay = new DayModel();

        tempDay.setBreakfast(calculateBreakfast(foodItems));
        tempDay.setLunch(calculateLunch(foodItems));
        tempDay.setSupper(calculateSupper(foodItems));
        tempDay.setNosh1(calculateNosh(foodItems));
        tempDay.setNosh2(calculateNosh(foodItems));

        rationDays.add(tempDay);

        return  rationDays;
    }

    private static ArrayList<FoodItem> calculateNosh(ArrayList<FoodItem> test) {

        ArrayList<FoodItem> noshFood = new ArrayList<FoodItem>();

        //TODO: Get needed items
        //TODO: how to divide each nosh to a equals qty of food items?

        for (int i = 0; i < test.size(); i++) {
            FoodItem testItem = test.get(i);
            String tempUsageType = testItem.getUsageType();
            if(tempUsageType.equals("N1") || tempUsageType.equals("N2")) {
                noshFood.add(testItem);
                //Remove it from list, so it can be excluded from new days calculations
                test.remove(i);
            }
        }

        return noshFood;
    }

    private static ArrayList<FoodItem> calculateSupper(ArrayList<FoodItem> test) {

        ArrayList<FoodItem> supperFood = new ArrayList<FoodItem>();

        //TODO: Get needed items

        for (int i = 0; i < test.size(); i++) {
            FoodItem testItem = test.get(i);
            if(testItem.getUsageType().equals("S")) {
                supperFood.add(testItem);
                //Remove it from list, so it can be excluded from new days calculations
                test.remove(i);
            }
        }



        return supperFood;
    }

    private static ArrayList<FoodItem> calculateLunch(ArrayList<FoodItem> test) {

        ArrayList<FoodItem> lanchFood = new ArrayList<FoodItem>();

        //TODO: Get needed items

        for (int i = 0; i < test.size(); i++) {
            FoodItem testItem = test.get(i);
            if(testItem.getUsageType().equals("D")) {
                lanchFood.add(testItem);
                //Remove it from list, so it can be excluded from new days calculations
                test.remove(i);
            }
        }


        return lanchFood;
    }

    private static ArrayList<FoodItem> calculateBreakfast(ArrayList<FoodItem> test) {

        ArrayList<FoodItem> breakfastFood = new ArrayList<FoodItem>();

        //TODO: Get needed items

        for (int i = 0; i < test.size(); i++) {
            FoodItem testItem = test.get(i);
            if(testItem.getUsageType().equals("B")) {
                breakfastFood.add(testItem);
                //Remove it from list, so it can be excluded from new days calculations
                test.remove(i);
            }
        }

        return breakfastFood;
    }

    private static void populateFoodList(ArrayList<FoodItem> test){

        //TODO: Should be get from props or from UI
        FoodItem pean = new FoodItem();
        pean.setName("Peanuts");
        pean.setFoodType("Peanut");
        pean.setNeedPrepare(false);
        pean.setSweet(false);
        //N1 - Nosh 1
        pean.setUsageType("N1");
        test.add(pean);

        FoodItem candies = new FoodItem();
        candies.setName("Cow candies");
        candies.setFoodType("Candies");
        candies.setNeedPrepare(false);
        candies.setSweet(true);
        //N2 - Nosh 2
        candies.setUsageType("N2");
        test.add(candies);

        FoodItem tinned = new FoodItem();
        tinned.setName("Tinned fish");
        tinned.setFoodType("Tinned");
        tinned.setNeedPrepare(false);
        tinned.setSweet(false);
        //D - dinner
        tinned.setUsageType("D");
        test.add(tinned);

        FoodItem supper = new FoodItem();
        supper.setName("Mushroom soup");
        supper.setFoodType("Soup");
        supper.setNeedPrepare(true);
        supper.setSweet(false);
        //N2 - Nosh 2
        supper.setUsageType("S");
        test.add(supper);

        FoodItem breakfast = new FoodItem();
        breakfast.setName("Porridge");
        breakfast.setFoodType("Porridge");
        breakfast.setNeedPrepare(true);
        breakfast.setSweet(false);
        //N2 - Nosh 2
        breakfast.setUsageType("B");
        test.add(breakfast);
    }

}

package com.ratcal.util;

import com.ratcal.calc.DayModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by: vmalyshev
 * Project: RatFood
 * Date: 12/3/13
 * Time: 11:57 PM
 */
public class RatFoodManager {

    public static void printFood(ArrayList<DayModel> days){

        for (int i = 0; i < days.size(); i++) {
            DayModel dayModel = days.get(i);
            System.out.println("Breakfast: " + dayModel.getBreakfast().get(0).getName());
            System.out.println("Nosh N1: " + dayModel.getNosh1().get(0).getName());
            System.out.println("Lanch: " + dayModel.getLunch().get(0).getName());
            System.out.println("Nosh N2: " + dayModel.getNosh2().get(0).getName());
            System.out.println("Supper: " + dayModel.getSupper().get(0).getName());
        }
    }

    public static boolean saveFile(String content, File file){

        boolean result = true;
        FileWriter fileWriter;

        try {
            if(!file.getName().contains(".txt")){
                Path source = Paths.get(file.getAbsolutePath());
                // Path target = Paths.get(file.getAbsolutePath() + ".txt");
                if (!file.exists()) result = file.createNewFile();
                Files.move(source, source.resolveSibling(source.getFileName() + ".txt"));
            }
            fileWriter = new FileWriter(file + ".txt");
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Error in saving a file " + ex);
            result = false;
        }
        return result;
    }
}

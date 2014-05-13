package com.ratcal.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class RatCalMain extends Application {

    private static final String appVersion = "V0.1";
    final ToggleGroup group = new ToggleGroup();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ratcal.fxml"));


        UIRatController.getTourism().setToggleGroup(group);
        UIRatController.getEveryDay().setToggleGroup(group);


        primaryStage.setTitle("RatCal " + appVersion);
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

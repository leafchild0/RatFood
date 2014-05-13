package com.ratcal.ui;

import com.ratcal.calc.CalculationsManager;
import com.ratcal.calc.DayModel;
import com.ratcal.util.RatFoodManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import se.mbaeumer.fxmessagebox.MessageBox;
import se.mbaeumer.fxmessagebox.MessageBoxResult;
import se.mbaeumer.fxmessagebox.MessageBoxType;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class UIRatController {

    @FXML
    private static RadioButton tourism;
    @FXML
    private static RadioButton everyDay;
    @FXML
    private TextField daysField;
    @FXML
    private TextField peopleField;
    @FXML
    private MenuItem closeItem;
    @FXML
    private Button generateButton;
    @FXML
    private Button clearButton;
    @FXML
    private MenuItem saveItem;
    @FXML
    private TextArea calcArea;

    public TextArea getCalcArea() {
        return calcArea;
    }

    public void setCalcArea(TextArea calcArea) {
        this.calcArea = calcArea;
    }

    public static RadioButton getTourism() {
        return tourism;
    }

    public void setTourism(RadioButton tourism) {
        UIRatController.tourism = tourism;
    }

    public static RadioButton getEveryDay() {
        return everyDay;
    }

    public void setEveryDay(RadioButton everyDay) {
        UIRatController.everyDay = everyDay;
    }

    public TextField getDaysField() {
        return daysField;
    }

    public void setDaysField(TextField daysField) {
        this.daysField = daysField;
    }

    public TextField getPeopleField() {
        return peopleField;
    }

    public void setPeopleField(TextField peopleField) {
        this.peopleField = peopleField;
    }

    public MenuItem getCloseItem() {
        return closeItem;
    }

    public void setCloseItem(MenuItem closeItem) {
        this.closeItem = closeItem;
    }

    public Button getGenerateButton() {
        return generateButton;
    }

    public void setGenerateButton(Button generateButton) {
        this.generateButton = generateButton;
    }

    public Button getClearButton() {
        return clearButton;
    }

    public void setClearButton(Button clearButton) {
        this.clearButton = clearButton;
    }

    public MenuItem getSaveItem() {
        return saveItem;
    }

    public void setSaveItem(MenuItem saveItem) {
        this.saveItem = saveItem;
    }


    FileChooser fileChooser = null;
    Stage primaryStage = null;
    private Effect invalidEffect = new DropShadow(BlurType.GAUSSIAN, Color.RED, 4, 0.0, 0, 0);



    @FXML
    private void init(){

        calcArea.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        if (e.getButton() == MouseButton.PRIMARY && (e.getClickCount() == 2)){
                            MessageBox mb = new MessageBox("Do you wanna edit the calculations?", MessageBoxType.YES_NO);
                            mb.showAndWait();
                            MessageBoxResult result = mb.getMessageBoxResult();
                            if(result.compareTo(MessageBoxResult.YES) == 0) calcArea.setEditable(true);
                            if(result.compareTo(MessageBoxResult.NO) == 0) calcArea.setEditable(false);
                        }

                    }
                });
    }



    @FXML
    private void handleExitAction(ActionEvent event) {

        initializePrimiryStage();
        MenuItem menuItem = (MenuItem) event.getTarget();
        if (menuItem.getText().equals("Close")){
            System.out.println("Exit\n");
            // do what you have to do
            primaryStage.close();
        }
    }


    @FXML
    private void clearCalculations() {

        calcArea.setText("");

    }

    @FXML
    private void startGenerate() {

        if (validateUserForm()) {

            ArrayList<DayModel> days = CalculationsManager.calculatesRationDays();
            clearCalculations();
            for (int i = 0; i < days.size(); i++) {
                DayModel dayModel = days.get(i);
                //TODO: Move this into separate method
                calcArea.appendText("Breakfast: " + dayModel.getBreakfast().get(0).getName() + "\n");
                calcArea.appendText("Nosh N1: " + dayModel.getNosh1().get(0).getName() + "\n");
                calcArea.appendText("Lanch: " + dayModel.getLunch().get(0).getName() + "\n");
                calcArea.appendText("Nosh N2: " + dayModel.getNosh2().get(0).getName() + "\n");
                calcArea.appendText("Supper: " + dayModel.getSupper().get(0).getName() + "\n");
            }
        }

    }

    @FXML
    private void saveCalculationsInFile() {

        initializePrimiryStage();
        boolean isFileSaved = false;

        if (fileChooser == null) {
            fileChooser = new FileChooser();
            fileChooser.setTitle("Save Calculations into file");
            //Set extension filter
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            FileChooser.ExtensionFilter allFilesFilter = new FileChooser.ExtensionFilter("All Files", "*.*");
            fileChooser.getExtensionFilters().add(extFilter);
            fileChooser.getExtensionFilters().add(allFilesFilter);
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            File file = fileChooser.showSaveDialog(primaryStage);

            if (file != null) {
                isFileSaved = RatFoodManager.saveFile(calcArea.getText(), file);
            }
        }
        if (isFileSaved){
            MessageBox mb = new MessageBox("File was successfully saved", MessageBoxType.OK_ONLY);
            mb.showAndWait();
        }
    }

    private void initializePrimiryStage() {

        if (primaryStage == null) {
            primaryStage = (Stage) generateButton.getScene().getWindow();
        }
    }

    private boolean validateUserForm() {

        boolean result = true;
        Tooltip tTip = new Tooltip("The input should be a number");
        tTip.setAutoHide(true);

        String days = daysField.getText();
        String people = peopleField.getText();
        String numberPattern = "(\\d?[1-9]|[1-9])$";
        if (! Pattern.matches(numberPattern, days)){
            daysField.setEffect(invalidEffect);
            daysField.setTooltip(tTip);
            tTip.show(calcArea.getScene().getWindow());
            result = false;
        } else daysField.setEffect(null);
        if (! Pattern.matches(numberPattern, people)){
            peopleField.setEffect(invalidEffect);
            peopleField.setTooltip(tTip);
            tTip.show(calcArea.getScene().getWindow());
            result = false;
        } else peopleField.setEffect(null);

        return result;
    }

}
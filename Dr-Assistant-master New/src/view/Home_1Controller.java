/*
 * Copyright 2023 AL_Qema.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package view;

import controller.HomeController;
import css.BtnCss;
import getway.AuthGetway;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.User;

/**
 * FXML Controller class
 *
 * @author AL_Qema
 */
public class Home_1Controller implements Initializable {

   
    @FXML
    private StackPane mainContent;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnPrescription;
  
 
    @FXML
    private Button btnDrug;
    @FXML
    private Button btnSetting;

    BtnCss css = new BtnCss();
    User user = new User();
    AuthGetway auth = new AuthGetway();
    
    
    
    @FXML
    private Label lblFullName;
    @FXML
    private Label lblUserName;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        user = auth.getUser();
        lblFullName.setText("Patient Person");
        lblUserName.setText(user.getUserName() + " (Patient)");

        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/HomeContent_1.fxml")));
            homeActive();
            Platform.runLater(() -> {
                user = auth.getUser();
                System.out.println(user.getFullName());
            });
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void homeOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Home - Dr.Assistant");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/HomeContent_1.fxml")));
            homeActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void prescriptionOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Date - Dr.Assistant");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/prescription/Prescriptions_1.fxml")));
            prescriptionActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void templateOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Template - Dr.Assistant");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/template/Templates.fxml")));
 
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void patientOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Patient - Dr.Assistant");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/patient/Patients.fxml")));
          
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void drugOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("appointment - hospital System");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/drug/Drugs_1.fxml")));
            drugActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void settingOnAction(ActionEvent event) {
        Stage stage = (Stage) btnSetting.getScene().getWindow();
        stage.setTitle("Setting - Dr.Assistant");
        try {
            mainContent.getChildren().clear();
            mainContent.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Setting.fxml")));
            settingActive();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleLogOutButton(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/view/Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fXMLLoader.load());
        stage.setScene(scene);
        stage.setTitle("Hospital System - Login");
        stage.show();

        Stage nStage = (Stage) mainContent.getScene().getWindow();
        nStage.close();
    }

    private void homeActive() {
        btnHome.setStyle(css.homeActive);
        btnPrescription.setStyle("");
 
  
        btnDrug.setStyle("");
        btnSetting.setStyle("");
    }

    private void prescriptionActive() {
        btnPrescription.setStyle(css.prescriptionActive);
        btnHome.setStyle("");
 
    
        btnDrug.setStyle("");
        btnSetting.setStyle("");
    }
 

 

    private void drugActive() {
        btnDrug.setStyle(css.drugActive);
        btnHome.setStyle("");
        btnPrescription.setStyle("");
 
 
        btnSetting.setStyle("");
    }

    private void settingActive() {
        btnSetting.setStyle(css.settingActive);
        btnHome.setStyle("");
        btnPrescription.setStyle("");
      
        btnDrug.setStyle("");
    }

    @FXML
    private void handleAbout(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/view/other/About.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fXMLLoader.load());
        stage.setScene(scene);
        stage.setTitle("About");
        stage.show();
    }

    private void handleBuyButton(ActionEvent event) throws IOException {
        Desktop.getDesktop().browse(URI.create("https://code-projects.org"));
    }

    @FXML
    private void handleDocumentation(ActionEvent event) throws IOException {
        Desktop.getDesktop().browse(URI.create("https://code-projects.org"));
    }

    @FXML
    private void handleBuyMeCoffee(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/view/other/Donate.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fXMLLoader.load());
        stage.setScene(scene);
        stage.setTitle("Buy me a coffee");
        stage.show();

    }

    @FXML
    private void handleDeveloperStory(ActionEvent event) {

    }

    @FXML
    private void handleFeedBack(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Feedback");
        alert.setHeaderText("I like to hear your feedback \nMail me at kmrifat@gmail.com");
        alert.showAndWait();
    }

}

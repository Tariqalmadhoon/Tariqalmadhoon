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

import getway.DrugGetway;
import getway.PatientGetway;
import getway.PrescriptionGetway;
import getway.TemplateGetway;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AL_Qema
 */
public class HomeContent_1Controller implements Initializable {

 
    @FXML
    private Text lblTotalDrug;
    @FXML
    private Text lblTotalPrescription;
 

    PrescriptionGetway prescriptionGetway = new PrescriptionGetway();
    PatientGetway patientGetway = new PatientGetway();
    DrugGetway drugGetway = new DrugGetway();
    TemplateGetway templateGetway = new TemplateGetway();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
  
            lblTotalDrug.setText(String.valueOf(drugGetway.totalDrug()));
            lblTotalPrescription.setText(String.valueOf(prescriptionGetway.totalPrescription()));
        });
    }

 
    @FXML
    private void handleNewDrug(ActionEvent event) throws IOException {
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/view/drug/NewDrug.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fXMLLoader.load());
        stage.setScene(scene);
        stage.setTitle("New Drug");
        stage.show();
    }

 
 

    
}

package tg.ahuete.cryptolight.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tg.ahuete.cryptolight.MainApp;

public class AccueilPanelController {
	private MainApp mainApp;
	
	@FXML
	private AnchorPane rootpane;
	
    @FXML
    private JFXTextField login;
    @FXML
    private JFXPasswordField password;    
    
    public AccueilPanelController() {
    }

    
    @FXML
    private void initialize() {
    	
    }


    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;        
    }
    
    public void handleLoginButton(){
    	if (verifLogin()) basculeAff();
    	
    }


	private boolean verifLogin() {
		return true;
	}

	private void basculeAff() {
		FadeTransition transition = new FadeTransition();
		transition.setDuration(Duration.millis(500));
		transition.setNode(rootpane);
		transition.setFromValue(1);
		transition.setToValue(0);
		transition.setOnFinished(
				(ActionEvent action) -> {
					chargeNewScene();
				}) ;
		transition.play();
		
		
	}
	
	private void chargeNewScene() {
		Parent princPane;
		try {
			princPane = (AnchorPane) FXMLLoader.load(getClass().getResource("../view/BanqueOverview.fxml"));
			Scene newScene = new Scene(princPane);
			Stage curStage = (Stage) rootpane.getScene().getWindow();
			curStage.setScene(newScene);
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}

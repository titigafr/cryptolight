package tg.ahuete.cryptolight.view;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import tg.ahuete.cryptolight.model.Banque;

public class ParamEditDialogController {

	@FXML
	private JFXListView<Banque> listebanque;
	private Stage dialogStage;
	private boolean okClicked = false;
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	@FXML
    private void initialize() {
		//Banque banque = new Banque("Test1","abcdefghijklmnop","azertyuiopazertyuiop","Bitrex");
		listebanque.getItems().add(new Banque("Test1","abcdefghijklmnop","azertyuiopazertyuiop","Bitrex"));
	}
	
	public boolean isOkClicked() {
		// TODO Auto-generated method stub
		return okClicked ;
	}

	@FXML
    private void handleOk() {
            dialogStage.close();
        }
	
	@FXML
    private void handleCancel() {
        dialogStage.close();
    }
    }
	


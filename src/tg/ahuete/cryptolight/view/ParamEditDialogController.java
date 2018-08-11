package tg.ahuete.cryptolight.view;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import tg.ahuete.cryptolight.MainApp;
import tg.ahuete.cryptolight.model.Banque;
import tg.ahuete.cryptolight.model.SimpleBanqueListCell;

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
		listebanque.setCellFactory(lv -> new SimpleBanqueListCell());
		
		for (Banque itemInXml : MainApp.banqueData) {
			listebanque.getItems().add(new Banque(itemInXml.getName(), itemInXml.getPublicApi(), itemInXml.getSecretApi(), itemInXml.getBanqueType()));
			System.out.println(itemInXml.getName());
		}
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
	
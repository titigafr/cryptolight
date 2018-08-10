package tg.ahuete.cryptolight.view;


import java.util.HashMap;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tg.ahuete.cryptolight.MainApp;
import tg.ahuete.cryptolight.model.Bittrex;
import tg.ahuete.cryptolight.model.Cryptopia;
import tg.ahuete.*;

public class BanqueOverviewController {
	private MainApp mainApp;
	
    @FXML
    private Label bittrexdepositAdressLabel;
    @FXML
    private Label bitrexbalanceLabel;
    @FXML
    private Label bitrexavailabelLabel;
    @FXML
    private Label cryptopiadepositAdressLabel;
    @FXML
    private Label cryptopiabalanceLabel;
    @FXML
    private Label cryptopiaavailabelLabel;
    
    Bittrex banque=new Bittrex("e9aac1727dd547e5915cd9b43e98dd79", "cb48ec8f1b954fb7bdfc54d089841105",1, 15);
    Cryptopia banque2=new Cryptopia();
    ;
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public BanqueOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        
    }
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param person the person or null
     */
    
    public void handleButtonGetAdress() {
    	banque2.setKey("a1369f2b19814299b138c49fd577c223");
        banque2.setSecretKey("6+ASRH9wpD8ok1FFYoU+X1AuIXMm4ubvmaK7PGHmnF0=");
    	String result = banque.getBalance("BTC");
    	String result2 = banque2.getBalance("USDT");
    	List<HashMap<String, String>> map = Bittrex.getMapsFromResponse(result);
    	List<HashMap<String, String>> map2 = Bittrex.getMapsFromResponse(result2);
		HashMap<String, String> onlyMap = map.get(0);
		HashMap<String, String> onlyMap2 = map2.get(0);
		
		System.out.println(result2);
		// And then the wanted map can be used

		//allBalancesMapList.get(3).get("Balance");
    	bittrexdepositAdressLabel.setText(onlyMap.get("CryptoAddress"));
    	bitrexbalanceLabel.setText(onlyMap.get("Balance"));
    	bitrexavailabelLabel.setText(onlyMap.get("Available"));
    	cryptopiadepositAdressLabel.setText(onlyMap2.get("Address"));
    	cryptopiabalanceLabel.setText(onlyMap2.get("Total"));
    	cryptopiaavailabelLabel.setText(onlyMap2.get("Available"));
    }
    
    
}

package tg.ahuete.cryptolight.controller;


import java.util.HashMap;
import java.util.List;

import javax.swing.RootPaneContainer;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTabPane;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import tg.ahuete.cryptolight.MainApp;
import tg.ahuete.cryptolight.model.Banque;
import tg.ahuete.cryptolight.model.Bittrex;
import tg.ahuete.cryptolight.model.Cryptopia;
import tg.ahuete.cryptolight.model.CurrencyBanqueListCell;
import tg.ahuete.cryptolight.model.CurrentCurrency;

public class BanqueOverviewController {
	private MainApp mainApp;
	
    @FXML
    private Label bittrexdepositAdressLabel;
    @FXML
    private Label bitrexbalanceLabel;
    @FXML
    private Label bitrexavailabelLabel;
    @FXML
    JFXListView<CurrentCurrency> listeBanqueCurrency;
    @FXML
    private Label cryptopiadepositAdressLabel;
    @FXML
    private Label cryptopiabalanceLabel;
    @FXML
    private Label cryptopiaavailabelLabel;
    @FXML
    private JFXTabPane banqueTab;
     @FXML
    private AnchorPane  rootPane ;
    
    Bittrex banque;
    Cryptopia banque2;
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public BanqueOverviewController() {
    }

   
    @FXML
    private void initialize() {
    	rootPane.setOpacity(0);
    	FadeTransition transition = new FadeTransition();
		transition.setDuration(Duration.millis(500));
		transition.setNode(rootPane);
		transition.setFromValue(0);
		transition.setToValue(1);
		transition.play();
    	
    	listeBanqueCurrency.setCellFactory(lv -> new CurrencyBanqueListCell());
		
		for (Banque itemInXml : MainApp.banqueData) {
			listeBanqueCurrency.getItems().add(new CurrentCurrency(itemInXml.getNomSite(), "sp", "sq", "bp", "bq"));
			System.out.println(itemInXml.getNomSite());
		}    	
    	banque=new Bittrex("e9aac1727dd547e5915cd9b43e98dd79", "cb48ec8f1b954fb7bdfc54d089841105",1, 15);
    	banque2=new Cryptopia();
    }

    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
    }
        
    public void handleButtonRefresh() {
    	banque2.setKey("a1369f2b19814299b138c49fd577c223");
        banque2.setSecretKey("6+ASRH9wpD8ok1FFYoU+X1AuIXMm4ubvmaK7PGHmnF0=");
    	String result = banque.getBalance("BTC");
    	String result2 = banque2.getBalance("BTC");
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

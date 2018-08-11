package tg.ahuete.cryptolight;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tg.ahuete.cryptolight.model.Banque;
import tg.ahuete.cryptolight.model.BanqueListWrapper;
import tg.ahuete.cryptolight.view.BanqueOverviewController;
import tg.ahuete.cryptolight.view.RootLayoutController;


public class MainApp extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    public static ObservableList<Banque> banqueData = FXCollections.observableArrayList();
    
    public MainApp() {
        //dans cette partie on va charger la liste des banques à partir
    	//d'un fichier XML (voir pour mettre en place une base de donnée serait peut-etre mieux pour la sécurisation
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	this.primaryStage = primaryStage;
        this.primaryStage.setTitle("CryptoLight");
        this.primaryStage.getIcons().add(new Image("file:ressources/images/adressebook.png"));
        initRootLayout();

        showBanqueOverview();
    } 

    /**
     * Initializes the root layout and tries to load the last opened
     * person file.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("ressources/banques.xml");
        if (file != null) {
            loadBanqueDataFromFile(file);
        }
        
    }
    
    public void showBanqueOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BanqueOverview.fxml"));
            AnchorPane banqueOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(banqueOverview);
         // Give the controller access to the main app.
            BanqueOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void loadBanqueDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(BanqueListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            BanqueListWrapper wrapper = (BanqueListWrapper) um.unmarshal(file);

            banqueData.clear();
            banqueData.addAll(wrapper.getBanques());

            // Save the file path to the registry.
            

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());

            alert.showAndWait();
        }
        }
    
//    public void savePersonDataToFile(File file) {
//        try {
//            JAXBContext context = JAXBContext
//                    .newInstance(BanqueListWrapper.class);
//            Marshaller m = context.createMarshaller();
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            // Wrapping our person data.
//            BanqueListWrapper wrapper = new BanqueListWrapper();
//            wrapper.setBanques(banqueData);
//
//            // Marshalling and saving XML to the file.
//            m.marshal(wrapper, file);        
//        } catch (Exception e) { // catches ANY exception
//            Alert alert = new Alert(AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Could not save data");
//            alert.setContentText("Could not save data to file:\n" + file.getPath());
//
//            alert.showAndWait();
//        }
//    }
//    
//    public void setBanqueFilePath(File file) {
//        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
//        if (file != null) {
//            prefs.put("filePath", file.getPath());
//
//            // Update the stage title.
//            primaryStage.setTitle("AddressApp - " + file.getName());
//        } else {
//            prefs.remove("filePath");
//
//            // Update the stage title.
//            primaryStage.setTitle("AddressApp");
//        }
//    }
}

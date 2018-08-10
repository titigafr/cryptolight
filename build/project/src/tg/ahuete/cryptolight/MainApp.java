package tg.ahuete.cryptolight;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tg.ahuete.cryptolight.view.BanqueOverviewController;
import tg.ahuete.cryptolight.view.RootLayoutController;


public class MainApp extends Application {
	
	private Stage primaryStage;
    private BorderPane rootLayout;
    
    public MainApp() {
        // Add some sample data
        
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

        // Try to load last opened person file.
//        File file = getPersonFilePath();
//        if (file != null) {
//            loadPersonDataFromFile(file);
//        }
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
    
}

package tg.ahuete.cryptolight.model;

import javax.swing.JLabel;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;

public class SimpleBanqueListCell extends ListCell<Banque>{
	
	private final Label banqueName = new Label(); 
    private final TextField publicApi = new TextField(); 
    private final TextField secretApi = new TextField(); 
    private final Label banqueType = new Label();
    private final GridPane gridPane = new GridPane();
    private final AnchorPane content = new AnchorPane();
    
    public SimpleBanqueListCell() { 
        // 
    	banqueName.setStyle("-fx-font-weight: bold; -fx-font-size: 1.5em;"); 
        GridPane.setConstraints(banqueName, 1, 0); 
        publicApi.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
        GridPane.setConstraints(publicApi, 1, 1);
        secretApi.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
        GridPane.setConstraints(secretApi, 1, 2); 
        banqueType.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
        GridPane.setConstraints(banqueType, 1, 3); 
        // 
    
//        GridPane.setConstraints(descriptionLabel, 1, 1); 
//        GridPane.setColumnSpan(descriptionLabel, Integer.MAX_VALUE); 
        //         
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, HPos.LEFT, true)); 
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
        gridPane.getColumnConstraints().add(new ColumnConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, HPos.LEFT, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.NEVER, VPos.CENTER, true)); 
        gridPane.getRowConstraints().add(new RowConstraints(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE, Priority.ALWAYS, VPos.CENTER, true)); 
        gridPane.setHgap(6); 
        gridPane.setVgap(6); 
        gridPane.getChildren().setAll(banqueName, publicApi, secretApi, banqueType); 
        AnchorPane.setTopAnchor(gridPane, 0d); 
        AnchorPane.setLeftAnchor(gridPane, 0d); 
        AnchorPane.setBottomAnchor(gridPane, 0d); 
        AnchorPane.setRightAnchor(gridPane, 0d); 
        content.getChildren().add(gridPane); 
    } 
  
    protected void updateItem(Banque item, boolean empty) { 
        super.updateItem(item, empty); 
        setGraphic(null); 
        setText(null); 
        setContentDisplay(ContentDisplay.LEFT); 
        if (!empty && item != null) { 
        	banqueName.setText(item.getName()); 
        	publicApi.setText(item.getPublicApi()); 
        	secretApi.setText(item.getSecretApi()); 
        	banqueType.setText(item.getBanqueType()); 
            setText(null); 
            setGraphic(content); 
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
        } 
    } 
}

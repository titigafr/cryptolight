package tg.ahuete.cryptolight.model;

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

public class CurrencyBanqueListCell  extends ListCell<CurrentCurrency>{
	
	private final Label nomSite = new Label(); 
    private final Label orderSellPrice = new Label(); 
    private final Label orderSellQuantity = new Label(); 
    private final Label orderBuyPrice = new Label();
    private final Label orderBuyQuantity = new Label();
    private final GridPane gridPane = new GridPane();
    private final AnchorPane content = new AnchorPane();
	
	public CurrencyBanqueListCell() { 
        // 
		nomSite.setStyle("-fx-font-weight: bold; -fx-font-size: 1.5em;"); 
        GridPane.setConstraints(nomSite, 1, 0); 
        orderSellPrice.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
        GridPane.setConstraints(orderSellPrice, 1, 1);
        orderSellQuantity.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
        GridPane.setConstraints(orderSellQuantity, 1, 2); 
        orderBuyPrice.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
        GridPane.setConstraints(orderBuyPrice, 2, 1); 
        orderBuyQuantity.setStyle("-fx-font-size: 0.9em; -fx-font-style: italic; -fx-opacity: 0.5;"); 
        GridPane.setConstraints(orderBuyQuantity, 2, 2); 
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
        gridPane.getChildren().setAll(nomSite, orderSellPrice, orderSellQuantity, orderBuyPrice, orderBuyQuantity); 
        AnchorPane.setTopAnchor(gridPane, 0d); 
        AnchorPane.setLeftAnchor(gridPane, 0d); 
        AnchorPane.setBottomAnchor(gridPane, 0d); 
        AnchorPane.setRightAnchor(gridPane, 0d); 
        content.getChildren().add(gridPane); 
    } 
  
    protected void updateItem(CurrentCurrency item, boolean empty) { 
        super.updateItem(item, empty); 
        setGraphic(null); 
        setText(null); 
        setContentDisplay(ContentDisplay.LEFT); 
        if (!empty && item != null) { 
        	nomSite.setText(item.getNomSite()); 
        	orderSellPrice.setText(item.getOrderSellPrice()); 
        	orderSellQuantity.setText(item.getOrderSellQuantity()); 
        	orderBuyPrice.setText(item.getOrderBuyPrice()); 
        	orderBuyQuantity.setText(item.getOrderBuyQuantity()); 
            setText(null); 
            setGraphic(content); 
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
        } 
    } 
}
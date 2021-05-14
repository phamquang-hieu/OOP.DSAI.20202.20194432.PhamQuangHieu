package hust.soict.dsai.javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	
    @FXML
    private Pane drawingAreaPane;
    private int mode;
    
    @FXML 
    private void penMode(ActionEvent event) {
    	this.mode = 0;
    }
    
    @FXML
    private void erasorMode(ActionEvent event) {
    	this.mode = 1;
    }
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if(this.mode==0) {
	    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
	    	drawingAreaPane.getChildren().add(newCircle);
    	}
    	else {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
	    	drawingAreaPane.getChildren().add(newCircle);
    	}
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

}


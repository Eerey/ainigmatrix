package view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class VPane extends Pane{

	public VPane(){
		init();
	}
	public void init(){
	     this.setStyle("-fx-background-color: black;");
	     this.setPrefSize(200,200);
	}
	public void drawForms(){
		 Circle circle = new Circle(50,Color.BLUE);
		 circle.relocate(20, 20);
		 Rectangle rectangle = new Rectangle(100,100,Color.RED);
	     rectangle.relocate(70,70);
	     this.getChildren().add(circle);
	     this.getChildren().add(rectangle);
	}
	
}

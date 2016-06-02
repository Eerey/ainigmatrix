package view;

import model.Matrix;
import model.MatrixElement;
import model.Threader;
import javafx.scene.Group;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class VPane extends Pane {
	Matrix matrix;
	MatrixElement[][] matrixArray;
	public MatrixElement dummy = new MatrixElement(20, 70);
	Group group = new Group();

	public VPane() {
		init();
		this.matrix = Matrix.getInstance();
		matrix.fillMatrix();
		this.matrixArray = matrix.getMatrix();
		addMatrixElements();
		//group.getChildren().add(dummy);
		this.getChildren().add(group);
		//this.getChildren().add(matrixArray[0][0]);
		updateScreen();
	}

	public void init() {
		this.setStyle("-fx-background-color: black;");
		this.setPrefSize(200, 200);

		//dummy.setText(String.valueOf(Math.random()));
	}
	
	public void addMatrixElements(){
		for (int i = 0; i < matrix.getLength(); i++) {
			for (int j = 0; j < matrix.getHght(); j++) {
					group.getChildren().add(matrixArray[i][j]);
			}
		}
	}
	public void updateScreen(){
		for (MatrixElement[] x : matrixArray){
			for (MatrixElement e : x){
				e.setText(String.valueOf(Math.random()));
			}
		}
	}

	public void drawForms() {
		Circle circle = new Circle(50, Color.BLUE);
		circle.relocate(20, 20);
		Rectangle rectangle = new Rectangle(100, 100, Color.RED);
		rectangle.relocate(70, 70);
		this.getChildren().add(circle);
		this.getChildren().add(rectangle);
	}

	public void drawMatrix() {

		for (int i = 0; i < 2; i++) {
			for (int j = 3; j < 5; j++) {
				// g.setFont(g.getFont().deriveFont(12.0f));
				try{
					this.getChildren().add(createText("Yo"));
				}catch(Exception e){}
				//c = new Color(0, matrixArray[i][j].getAlpha(), 0,matrixArray[i][j].getAlpha());

			}
		}

	}
	
	public Text createText(String string){
	      Text t2 = new Text();
	      t2.setX(20.0f);
	      t2.setY(140.0f);
	      t2.setCache(true);
	      t2.setText(string);
	      t2.setFill(Color.RED);
	      t2.setFont(Font.font(null, FontWeight.BOLD, 36));
	      t2.setEffect(new GaussianBlur());
	      return t2;
	}
}
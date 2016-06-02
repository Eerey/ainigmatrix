package model;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MatrixElement extends Text{

	private int x = (int)(Math.random()*100)+80;
	//private int alpha = 255;
	private int alpha = (int) (Math.random()*255);
	public static int snake_length = 8;
	boolean highlight = false;
	float scalar = 1f;
	float xPos, yPos;
	
	public MatrixElement(float x, float y){
		if (alpha<230) alpha = 30;
		xPos = x;
		yPos = y;
		init2(String.valueOf((int)(Math.random()*10)));

	}
	
	public void init2(String string){

	      setX(xPos+50);
	      setY(yPos+50);
	      setCache(true);
	      setText(string);
	      setFill(Color.RED);
	      setFont(Font.font(null, FontWeight.BOLD, 11));
	      setEffect(new GaussianBlur(2));

	}
	
	public void changeTextRandom(){
		this.setText(String.valueOf(Math.random()));
		setEffect(new GaussianBlur(Math.random()*4));
		
	}


	
	
}

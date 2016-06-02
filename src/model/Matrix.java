package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Matrix extends JPanel {

	private final int lngth = 10;
	private final int hght = 10;
	public static int chance_head = 250;
	public static int scalar = 30;
	private MatrixElement[][] matrix = new MatrixElement[lngth][hght];
	private MatrixElement[][] matrix_reserve = new MatrixElement[lngth][hght];
	public static Color c = null;
	public static double chance_highlight = 0.0025;
public static boolean red = false;
public static boolean green = true;
public static boolean blue = false;
public static boolean spasm = false;
public static boolean toggle_display = false;

private static Matrix instance;
	private Matrix() {

	}
	public static Matrix getInstance(){
		if (Matrix.instance == null) {
			Matrix.instance = new Matrix ();
		    }
		    return Matrix.instance;
	}


	public void fillMatrix() {
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght; j++) {
				matrix[i][j] = new MatrixElement(i*scalar,j*scalar);
			}
		}
	}



	
	public void changeTextRandom(){
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght; j++) {
				matrix[i][j].setText(String.valueOf(Math.random()));
				
			}
		}
	}

	public MatrixElement[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(MatrixElement[][] matrix) {
		this.matrix = matrix;
	}

	public int getLength() {
		return lngth;
	}

	public int getHght() {
		return hght;
	}





}

package model;

import sun.font.CreatedFontTracker;
import view.VPane;
import javafx.application.Platform;
import javafx.scene.layout.Pane;


public class Threader extends Thread{

	public MatrixElement[][] matrixArray = null;
	public Matrix matrix = null;
	public VPane pane = null;
	public static int time = 250;
	public static int iterations = 2;
	public static boolean run = false;
	
	public Threader(MatrixElement[][] matrix, Matrix feld, VPane pane){
		this.matrix = feld;
		this.matrix.fillMatrix();
		this.matrixArray = this.matrix.getMatrix();
		this.pane = pane;
		run = true;
	}
	
	public void sleepMe(int time){
		try {
			this.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		sleepMe(200);
		if (pane!=null)
		
		while(run){
			for (MatrixElement[] x : matrixArray){
				for (MatrixElement e : x){
					e.changeTextRandom();
				}
			}
			sleepMe(time);
			try{
			if (pane.dummy!=null)pane.dummy.setText(String.valueOf(Math.random()));	
			} catch(Exception e){}
			}
			pane.updateScreen();
			System.out.println("hmm");
			
	
		}
	}
	
}

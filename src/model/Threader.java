package model;


public class Threader extends Thread{

	private MatrixElement[][] matrix = null;
	private Matrix feld = null;
	public static int time = 25;
	public static int iterations = 2;
	
	public Threader(MatrixElement[][] matrix, Matrix feld){
		this.matrix = matrix;
		this.feld = feld;
		
		 
		
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


		for(;;){
			sleepMe(time);
			feld.moveMatrix();
			feld.repaint();
			
			
			for(int i = 0; i<iterations;i++){
				if(time>0)this.sleepMe(time);
				//feld.alphaRandomMatrix();
				feld.highLight();
				feld.fillMatrixRandom();
				feld.repaint();
				//System.out.println("schleife");
			}
			
			
			
		
	
		}
	}
	
}

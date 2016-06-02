package control;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Matrix;
import model.MatrixElement;


public class MouseEventHandler extends MouseAdapter {
		
	private MatrixElement[][] matrix = null;
	private Matrix feld = null;
		public MouseEventHandler(Matrix feld){
			this.feld = feld;
			this.matrix = feld.getMatrix();
		}
		
		
		public void mousePressed(MouseEvent e) 
												
		{
			int xP = e.getX() ;
			int yP = e.getY() ;

			// g.drawLine(e.getX(), e.getY(), xP - xR, yP - yR);
			// g.drawRect(e.getX(), e.getY(), xP - xR, yP - yR);

			System.out.println(xP+" X pressed | "+yP+" Y pressed");

			int feldansteuerungX = xP / 14;
			int feldansteuerungY = yP / 14;
			
	
		}

		public void mouseDragged(MouseEvent e) {
			System.out.println(e.getX() + " X dragged | "+e.getY() + " Y dragged");
			int xP = e.getX() ;
			int yP = e.getY() ;
			//matrix[xP/Feld.fieldsize][yP/Feld.fieldsize].setAlpha(255);
			matrix[xP/Matrix.fieldsize][yP/Matrix.fieldsize].setAlpha(255);;
		}
		
		
	}
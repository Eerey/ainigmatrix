package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Engine;
import model.Matrix;
import model.MatrixElement;

public class VPanelMatrix extends JPanel{

	Matrix matrixSingleton;
	
	public VPanelMatrix(){
		//this.setBackground(Color.BLACK);
		//this.setSize(640, 480);
		//this.setVisible(true);
		this.matrixSingleton = Matrix.getInstance();
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getHeight() * 2, this.getWidth() * 2);
		
		String x = "abcdefhjik";

		
		
		for (int i = 0; i < lngth; i++) {
			for (int j = 3; j < hght; j++) {
				g.setFont(g.getFont().deriveFont(12.0f));
				// Color c = new Color(255, 0, 0, matrix[i][j].getAlpha());

				if (this.green)c = new Color(0, matrix[i][j].getAlpha(), 0,
						matrix[i][j].getAlpha());
				if (this.red)c = new Color(matrix[i][j].getAlpha(),0 , 0,
						matrix[i][j].getAlpha());
				if (this.blue)c = new Color(0, 0, matrix[i][j].getAlpha(),
						matrix[i][j].getAlpha());
				if (this.spasm)c = new Color( (int)(Math.random()*255), (int)(Math.random()*255),  (int)(Math.random()*255),
						matrix[i][j].getAlpha());
				

				g.setColor(c);
				// (int)(Math.random()*255)
				int temp = matrix[i][j].getXunknown() / 11;

				g.drawString(x.substring(temp, temp + 1), i * fieldsize,
						(j - 3) * fieldsize);
				if (matrix[i][j].getAlpha() > 250) {
					g.setFont(g.getFont().deriveFont(10.0f));
					
					if (this.green)c = new Color(0, 255, 0,
							matrix[i][j].getAlpha());
					if (this.red)c = new Color(255,0 , 0,
							matrix[i][j].getAlpha());
					if (this.blue)c = new Color(0, 0, 255,
							matrix[i][j].getAlpha());
					if (this.spasm)c = new Color( (int)(Math.random()*255), (int)(Math.random()*255),  (int)(Math.random()*255),
							matrix[i][j].getAlpha());
					
					
					//g.setColor(new Color(0, 255, 0, 255));
					g.drawString(x.substring(temp, temp + 1), i * fieldsize,
							(j - 3) * fieldsize);

				}

				if (matrix[i][j].highlight) {
					g.setFont(g.getFont().deriveFont(10.0f));
					g.setColor(new Color(matrix[i][j].getAlpha(), matrix[i][j].getAlpha(), matrix[i][j].getAlpha(), 255));
					g.drawString(x.substring(temp, temp + 1), i * fieldsize,
							(j - 3) * fieldsize);
//					if ((i+1) <lngth&&(j+1)<hght&&(i>0)&&(j>0)){
//					matrix[i][j-1].increaseAlpha();
//					matrix[i][j+1].increaseAlpha();
//					matrix[i-1][j].increaseAlpha();
//					matrix[i+1][j].increaseAlpha();
//					}
//					g.drawString(x.substring(temp, temp + 1), (i) * fieldsize,
//							(j - 2) * fieldsize);
//					g.drawString(x.substring(temp, temp + 1), (i) * fieldsize,
//							(j - 4) * fieldsize);
//					g.drawString(x.substring(temp, temp + 1), (i+1) * fieldsize,
//							(j - 3) * fieldsize);
//					g.drawString(x.substring(temp, temp + 1), (i-1) * fieldsize,
//							(j - 3) * fieldsize);

				}
			
			}
		}
		
		// System.out.println("PaintMechanism - Feld");
		if (toggle_display){
			g.setFont(g.getFont().deriveFont(17.0f));
			g.setColor(new Color(0,255,0,100));
			g.drawRect((this.getWidth()/3)-1, (this.getHeight()/3)-1, (this.getWidth()/3)+2, (this.getHeight()/3)+2);
			g.setColor(new Color(0,0,0,250));
			g.fillRect(this.getWidth()/3, this.getHeight()/3, this.getWidth()/3, this.getHeight()/3);
			g.setColor(new Color(0,255,0,100));
			int j = this.getWidth()/54;
			int i = this.getHeight()/54;
			g.drawString("Spawnrate Trails: "+String.valueOf(this.chance_head)+"",this.getWidth()/3+j, this.getHeight()/3+j*2);
	
			g.drawString("Trails Length   : "+String.valueOf(MatrixElement.snake_length),this.getWidth()/3+j, this.getHeight()/3+j*3);
		
			g.drawString("Time            : "+String.valueOf(Engine.time),this.getWidth()/3+j, this.getHeight()/3+j*4);
		
			g.drawString("Iterations      : "+String.valueOf(Engine.iterations),this.getWidth()/3+j, this.getHeight()/3+j*5);
			
			if (green)g.drawString("Color Mode      : PURE MATRIX",this.getWidth()/3+j, this.getHeight()/3+j*6);
		
			if (red)g.drawString("Color Mode      : RED FOX",this.getWidth()/3+j, this.getHeight()/3+j*6);
			if (blue)g.drawString("Color Mode      : BLUE ORCA",this.getWidth()/3+j, this.getHeight()/3+j*6);
			if (spasm)g.drawString("Color Mode      : SPASM!!!11",this.getWidth()/3+j, this.getHeight()/3+j*6);
			g.drawString("Zoom            : "+String.valueOf(fieldsize),this.getWidth()/3+j, this.getHeight()/3+j*7);
		
			
			g.setColor(new Color(100,100,100,100));
			g.drawString("Left Arrow = Decrease   Right Arrow = Increase",this.getWidth()/3+j, (int)(this.getHeight()/3+j*2.5));
			g.drawString("1 = Increase      2 = Decrease",this.getWidth()/3+j, (int)(this.getHeight()/3+j*3.5));
			g.drawString("+ = Increase      - = Decrease [NUMLOCK PAD]",this.getWidth()/3+j, (int)(this.getHeight()/3+j*4.5));
			g.drawString("Arrow Up = Increase     Arrow Down = Decrease",this.getWidth()/3+j, (int)(this.getHeight()/3+j*5.5));
			g.drawString("F3 = Green, F4 = Red, F5 = Blue, F6 = Spasm",this.getWidth()/3+j, (int)(this.getHeight()/3+j*6.5));
			g.drawString("F1 = Zoom in    F2 = Zoom out",this.getWidth()/3+j, (int)(this.getHeight()/3+j*7.5));
			
		}
	}
}

package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Matrix extends JPanel {

	private final int lngth = 128;
	private final int hght = 84;
	public static int chance_head = 250;
	public static int fieldsize = 17;
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

	public void fillMatrix() {
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght; j++) {
				matrix[i][j] = new MatrixElement();
			}
		}
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght; j++) {
				matrix_reserve[i][j] = new MatrixElement();
			}
		}
	}

	public void fillMatrixRandom() {
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght; j++) {
				if (Math.random() < 0.089) {
					matrix[i][j].setX((int) ((Math.random() * 200) + 40));
					// System.out.println("random!");
				}
			}
		}

	}

	public void clearMatrix() {
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght; j++) {
				matrix[i][j].setX(0);
			}
		}
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght; j++) {
				matrix_reserve[i][j].setX(0);
			}
		}
	}

	public void alphaRandomMatrix() {
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght; j++) {
				if (matrix[i][j].getAlpha() < 30)
					matrix[i][j].setAlpha(((int) (Math.random() * 30)));
				if (matrix[i][j].getAlpha() < 10)
					matrix[i][j].setAlpha(0);
			}
		}
	}

	public void highLight() {
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght - 2; j++) { // ist -2 wirklich sinnvoll...?
				if ((matrix[i][j].getAlpha() > 25)
						&& (matrix[i][j].getAlpha() < 35)) {
					if ((matrix[i][j].getAlpha()) < (matrix[i][j + 1]
							.getAlpha())
							&& (matrix[i][j + 1].getAlpha()) < (matrix[i][j + 2]
									.getAlpha())) {
						if (Math.random() < chance_highlight)
							matrix_reserve[i][j].setHighlight(true);
					}
				}
			}
		}
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght - 1; j++) {
				if (matrix[i][j].highlight) {
					matrix_reserve[i][j + 1].highlight = true;
					matrix_reserve[i][j].highlight = false;

				}

				if (matrix[i][j].getAlpha() == 255)
					matrix_reserve[i][j].setHighlight(false);
			}
		} // RESERVIERFELD BEACHTEN!!!!!!
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght; j++) {
				matrix[i][j].highlight = matrix_reserve[i][j].highlight;
			}
		} // RESERVIERFELD BEACHTEN!!!!!!

	}

	public void moveMatrix() {
		// for (Obj[] j : matrix){
		// for (Obj i : j){
		//
		// }
		// }
		int dyno = 1;
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght; j++) {
				try {

					if (j - 1 == 0) {
						matrix_reserve[i][j] = new MatrixElement();

					}
					if (j - 1 > 0) {
						matrix_reserve[i][j].setX(matrix[i][j - 1].getX());

						if (matrix[i][j - 1].getAlpha() >= chance_head) {
							// matrix_reserve[i][j].setAlpha(246+((int)(Math.random()*9)));
							matrix_reserve[i][j].setAlpha(255);
							matrix_reserve[i][j - 1].setAlpha(150);
							// if(j - 2 > 0)
							// matrix_reserve[i][j-1].setAlpha(150);
							// matrix_reserve[i][j-1].setAlpha(matrix_reserve[i][j-1].getAlpha()-((dyno)*(int)Math.random()));
						}

						if (matrix[i][j - 1].getAlpha() == 150) {
							matrix_reserve[i][j].setAlpha(150);
							matrix_reserve[i][j - 1].setAlpha(120);
							// (int)(Math.random()*10)+20
						}

						if (matrix[i][j - 1].getAlpha() <= 120) {
							// matrix_reserve[i][j].setAlpha((matrix[i][j-1].getAlpha()));
							// matrix_reserve[i][j-1].setAlpha((matrix[i][j-1].getAlpha())-(dyno));
							// matrix_reserve[i][j-1].setAlpha((matrix[i][j-1].getAlpha())-dyno);

							// matrix_reserve[i][j].setAlpha(matrix[i][j-1].getAlpha());
							matrix_reserve[i][j - 1].decreaseAlpha();
							// matrix_reserve[i][j-1].setAlpha((matrix[i][j-1].getAlpha())-(dyno));
						}

						// OUT OF REACH <= 15!!!!!!
						if (matrix[i][j - 1].getAlpha() <= 15) {
							matrix_reserve[i][j]
									.setAlpha((int) (Math.random() * 10));
							// (int)(Math.random()*10)+20
						}
					}
					// System.out.println(i+" "+j);
				} catch (Exception e) {
					System.out.println("Fehler 1");
				}
			}
		}
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght; j++) {
				try {
					matrix[i][j].setX(matrix_reserve[i][j].getX());
					matrix[i][j].setAlpha(matrix_reserve[i][j].getAlpha());

				} catch (Exception e) {
					System.out.println("Fehler 2");
				}
			}
		}
	}

	public void decreaseAlphaAll() {
		for (int i = 0; i < lngth; i++) {
			for (int j = 0; j < hght; j++) {

			}
		}

	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getHeight() * 2, this.getWidth() * 2);
		
		String x = "漢字あたアカサザジズゼゾシスセソキクケコイウ";

		
		
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
				int temp = matrix[i][j].getX() / 11;

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
		
			g.drawString("Time            : "+String.valueOf(Threader.time),this.getWidth()/3+j, this.getHeight()/3+j*4);
		
			g.drawString("Iterations      : "+String.valueOf(Threader.iterations),this.getWidth()/3+j, this.getHeight()/3+j*5);
			
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

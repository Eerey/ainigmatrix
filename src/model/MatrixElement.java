package model;

public class MatrixElement {

	private int x = (int)(Math.random()*100)+80;
	//private int alpha = 255;
	private int alpha = (int) (Math.random()*255);
	public static int snake_length = 8;
	boolean highlight = false;
	
	public boolean isHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

	private double chance = 0D;
	
	public MatrixElement(){
		if (alpha<230) alpha = 30;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}
	
	public void decreaseAlpha(){
		if (alpha>15&&alpha<246) alpha=alpha-((int)(Math.random()*snake_length));
		//if (alpha>20&&alpha<246) alpha=(int) ((int)alpha*0.9f);
		
		if (alpha<13) alpha = 0;
	}
	public void increaseAlpha(){
		if (alpha<200) alpha = 50;
	}
	
	
}

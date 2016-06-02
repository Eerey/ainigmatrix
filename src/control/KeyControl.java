package control;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Matrix;
import model.MatrixElement;
import model.Threader;


public class KeyControl extends KeyAdapter

{
	private int key = 0;


	public KeyControl() {

	}

	

	public void keyPressed(KeyEvent e) {
		
		key = e.getKeyCode();
		System.out.println(key);
		
		if (key == KeyEvent.VK_1 ) {
			try {
				if (MatrixElement.snake_length > 0)MatrixElement.snake_length--;
			} catch (Exception io) {
			}

			// drawfield(113);

		}
		if (key == KeyEvent.VK_BACK_SPACE) {
			try {
			
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_2) {
			try {
				if (MatrixElement.snake_length < 15)MatrixElement.snake_length++;
			} catch (Exception io) {
			}

			// drawfield(113);

		}
		if (key == KeyEvent.VK_ESCAPE) {
			try {
				System.exit(1);
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_CONTROL) {
			try {

				System.out.println("pencil");
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_F1) {
			try {
			if(Matrix.fieldsize>2)
				Matrix.fieldsize--;
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_F2) {
			try {
				if(Matrix.fieldsize<25)
					Matrix.fieldsize++;
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_F3) { // color default (green)
			try {
				Matrix.red = false;
				Matrix.blue = false;
				Matrix.green = true;
				Matrix.spasm = false;
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_F4) { // color red
			try {
				Matrix.red = true;
				Matrix.blue = false;
				Matrix.green = false;
				Matrix.spasm = false;
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_F5) { // color blue
			try {
				Matrix.red = false;
				Matrix.blue = true;
				Matrix.green = false;
				Matrix.spasm = false;
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_F6) { // color spasm
			try {
				Matrix.red = false;
				Matrix.blue = false;
				Matrix.green = false;
				Matrix.spasm = true;
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_5) {
			try {
				
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_6) {
			try {
				
			} catch (Exception io) {

			}
		}
		if (key == 84) { // T auf der Tastatur!
			try {
				Matrix.toggle_display = (!Matrix.toggle_display);
			} catch (Exception io) {

			}
		}
		if (key == 38) { // pfeil hoch
			try {
				if(Threader.iterations<30)Threader.iterations++;
			} catch (Exception io) {

			}
		}
		if (key == 40) { // pfeil runter
			try {
				if(Threader.iterations>0)Threader.iterations--;
			} catch (Exception io) {

			}
		}
		if (key == 37) { // pfeil links
			try {
			
				if (Matrix.chance_head < 255)
					Matrix.chance_head++;
			} catch (Exception io) {

			}
		}
		if (key == 39) { // pfeil rechts
			try {
				if (Matrix.chance_head > 240)
					Matrix.chance_head--;
			} catch (Exception io) {

			}
		} 
		if (key == 107) { //NumLock +
			try {
				if (Threader.time==1000)Threader.time=100;
				if (Threader.time>0)Threader.time--;
				if (Threader.time==0)Threader.time = 0;
				
			} catch (Exception io) {

			}
		}
		if (key == 109) { //NumLock -
			try {
			
				if (Threader.time<100)Threader.time++;
				if (Threader.time==100)Threader.time=1000;
			} catch (Exception io) {

			}
		}

		if (key == KeyEvent.VK_SPACE) {
			try {
	
				
			} catch (Exception io) {
			}

			// drawfield(113);

		}
	}
	public void keyReleased(KeyEvent e) {
		
		key = e.getKeyCode();
		System.out.println(key);
		
		if (key == KeyEvent.VK_1 || key == 107) {
			try {
				// || key == KeyEvent.
				// if(tickTimer>8){
		
			} catch (Exception io) {
			}

			// drawfield(113);

		}
		if (key == KeyEvent.VK_BACK_SPACE) {
			try {
			
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_2 || key == 109) {
			try {

			} catch (Exception io) {
			}

			// drawfield(113);

		}
		if (key == KeyEvent.VK_ESCAPE) {
			try {
				System.exit(1);
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_CONTROL) {
			try {

				System.out.println("pencil");
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_F1) {
			try {
			
			} catch (Exception io) {

			}
		}
		if (key == KeyEvent.VK_5) {
			try {
				
			} catch (Exception io) {

			}
		}
		if (key == 69) {
			try {
			
			} catch (Exception io) {

			}
		}
		if (key == 38) { // pfeil hoch
			try {
				//player.setSpeed(0); Mario/Metroid Jump-Stop
			} catch (Exception io) {

			}
		}
		if (key == 40) { // pfeil runter
			try {
			
			} catch (Exception io) {

			}
		}
		if (key == 37) { // pfeil links
			try {
			
			} catch (Exception io) {

			}
		}
		if (key == 39) { // pfeil rechts
			try {
		
				
			} catch (Exception io) {

			}
		} 
		if (key == 107) { //NumLock +
			try {
			
			} catch (Exception io) {

			}
		}
		if (key == 109) { //NumLock -
			try {
			
			} catch (Exception io) {

			}
		}

		if (key == KeyEvent.VK_SPACE) {
			try {
			
				
			} catch (Exception io) {
			}

			// drawfield(113);

		}
	}
}

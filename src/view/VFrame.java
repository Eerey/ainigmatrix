package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

import model.Matrix;
import model.Threader;

import control.KeyControl;
import control.MouseEventHandler;



public class VFrame extends JFrame{

	private int int_01 = 0;
	private Matrix feld = null;
	
	
	public VFrame(){
		this.setBackground(Color.BLACK);
		this.setSize(1920, 1080);
		this.setLocation(220,0);
		this.setUndecorated(false);
		//this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(3);
		feld = Matrix.getInstance();
		feld.fillMatrix();
		for(int i = 0; i<80;i++){
		feld.moveMatrix();
		}
		this.add(feld);
		System.out.println(feld.getWidth()+" "+feld.getHeight());
		
		
		this.addKeyListener(new KeyControl());
		
		MouseEventHandler combination_handler = new MouseEventHandler(feld); // Beinhaltet
		// 2
		// verschiedene
		// MouseListener!
		this.addMouseListener(combination_handler); // Erfasst pressed() etc.!
		this.addMouseMotionListener(combination_handler); // Erfasst beudes


		Threader x1 = new Threader(feld.getMatrix(), feld);
		x1.start();
		
		
		this.setVisible(true);
		
	}

	public static void main(String args[]){
		VFrame ob = new VFrame();
	}
	

	
}

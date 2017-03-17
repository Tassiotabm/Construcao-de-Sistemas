package graphic;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Plane extends JPanel{

	private static ImageIcon plane;
	private static Image planeimg;
	private static int x;
	private static int y;
	private static int width;
	private static int height;
	private static int speed = 3;
	
	Plane(){
		plane = new ImageIcon("images/plane.png");
		x = 650;
		y = 520;
		width = 60;
		height = 60;
	}
	@Override
	protected void paintComponent(Graphics g){
		g.drawImage(this.getPlane().getImage(),this.x,this.y,this.width,this.height,null);
	}
	
	public void setY(int y) {
		this.y = y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public ImageIcon getPlane() {
		return plane;
	}
	public void incX(int x1){
		x = x + x1;
	}
	public void incY(int y1){
		y = y + y1;
	}
	public void movePlane(){
		this.incX(speed);
		this.incY(speed);
	}
}

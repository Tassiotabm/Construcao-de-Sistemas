package graphic;

import java.awt.Color;

public class Sinais{
	private int x;
	private int y;
	private Color cor;
	private Color tempcor;
	
	public Sinais(){
		this.x = 0;
		this.y = 0;
		this.cor = Color.red;
		this.tempcor = Color.red;
	}
	public void setCor(Color c){
		this.cor = c;
	}
	public void settempCor(Color c){
		this.tempcor = c;
	}
	public void setCoord(int x1,int y1){
		this.x = x1;
		this.y = y1;
	}
	public int retX(){
		return this.x;
	}
	public int retY(){
		return this.y;
	}
	public Color retCor(){
		return this.cor;
	}
	public Color rettempCor(){
		return this.tempcor;
	}
}
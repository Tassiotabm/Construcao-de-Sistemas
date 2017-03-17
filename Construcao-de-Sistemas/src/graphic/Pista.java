package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Pista extends JPanel implements ActionListener,MouseListener,ItemListener {
	Timer tm = new Timer(10,this);
	private static Plane Av;
	int x = 0,velX = 2;
	public static ArrayList<TiposSinais	> sinalPista;
	public static Color temp = Color.RED;

	
	private static Image image2 = new ImageIcon("images/pic2.jpg").getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
	private static Image plane2 = new ImageIcon("images/plane.png").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);

	
	@SuppressWarnings("static-access")
	public Pista(ArrayList<TiposSinais> sinalPista2,Plane air) {
		// TODO Auto-generated constructor stub
		this.Av = air;
		this.sinalPista = sinalPista2;
		addMouseListener(this);
	}
	
	public void printer(Graphics G){
	    // Desenhar os sinais da estrura de lista de tipos de Sinais
		for( TiposSinais l1 : sinalPista){
			for( Sinais l2 : l1.listaSinais ){
			    G.setColor(l2.retCor());
				G.drawRect(l2.retX(),l2.retY(), 10, 10);
				G.fillRect(l2.retX(),l2.retY(), 10, 10);  
			}
		}
	}

	public void paint(Graphics g){
		//super.paintComponent(g);		
		g.drawImage(image2,0,0,null);
		g.drawImage(plane2,this.x,500,null);
		//PARA FAZER ESTATICO APENAS DESCOMENTE ABAIXO
		printer(g);
		tm.start();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if( x < 0 ||x > 500)
			velX = -velX;
		x = x + velX;
		
		for(TiposSinais l1 : sinalPista){
			if(arg0.getSource() == l1.retButton()){
				if(l1.listaSinais.get(0).rettempCor() == Color.RED){
					l1.changeColor(Color.YELLOW);
					l1.changetempColor(Color.YELLOW);
				}
				else if(l1.listaSinais.get(0).rettempCor() == Color.YELLOW){
					l1.changeColor(Color.RED);
					l1.changetempColor(Color.RED);
				}
			}
			Av.movePlane();
			printer(this.getGraphics());
		}
		repaint();
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		for(TiposSinais l1 : sinalPista){
			if(arg0.getSource() == l1.retButton()){
				temp = l1.listaSinais.get(0).retCor();
				System.out.println("Mudando de cor");
				l1.changeColor(Color.WHITE);
				l1.changeButtonColor(Color.YELLOW);}
			printer(this.getGraphics());
			repaint();
		}
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		for(TiposSinais l1 : sinalPista){
			if(arg0.getSource() == l1.retButton()){
				System.out.println("Mudando de cor");
				l1.changeColor(l1.listaSinais.get(0).rettempCor()	);
				l1.changeButtonColor(Color.white);}
		printer(this.getGraphics());
		repaint();}
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		Point p = arg0.getPoint();
		System.out.println(p.toString());
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
	
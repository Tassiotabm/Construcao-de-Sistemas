package graphic;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import graphic.TiposSinais;

@SuppressWarnings("serial")
public class MainInterface extends JFrame implements ActionListener,MouseListener,ItemListener {

	private static JPanel fs;
	private static JPanel menu;
	private static JPanel foot;
	private static Plane Av;
	public static Color temp = Color.RED;
	public static ArrayList<TiposSinais	> sinalPista;
	
	public MainInterface(){
		/*******************************************/
		super("Controle de Pista de Aeroporto");
		this.setSize(800, 800);
		//this.setLayout(new BorderLayout());
		/*******************************************/
		// Carregar o plane
		Av = new Plane();
		// Chamar função de criar os sinais da pista
		carregaLista();		
		//Deixar descomentado enquanto testo e vejo as posicoes dos sinais
		//addMouseListener(this);
		//Set components to Frame
		addPanels();
		/*******************************************/
		FlowLayout layout = new FlowLayout();
		layout.setHgap(0);
		layout.setVgap(0);
		this.setLayout(layout);
		this.setBackground(Color.BLACK);
		this.setForeground(Color.BLACK);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		/*******************************************/
	}
	public void addPanels(){ /*Adicionar conteiners ao JFrame(this)*/	
		//this.setLayout(new GridLayout(3,1,0,0));
		fs = new Pista(sinalPista,Av);
		menu = new JPanel();
		foot = new JPanel();
		// Configurar os JPanels
		configPista();
		configMenu();
		rodaPe();
		// Adicionar os JPanels
		this.add(fs);
		this.add(menu);
		this.add(foot);
	}
	public void configPista(){
		// Configuração da Label da pista
		//pista.setSize(800,600);
		fs.setBackground(Color.black);
		fs.setForeground(Color.black);
		fs.setSize(500,500);
		fs.setPreferredSize(new Dimension(800,600));
		fs.setMinimumSize(new Dimension(800,600));
		
		
		//pista.setMinimumSize(new Dimension(800,600));
		/*********************************************************/
		// Aqui vamos tratar o "Background da imagem"
		//imageTemp = aeroportoImage(image.getImage(),Av.getPlane().getImage());
		//finalImage = new ImageIcon(image2);
		//label = new JLabel("", finalImage, JLabel.CENTER);
		/*********************************************************/
		//pista.add(label);
		//pista.setBackground(Color.BLACK);
	}
	public void configMenu(){
		menu.setForeground(Color.BLACK);
		menu.setSize(800,80);
		menu.setPreferredSize(new Dimension(800,100));
		
		
		for( TiposSinais l1 : sinalPista){
			menu.add(l1.retButton());
			l1.retButton().addActionListener(this);
			l1.retButton().addMouseListener(this);
		}

		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		menu.setBorder(blackline);
		
		menu.setBackground(Color.BLACK);
	}
	public void rodaPe(){
		foot.setSize(800,40);
		foot.setMaximumSize(new Dimension(800,40));
		foot.setPreferredSize(new Dimension(800,40));
		foot.setBackground(Color.black);
		foot.setForeground(Color.black);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		for(TiposSinais l1 : sinalPista){
			if(arg0.getSource() == l1.retButton()){
				temp = l1.listaSinais.get(0).retCor();
				System.out.println("Mudando de cor");
				l1.changeColor(Color.WHITE);
				l1.changeButtonColor(Color.YELLOW);}
			//printer(this.getGraphics());
			repaint();
		}
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		for(TiposSinais l1 : sinalPista){
			if(arg0.getSource() == l1.retButton()){
				System.out.println("Mudando de cor");
				l1.changeColor(l1.listaSinais.get(0).rettempCor()	);
				l1.changeButtonColor(Color.white);}
		//printer(this.getGraphics());
		repaint();}
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Point p = arg0.getPoint();
		System.out.println(p.toString());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		
		for(TiposSinais l1 : sinalPista){
			if(e.getSource() == l1.retButton()){
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
		//printer(this.getGraphics());
		}
	}
	
	public void carregaLista(){
		int cont = 0;
		String tipo;
		//Criar a lista que contem todos os tipos de sinais
		sinalPista = new ArrayList<TiposSinais>();	
		//Criar o sinal que vamos adicionar aos tipos de sinais
		TiposSinais sinalLuz1 = new TiposSinais("luz1");
		TiposSinais sinalLuz2 = new TiposSinais("luz2");
		TiposSinais sinalLuz3 = new TiposSinais("luz3");
		TiposSinais sinalLuz4 = new TiposSinais("luz4");
		
		//Adicionar os sinais a lista do tipo de sinal associado
		for(cont = 0;cont<20;cont++)
			sinalLuz1.addSinal();
		for(cont = 0;cont<15;cont++)
			sinalLuz2.addSinal();
		for(cont = 0;cont<2;cont++)
			sinalLuz3.addSinal();
		for(cont = 0;cont<4;cont++)
			sinalLuz4.addSinal();
		
		// Adicionar o tipo do sinal a lista de tipo de sinal
		sinalPista.add(sinalLuz1);
		sinalPista.add(sinalLuz2);
		sinalPista.add(sinalLuz3);
		sinalPista.add(sinalLuz4);
		
		cont = 0;
		
		// "Configurar a posicao x e y dos quadrados de sinais
		int x1,x2,x3,x4;
		int y1,y2,y3,y4;
		
		x1 = 150;y1 = 20;
		x2 = 280;y2 = 150;
		x3 = 275;y3 = 490;
		x4 = 690;y4 = 500;
		
		// Setar as coordenadas dos sinais
		for( TiposSinais l1 : sinalPista){
			tipo = l1.retType(); 
			switch(tipo){
				case "luz1":
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x1,y1+(cont*20));
						cont++;}
					break;
				case "luz2":
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x2,y2+(cont*20));
						cont++;}
					break;
				case "luz3":	
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x3+(cont*20),y3);
						cont++;}
					break;
				case "luz4":
					cont = 0;
					for( Sinais l2 : l1.listaSinais ){
						l2.setCoord(x4,y4+(cont*20));
						cont++;}
					break;}
		}
		System.out.println("Ok");
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	@Override
	public void itemStateChanged(ItemEvent arg0) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {}

}


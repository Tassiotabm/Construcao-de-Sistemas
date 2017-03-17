package graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;

public class TiposSinais {
	public ArrayList<Sinais> listaSinais;
	private String type;
	private JButton Button;
	
	public TiposSinais(String tipo){
		listaSinais = new ArrayList<Sinais>();
		this.type = tipo;
		this.addSinal();
		createButton();
	}
	private void createButton(){
		Button = new JButton();
		Button.setPreferredSize(new Dimension(100,100));
		Button.setBackground(Color.white);
		Button.setText(this.type);
	}
	public JButton retButton(){
		return this.Button;
	}
	public String retType(){
		return this.type;
	}
	public void addSinal(){
		Sinais novo = new Sinais();
		listaSinais.add(novo);
	}
	public void setNameButton(String txt){
		this.Button.setText(txt);
	}
	public void changeColor(Color cor){
		for(Sinais l1 : listaSinais){
			l1.setCor(cor);
		}
	}
	public void changetempColor(Color cor){
		for(Sinais l1 : listaSinais){
			l1.settempCor(cor);
		}
	}
	public void changeButtonColor(Color cor){
		this.Button.setBackground(cor);
	}
}

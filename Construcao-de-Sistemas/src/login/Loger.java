package login;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import graphic.MainInterface;

@SuppressWarnings("serial")
public class Loger extends JFrame implements ActionListener{
	
	private String login;
	private String senha;
	public static JFrame loginframe = new JFrame();
	JButton logarButton = new JButton("Logar");
	JTextField loginField = new JTextField();
	JTextField passwordField = new JTextField();
	MainInterface telaPrincipal;
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == logarButton){
			
			login = loginField.getText();
			senha = passwordField.getText();
			
			try {
				if(Acesso.sendInfo(login,senha) == true){
					loginframe.setVisible(false);
					telaPrincipal = new MainInterface();
				}
				else
					System.out.println("Senha incorreta");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else
			System.exit(0);
	}
	
	public Loger(){
		// Configurar as specs da tela de login
		loginframe.setLayout(new GridLayout(3,1,0,0));
		loginframe.setLocation(512, 250);
		loginframe.setSize(100, 100);
		// Configurar os botoões
		logarButton.addActionListener(this);
		// Configurar o recebimento do login e senha

		// Setar as bordas dos textos e botoes e tamanhi

		loginField.setPreferredSize(new Dimension(50,50));
		passwordField.setPreferredSize(new Dimension(50,50));

		// Ordem dos "blocos" dentro da tela de login
		loginframe.add(loginField,BorderLayout.NORTH);
		loginframe.add(passwordField,BorderLayout.CENTER);
		loginframe.add(logarButton,BorderLayout.SOUTH);
		// Setar ele visivel
		loginframe.setResizable(false);
		loginframe.setLocationRelativeTo(null);
		loginframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
}

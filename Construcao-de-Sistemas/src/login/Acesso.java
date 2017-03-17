package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.CORBA.SystemException;


final class Acesso{
	private static boolean acess;
	
	private Acesso(){
	}
	public static boolean sendInfo(String pass1,String login1)throws Exception{
		//Receber o password e login
		System.out.println("Recebendo pass");
		acess = checkAcess(pass1,login1);
		return acess;
	}
	public static boolean checkAcess(String pass2,String login2) throws SQLException{
		//Checar se o acesso é permitido com SQL em um futuro proximo
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","","");
		/*
		PreparedStatement statement = con.prepareStatement("SELECT nome FROM controlador WHERE nome=?");
		statement.setString(1, login2);

		ResultSet result = statement.executeQuery();
		while(result.next()){
			//System.out.println(result.getString(1)+""+result.getString(2));
			System.out.println(result.getString(1));
			if(result.getString(1) == login2)
				return true;
			else
				return false;
		}
		return false;*/
		return true;
	}
	
}

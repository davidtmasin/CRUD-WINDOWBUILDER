package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	//tipo de conexão+local de execução+nome do BD+fuso horário
	private static String url = "jdbc:mysql://localhost/banco_teste_curso_java?useTimezone=true&serverTimezone=UTC";
	private static String userName = "root"; //usuário do BD
	private static String userPassword = "Xablau@1992"; //Senha do usuário do BD
	
	public static Connection getConnection() {
	
		try {			
		//nome do driver utilizado dentro da classe
		Class.forName("com.mysql.cj.jdbc.Driver");
		//endereço e parâmetros de conexão com o BD
		return DriverManager.getConnection(url, userName, userPassword);
		
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		throw new RuntimeException();
		}
	}
	
}

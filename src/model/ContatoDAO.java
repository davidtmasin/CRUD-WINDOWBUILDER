package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

	private Connection con;

	public ContatoDAO() {
		//Tentativa de início de conexão
		con = new ConnectionFactory().getConnection();
	}
	
	public void salvarDAO(Contato contato) {
		//JPQL => Linguagem Java para criar query SQL
		String sql ="insert into contato(nome, idade, endereco, telefone) values(?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
	
			//Informa os valores a serem atribuídos aos campos da table agenda no BD
			ps.setString(1, contato.getNome());			
			ps.setInt(2,contato.getIdade());
			ps.setString(3, contato.getEndereco());
			ps.setString(4, contato.getTelefone());
			
			ps.execute(); //vai enviar o PreparedStatement para o BD
			ps.close(); //fecha a conexão
						
			System.out.println("Contato salvo");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editarDAO(Contato contato) {
		
		String sql = "update contato set nome=?, idade=?, endereco=?, telefone=? where id=?";					       
	
		try {
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, contato.getNome());			
			ps.setInt(2,contato.getIdade());
			ps.setString(3, contato.getEndereco());
			ps.setString(4, contato.getTelefone());
			ps.setLong(5, contato.getId());
			
			ps.execute();
			ps.close();
			
			System.out.println("Contato alterado.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletarDAO(Long id) {
		
		String sql ="delete from contato where id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setLong(1, id);
			
			ps.execute();
			ps.close();
			System.out.println("Contato excluído.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Contato> consultarDAO() {

		List<Contato> contatos = new ArrayList<>();
		
		try {

			String sql = "select * from contato";
			
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				Contato contato = new Contato();
				
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setIdade(rs.getInt("idade"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setTelefone(rs.getString("telefone"));
				
				contatos.add(contato);
			}

			rs.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		return contatos;
	}	
	
}

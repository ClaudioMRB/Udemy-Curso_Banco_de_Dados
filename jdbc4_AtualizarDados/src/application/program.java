package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import db.DB;

public class program {

	public static void main(String[] args) {

	
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			//atualizar um registro do banco de dados.
			st = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					//concatenar uma restrição, nunca fazer uma atualização sem a restrição para nao atualizar todo o banco de dados
					//e alterar o que não deve
					+ "WHERE "
					//qual e a restrição(atualizar o salario onde o departamento for igual ao valor informado)
					+ "(DepartmentId = ?)");
					
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
			System.out.println("Done! Rows affected: "+ rowsAffected);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
		
	}
}

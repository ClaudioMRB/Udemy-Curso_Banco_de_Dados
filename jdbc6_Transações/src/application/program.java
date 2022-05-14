package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class program {

	public static void main(String[] args) {

	
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			//nao e pra confirmar operações automaticamente, precisa de confirmação do programador
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1 ");
			
			//int x = 1;
			//if(x < 2) {
			//	throw new SQLException("Fake Error");
				
			//}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2 ");
			
			//confirmar que a transação confirmou
			conn.commit();
			
			System.out.println("rows1 " + rows1);
			System.out.println("rows2 " + rows2);
			
		}
		catch(SQLException e) {
			//voltar a transação caso ela tenha parado no meio, por algum erro.
			try {
				conn.rollback();
				throw new DbException("Transation rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e.getMessage());
				
			}
		}finally {
DB.closeStatement(st);
DB.closeConnection();
		}
		
		
	}
}

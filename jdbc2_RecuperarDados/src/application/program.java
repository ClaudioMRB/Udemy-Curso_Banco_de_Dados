package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;



public class program {

	public static void main(String[] args) {

		//conectar ao banco de dados
		Connection conn = null;
		/*preparar uma consulta SQL
		 * para buscar todos os departamentos
		 * do banco de dados*/
		Statement st = null;
		/*E o resultado dessa consulta vai ser guardado
		 *na variavel ResultSet rs. */
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("select * from department");	
			//enquanto existir o proximo
			while(rs.next()) {
				//para acessar um campo da resultSet
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	
		
		
		
		
		
	}

}
/*first() = move para posição 1
beforeFirst() = move posição 0*/
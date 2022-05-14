package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;



public class program {

	public static void main(String[] args) {
		
		//formatando data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//criando objeto do tipo Connection.
		Connection conn = null;
		// criar objeto pré existente.
		PreparedStatement st = null;
		//bloco try
		try {
			//conectar ao banco
			conn = DB.getConnection();
			//fazer objeto st (prepared) espera como argumento uma string que vai ser o comando SQL
			
			/*
			st = conn.prepareStatement(
					//comando inserção SQL
					"INSERT INTO seller "
					//concatenado com campos da tabela que quer receber
					+ "(Name, Email, BirthDate, BaseSalary, DEpartmentId) "
					+"VALUES "
					//valores que serão preenchido nos campos.
					+"(?, ?, ?, ?, ?) ",
					Statement.RETURN_GENERATED_KEYS);

					//comando que irá inserir os dados nos campos.
					st.setString(1, "Claudio Marcio"); //nome
					st.setString(2, "claudiomrbdev@gmail.com"); //email
					//quando vai instanciar uma data para o jdbc tem que jogar o java.sql.Date()
					st.setDate(3, new java.sql.Date(sdf.parse("14/07/1985").getTime())); //data
					st.setDouble(4, 3000.0); //salário
					//informar qual departamento quer cadastrar os dados
					st.setInt(5, 4);
					*/
			
					//comando para inserir 2 departamentos ao mesmo tempo.
					st = conn.prepareStatement(
							"insert into department (Name) values ('D1'),('D2')",
							Statement.RETURN_GENERATED_KEYS);
							
					
					//executar os comandos
					//criar variavel para receber o resultado do execute update para saber quantas linhas foram alteradas.
					int rowsAffected = st.executeUpdate();
					//System.out.println("Done! Rows affected: " + rowsAffected);
					//se rows affected for maior será mostrada a chave gerada 
					if(rowsAffected > 0) {
						ResultSet rs = st.getGeneratedKeys();
						//percorrer o ResultSet
						while(rs.next()) {
							//para cada valor
							int id = rs.getInt(1); //indica o valor da primeira coluna
							System.out.println("Done! id = "+ id);
						}
					}else {
						//senão mostrar que nenhuma linha foi alterada.
						System.out.println("No rows affected!");
					}
					
					
					
		}
		//caso aconteça alguma exceção, imprimir na tela uma msg
		catch (SQLException e) {
			e.printStackTrace();
		}
				finally {
			DB.closeStatement(st);
			DB.closeConnection();
			}
	}		
}
/*first() = move para posição 1
beforeFirst() = move posição 0*/
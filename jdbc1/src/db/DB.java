package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	//metodo para conectar ao banco de dados
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			conn = DriverManager.getConnection(url, props);
		/*pegou as propiedades + a url e conetou com o banco de dados
		e salvou objeto na variavel conn.*/
		}
			catch(SQLException e) {
				//DbException � derivada da RunTimeException.
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	/*SE A CONEX�O ESTIVER INSTANCIADA ELA SER� ENCERRADA.*/
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
			}
		}
	}

	/*criar metodo auxiliar private 
	 * para usar apenas dentro da classe
	 * para carregar as propriedades no arquivo db.properties
	 */
	private static Properties loadProperties() {
		/*abrir arquivo db.properties, ler os dados e salvar no objeto
		Properties
		*/
		try(FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
			
		}
		/* tratar uma exce��o
		 IOException
		 */		 
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
		
	}





}

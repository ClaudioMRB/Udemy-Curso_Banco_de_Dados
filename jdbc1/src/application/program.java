package application;

import java.sql.Connection;

import db.DB;

public class program {

	public static void main(String[] args) {

		//declarar variavel do tipo Connection
		Connection conn = DB.getConnection();
		//depois fechar a conexão
		DB.closeConnection();
		
	}

}

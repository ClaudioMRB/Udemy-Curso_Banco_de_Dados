package db;
						// implementa��o de excess�o.
public class DbException extends RuntimeException{
	
	private static final long serialVersionUID = 1L; 
	
	
	//for�a a excess�o ser criada com construtor.
	public DbException(String msg) {
		//transmitir a msg para a super classe
		super(msg);
	}
	
	

}

package db;
						// implementação de excessão.
public class DbException extends RuntimeException{
	
	private static final long serialVersionUID = 1L; 
	
	
	//força a excessão ser criada com construtor.
	public DbException(String msg) {
		//transmitir a msg para a super classe
		super(msg);
	}
	
	

}

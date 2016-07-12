package mz.com.cenfoss.java.excepcoes;

public class MinhaExcessao extends Exception{
	@Override
	public String getMessage() {
		return "Caiu na minha excessão!";
	}
	
}

package mz.com.cenfoss.java.excepcoes;

public class ExcecoesFinally {

	public static void main(String[] args) {
		try
		{
			aumentarLetras();
		}
		catch(NullPointerException e)
		{
			System.out.println("Ocorreu um NullPointerException ao executar o método aumentarLetras() "+e);
		}
		finally {
			System.out.println("O meu programa finalmente termina");
		}
	}
	
	private static void aumentarLetras() throws NullPointerException //lançando excessão
	{
		String frase = null;
		String novaFrase = null;
		novaFrase = frase.toUpperCase();
		System.out.println("Frase antiga: "+frase);
		System.out.println("Frase nova: "+novaFrase);
	}
}

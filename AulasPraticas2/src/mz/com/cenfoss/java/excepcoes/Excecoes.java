package mz.com.cenfoss.java.excepcoes;

public class Excecoes {
	public static void main(String args[])
	{
		String frase = null;
		String novaFrase = null;
		try
		{
			novaFrase = frase.toUpperCase();
		}
		catch(NullPointerException e) //CAPTURA DA POSSÍVEL exceção.
		{
			//TRATAMENTO DA exceção
			System.out.println("O frase inicial está nula, para solucional tal o problema, foi lhe atribuito um valor default.");
			frase = "Frase vazia";
			novaFrase = frase.toUpperCase();
		}
		System.out.println("Frase antiga: "+frase);
		System.out.println("Frase nova: "+novaFrase);
	}
}

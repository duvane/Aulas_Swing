
public class Exercicio2 {

	public static void main(String[] args) {
		int gastosJaneiro = 15000;
		int gastosFevereiro = 23000;
		int gastosMarco = 17000;
		
		int gastosTrimestre = gastosJaneiro+gastosFevereiro+gastosMarco;
		System.out.println(gastosTrimestre);
		exercicio2A(gastosFevereiro,gastosJaneiro);
	}
	private static void exercicio2A(int x, int y) {
		double quociente = x /y;
		int modulo = x % y;
		System.out.println("Quociente: "+quociente+"\nModulo"+modulo);
	}
}

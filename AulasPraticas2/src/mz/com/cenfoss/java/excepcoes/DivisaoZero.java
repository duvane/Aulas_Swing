package mz.com.cenfoss.java.excepcoes;

public class DivisaoZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			double resultado = 4/0;
			System.out.println(resultado);
		}
		catch (ArithmeticException e) {
			System.out.println("Erro de aritmetica");
		}
//		finally {
			System.out.println("Termino de execução");
//		}
		
	}

}

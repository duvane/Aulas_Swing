package mz.com.cenfoss.java.hibernate2;

import java.util.List;

public class ComputadorTest {

	public static void main(String[] args) {
		List<Computador> computadores = ComputadorDAO.getById(2);
		System.out.println(computadores);
	}
	
	public static void createComputador() {
		Computador computador = new Computador();
		computador.setMarca("Asus");
		computador.setModelo("A-555L");
		computador.setOs("Windows 10");
		computador.setRam(8);
		computador.setScreen((float) 15.4);
		ComputadorDAO.criarComputador(computador);

	}
	
	public static void readComputadores(){
		List<Computador> computadores = ComputadorDAO.getAll();
		for(Computador computador: computadores){
			System.out.println(computador.toString());
		}
	}
}

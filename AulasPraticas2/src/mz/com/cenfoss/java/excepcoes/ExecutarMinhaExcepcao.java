package mz.com.cenfoss.java.excepcoes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExecutarMinhaExcepcao {

	public static void main(String[] args) throws MinhaExcessao{
		
		if (!retornaFalse()){
			throw new MinhaExcessao();
		}
		else{
			System.out.println("Tudo correu sem problemas!");
		}

	}
	
	public static boolean retornaFalse(){
		return false;
	}
}

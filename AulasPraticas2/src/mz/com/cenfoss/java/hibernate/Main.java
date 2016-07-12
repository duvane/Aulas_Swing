package mz.com.cenfoss.java.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Celular celular = new Celular();
		celular.setCor("Preto");
		celular.setFabricante("Japão");
		celular.setMarca("Sony");
		celular.setSerial(54565464L);
		celular.setModelo("Z3 Dual");

		Celular outroCelular = new Celular();
		outroCelular.setCor("Vermelho");
		outroCelular.setFabricante("Coreia do Sul");
		outroCelular.setMarca("LG");
		outroCelular.setModelo("G4");
		outroCelular.setSerial(12313312312L);

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		
		session.save(celular);
		
		session.save(outroCelular);
		transaction.commit();
		session.close();
		factory.close();
	}

}

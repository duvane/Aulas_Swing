package mz.com.cenfoss.java.hibernate2;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public abstract class ComputadorDAO {
	
	private static Configuration configuration;
	private static SessionFactory factory;
	private static Session session;
	private static Transaction transaction;
	
	public static void criarComputador(Computador computador){
		try{
			abrirConexao();
			session.save(computador);
			fecharConexao();
		}
		catch (HibernateException e) {
			System.out.println("Erro ao persistir com a base de dados\n+"+e.getMessage());
		}
		
	}
	
	public static List<Computador> getAll(){
		abrirConexao();
		Criteria criteria = session.createCriteria(Computador.class);
		List<Computador> lista = criteria.list();
		fecharConexao();
		return lista;
	}
	
	public static List<Computador> getById(long id){
		abrirConexao();
		Criteria criteria = session.createCriteria(Computador.class);
		criteria.add(Restrictions.eq("id", id));
		List<Computador> resultados = criteria.list();
		fecharConexao();
		return resultados;
	}

	public static void abrirConexao() {
		try {
			configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");

			factory = configuration.buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
		} catch (HibernateException e) {
			System.out.println("Erro:\n" + e.getMessage());
		}
	}
	
	public static void fecharConexao() {
		try {
			session.close();
			factory.close();
		} catch (HibernateException e) {
			System.out.println("Erro:\n" + e.getMessage());
		}
	}
}
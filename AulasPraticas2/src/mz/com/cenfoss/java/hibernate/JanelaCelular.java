package mz.com.cenfoss.java.hibernate;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class JanelaCelular extends JFrame {

	private JButton gravarBtn, listarBtn; // Componentes da janela
	private JTextField marca, modelo, fabricante, serial;
	private JLabel labelMarca, labelModelo, labelFabricante, labelSerial, labelCor;
	private String[] cores = { "Preto", "Azul", "Vermelho", "Rosa", "Branco" }; // Valores
																				// do
																				// Combobox
	private JComboBox listaCores;

	private JMenu menu = new JMenu("Menu"); // MenuBar > Menu > MenuItem
	private JMenuItem menuItemSair = new JMenuItem("Sair");
	private JMenuBar menuBar = new JMenuBar();
	private Configuration configuration;
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;

	public JanelaCelular() {
		setTitle("Celular"); // Propriedades da minha janela
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		setJMenuBar(menuBar); // Definir este menu à minha janela
		menuBar.add(menu);
		menuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		menuItemSair.addActionListener(new Evento());
		menu.add(menuItemSair); // Adicionar o submenu ao menu

		Container container = getContentPane(); // Criar o painel que irá conter
												// os meus componentes visuais
		container.setLayout(new GridLayout(7, 2)); // Escolha de um layout

		labelMarca = new JLabel("Marca"); // Criação de campos de texto simples
											// (Labels)
		labelFabricante = new JLabel("País de Fabrico");
		labelModelo = new JLabel("Modelo");
		labelSerial = new JLabel("Serial");
		labelCor = new JLabel("Cor");

		marca = new JTextField(20); // Criação de campos de inserção de texto
									// (campos de texto)
		modelo = new JTextField(20);
		fabricante = new JTextField(20);
		serial = new JTextField(20);

		listaCores = new JComboBox(cores); // Criação do combobox que me permite
											// selecionar um elemento da lista
											// de cores

		container.add(labelMarca); // Adição dos meus componentes à minha
									// janela. De esquerda para direita
		container.add(marca);

		container.add(labelModelo);
		container.add(modelo);

		container.add(labelFabricante);
		container.add(fabricante);

		container.add(labelSerial);
		container.add(serial);

		container.add(labelCor);
		container.add(listaCores);

		gravarBtn = new JButton("Gravar"); // Criação do botão que irá gravar os
											// dados do formulário
		gravarBtn.setMnemonic('G');
		gravarBtn.addActionListener(new Evento()); // Adição do evento ao botão:
													// o que o botão deve fazer
													// quando for clicado

		listarBtn = new JButton("Listar");
		listarBtn.setMnemonic('L');
		listarBtn.addActionListener(new Evento());

		container.add(listarBtn);
		container.add(gravarBtn);

		pack(); // Comprime a janela para que esta não seja maior que os seus
				// componentes;
	}

	private class Evento implements ActionListener // Criação da acção
	{
		public void actionPerformed(ActionEvent ev) {
			if (ev.getSource() == gravarBtn) {
				String stringMarca, stringModelo, stringFabricante, stringCor;
				long stringSerial;

				stringMarca = marca.getText(); // Leitura dos dados do
												// formulário
				stringModelo = modelo.getText();
				stringFabricante = fabricante.getText();
				try {
					stringSerial = Long.parseLong(serial.getText());
					stringCor = (String) listaCores.getSelectedItem();

					Celular celular = new Celular(); // Criação de um celular
					celular.setFabricante(stringFabricante);
					celular.setMarca(stringMarca);
					celular.setModelo(stringModelo);
					celular.setSerial(stringSerial);
					celular.setCor(stringCor);

					/*
					 * Abertura de sessão e gravação na base de dados
					 */
					criarSessao();
					gravarNaBaseDeDados(celular);
					fecharSessao();

					String mensagem = "Registo Gravado com Sucesso";
					JOptionPane.showMessageDialog(null, mensagem);

					marca.setText(null);
					modelo.setText(null);
					fabricante.setText(null);
					serial.setText(null);
					listaCores.setSelectedIndex(0);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "O serial introduzido não é válido", "Erro",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro de execução:\n" + e.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			} else if (ev.getSource() == listarBtn) {
				listarTodos();
			} else if (ev.getSource() == menuItemSair) {
				System.exit(EXIT_ON_CLOSE);
			}
		}

	}

	public void listarTodos() {
		List<Celular> celulares = new ArrayList<Celular>();
		criarSessao();
		try {
			transaction = session.beginTransaction();
			celulares = session.createQuery("from Celular").list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			JOptionPane.showMessageDialog(null, "Erro:\n" + e.getMessage(), "Erro de Base de Dados",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			fecharSessao();
		}
		new JanelaCelularLista(celulares);
	}

	private void gravarNaBaseDeDados(Celular celular) {
		criarSessao();
		session.save(celular);
		transaction.commit();
		fecharSessao();
	}

	public void criarSessao() {
		try {
			configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");

			factory = configuration.buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
		} catch (HibernateException e) {
			JOptionPane.showMessageDialog(null, "Erro:\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void fecharSessao() {
		try {
			session.close();
			factory.close();
		} catch (HibernateException e) {
			JOptionPane.showMessageDialog(null, "Erro:\n" + e.getMessage(), "Erro de Base de Dados",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new JanelaCelular();
	}

}

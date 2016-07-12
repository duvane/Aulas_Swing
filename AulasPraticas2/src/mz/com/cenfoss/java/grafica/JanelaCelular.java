package mz.com.cenfoss.java.grafica;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
import javax.swing.JSeparator;

public class JanelaCelular extends JFrame{
	
	private List<Celular> celulares = new ArrayList<Celular>();							// Lista onde guardo os celulares que irei criar
	
	private JButton gravarBtn, listarBtn;												// Componentes da janela
	private JTextField marca,modelo,fabricante,serial;
	private JLabel labelMarca, labelModelo, labelFabricante, labelSerial, labelCor;
	private String [] cores = {"Preto","Azul","Vermelho","Rosa","Branco"};				// Valores do Combobox
	private JComboBox listaCores;
	
	
	private JMenu menu = new JMenu("Menu");												// MenuBar > Menu > MenuItem
	private JMenuItem menuItemSair = new JMenuItem("Sair");
	private JMenuBar menuBar = new JMenuBar();
	private Label label;
	private JMenuItem menuListar;
	private JSeparator separator;
	
	public JanelaCelular() {
		setType(Type.UTILITY);
		setTitle("Celular");															//Propriedades da minha janela
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setJMenuBar(menuBar);															// Definir este menu � minha janela
		menuBar.add(menu);
		
		menuListar = new JMenuItem("Listar");
		menuListar.addActionListener(new Evento());
		menuListar.setMnemonic('L');
		menu.setMnemonic('M');
		menu.add(menuListar);
		
		separator = new JSeparator();
		menu.add(separator);
		menuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UNDEFINED, 0));
		menu.add(menuItemSair);															// Adicionar o submenu ao menu
		
		Container container = getContentPane();											// Criar o painel que ir� conter os meus componentes visuais
		container.setLayout(new GridLayout(7, 2));										// Escolha de um layout
		
		
		labelMarca = new JLabel("Marca");												// Cria��o de campos de texto simples (Labels)
		labelFabricante = new JLabel("Pa�s de Fabrico");
		labelModelo = new JLabel("Modelo");
		labelSerial = new JLabel("Serial");
		labelCor = new JLabel("Cor");
		
		marca = new JTextField(20);														// Cria��o de campos de inser��o de texto (campos de texto)
		modelo = new JTextField(20);
		fabricante = new JTextField(20);
		serial = new JTextField(20);
		
		listaCores = new JComboBox(cores);												// Cria��o do combobox que me permite selecionar um elemento da lista de cores
//		listaCores.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent arg0) {
//				System.out.println("Selected "+listaCores.getSelectedItem());
//			}
//		});
//		
		container.add(labelMarca);														// Adi��o dos meus componentes � minha janela. De esquerda para direita
		container.add(marca);
		
		container.add(labelModelo);
		container.add(modelo);
		
		container.add(labelFabricante);
		container.add(fabricante);
		
		container.add(labelSerial);
		container.add(serial);
		
		container.add(labelCor);
		container.add(listaCores);
		
		gravarBtn = new JButton("Gravar");												// Cria��o do bot�o que ir� gravar os dados do formul�rio
		gravarBtn.setMnemonic('G');
		gravarBtn.addActionListener(new Evento());										// Adi��o do evento ao bot�o: o que o bot�o deve fazer quando for clicado
		
		listarBtn = new JButton("Listar");
		listarBtn.setMnemonic('L');
		listarBtn.addActionListener(new Evento());
		
//		label = new Label("");
//		getContentPane().add(label);
		container.add(listarBtn);
		container.add(gravarBtn);
		pack();																			// Comprime a janela para que esta n�o seja maior que os seus componentes;
	}
	
	private class Evento implements ActionListener										// Cria��o da ac��o para o bot�o
	  { public void actionPerformed(ActionEvent ev)
	    { if(ev.getSource() == gravarBtn)
	      { 
	    	String stringMarca, stringModelo, stringFabricante, stringCor;
	    	long stringSerial;
	    	
	        stringMarca = marca.getText();												// Leitura dos dados do formul�rio
	        stringModelo = modelo.getText();
	        stringFabricante = fabricante.getText();
	        try
	        {
	        	stringSerial = Long.parseLong(serial.getText());
	        	stringCor = (String) listaCores.getSelectedItem();
		        
		        Celular celular = new Celular();										// Cria��o de um celular										
		        celular.setFabricante(stringFabricante);
		        celular.setMarca(stringMarca);
		        celular.setModelo(stringModelo);
		        celular.setSerial(stringSerial);
		        celular.setCor(stringCor);
		        celulares.add(celular);													// Adi��o do celular a minha lista de celulares
		        
		        String mensagem = "Tamanho da lista: "+celulares.size()+"\n\nInseriu: \n"+celular.toString();	
		        JOptionPane.showMessageDialog(null,mensagem);							// Impress�o do tamanho da lista do ultimo celular inserido
	        }
	        catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "O serial introduzido n�o � v�lido", "Erro", JOptionPane.ERROR_MESSAGE);
			}
	      }
	      else if (ev.getSource() == listarBtn || ev.getSource() == menuListar)
	      {
	    	new JanelaCelularLista(celulares);  
	      }
	    }
	  }

	public static void main(String[] args) {
		new JanelaCelular();
	}

}

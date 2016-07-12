package mz.com.cenfoss.java.grafica;

import java.awt.FlowLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JanelaCelularLista extends JFrame{

	private JTable tabelaCelulares;
	private String[] keys = {"Marca", "Modelo", "Fabricante", "Serial", "Cor"};
	public JanelaCelularLista(List<Celular> celulares) 
	{
		setTitle("Lista de Celulares");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600, 450);
		setVisible(true);
		getContentPane().setLayout(new FlowLayout());
		System.out.println(celulares);
		
		Vector<String> tableHeaders = new Vector<String>();
		Vector tableData = new Vector();
		
		for (int i = 0; i < keys.length; i++){
			tableHeaders.add(keys[i]);
		}
		
		for(Object object: celulares){
			Celular celular = (Celular) object;
			Vector<Object> row = new Vector<Object>();
			row.add(celular.getMarca());
			row.add(celular.getModelo());
			row.add(celular.getFabricante());
			row.add(celular.getSerial());
			row.add(celular.getCor());
			tableData.addElement(row);
		}
		
//		for (int i = 0; i < celulares.size(); i++) {
//			Celular celular = celulares.get(i);
//			
//			String[] tempArray = new String[5];
//			tempArray[0] = celular.getMarca();
//			tempArray[1] = celular.getModelo();
//			tempArray[2] = celular.getFabricante();
//			tempArray[3] = Long.toString(celular.getSerial());
//			tempArray[4] = celular.getCor();
//			
//			System.out.println(tempArray);
//			listaArray[i] = tempArray;
//			System.out.println(listaArray);
//		}
		System.out.println(tableData);

		tabelaCelulares = new JTable();
		tabelaCelulares.setColumnSelectionAllowed(true);
		tabelaCelulares.setSurrendersFocusOnKeystroke(true);
		tabelaCelulares.setModel(new DefaultTableModel(tableData, tableHeaders));
		getContentPane().add(tabelaCelulares);
		pack();
	}
	public static void main(String[] args) {
		new JanelaCelularLista(null);
	}

}

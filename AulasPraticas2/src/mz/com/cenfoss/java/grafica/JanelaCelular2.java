package mz.com.cenfoss.java.grafica;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JanelaCelular2 {

	private JFrame frmMinhaJanela;
	private JTextField textMarca;
	private JLabel lblModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCelular2 window = new JanelaCelular2();
					window.frmMinhaJanela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaCelular2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMinhaJanela = new JFrame();
		frmMinhaJanela.setTitle("Minha Janela");
		frmMinhaJanela.setAlwaysOnTop(true);
		frmMinhaJanela.setBounds(100, 100, 450, 300);
		frmMinhaJanela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMinhaJanela.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		JLabel labelMarca = new JLabel("Marca");
		frmMinhaJanela.getContentPane().add(labelMarca);

		textMarca = new JTextField();
		frmMinhaJanela.getContentPane().add(textMarca);
		textMarca.setColumns(10);

		lblModelo = new JLabel("Modelo");
		frmMinhaJanela.getContentPane().add(lblModelo);
		frmMinhaJanela.pack();
	}

}

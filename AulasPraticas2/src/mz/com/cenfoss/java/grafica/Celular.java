package mz.com.cenfoss.java.grafica;

public class Celular {
	private String marca;
	private String modelo;
	private String fabricante;
	private long serial;
	private String cor;

	@Override
	public String toString() {
		return "Celular\nMarca: " + marca + "\nModelo: " + modelo + "\nFabricante: " + fabricante + "\nSerial:" + serial
				+ "Cor:" + cor;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public long getSerial() {
		return serial;
	}

	public String getCor() {
		return cor;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public void setSerial(long serial) {
		this.serial = serial;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}

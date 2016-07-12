package mz.com.cenfoss.java.hibernate2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="computador")
public class Computador {

	private long id;
	private String marca;
	private String modelo;
	private float ram;
	private float screen;
	private String os;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="marca")
	public String getMarca() {
		return marca;
	}
	
	@Column(name="modelo")
	public String getModelo() {
		return modelo;
	}
	
	@Column(name="ram")
	public float getRam() {
		return ram;
	}
	
	@Column(name="screen")
	public float getScreen() {
		return screen;
	}
	
	@Column(name="os")
	public String getOs() {
		return os;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setRam(float ram) {
		this.ram = ram;
	}
	public void setScreen(float screen) {
		this.screen = screen;
	}
	public void setOs(String os) {
		this.os = os;
	}

	@Override
	public String toString() {
		return "Computador [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ram=" + ram + ", screen="
				+ screen + ", os=" + os + "]";
	}
	
	
}

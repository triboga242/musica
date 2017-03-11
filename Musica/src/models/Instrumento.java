package models;

public abstract class Instrumento implements Playable {

	private String marca;
	private String modelo;
	private String color;
	private float precio;
	protected boolean isAfinado;

	public Instrumento(String marca, String modelo, String color, float precio) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
		this.isAfinado = false;
	}

	@Override
	public void tocarInstrumento() {
		System.out.println("Tocando instrumento");
	}

	@Override
	public void afinarInstrumento() {
		System.out.println("Afinando instrumento");
		this.isAfinado = true;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean isAfinado() {
		return isAfinado;
	}

	public void setAfinado(boolean isAfinado) {
		this.isAfinado = isAfinado;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getColor() {
		return color;
	}
}

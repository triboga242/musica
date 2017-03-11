package models;

public class Guitarra extends Instrumento {

	private int numCuerdas;
	private String[] tipo = { "Acustica", "Electrica", "Clasica" };
	private int tipoIndice;
	private String tipo2 = tipo[tipoIndice].toString();

	public Guitarra(String marca, String modelo, String color, float precio, int numCuerdas, int tipoIndice) {
		super(marca, modelo, color, precio);
		this.tipo2 = this.tipo[tipoIndice];
		this.numCuerdas = numCuerdas;
	}

	@Override
	public void afinarInstrumento() {
		this.isAfinado = true;
	}

	@Override
	public void tocarInstrumento() {
		if (isAfinado) {
			System.out.println("Que rifffff de guitarra tan evocador");
		} else {
			System.out.println("Definitivamente necesitas mas clases");
		}
	}

	@Override
	public String toString() {
		return "Guitarra [numCuerdas=" + numCuerdas + ", tipo=" + tipo2 + ", isAfinado=" + isAfinado + ", getPrecio()="
				+ getPrecio() + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo() + ", getColor()="
				+ getColor() + "]";
	}

}

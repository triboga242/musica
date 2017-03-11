package models;

public class Piano extends Instrumento {

	private int numTeclas;

	public Piano(String marca, String modelo, String color, float precio, int numTeclas) {
		super(marca, modelo, color, precio);
		this.numTeclas = numTeclas;
	}

	@Override
	public void afinarInstrumento() {
		this.isAfinado = true;
	}

	@Override
	public void tocarInstrumento() {
		if (isAfinado) {
			System.out.println("Que melodia tan armonica");
		} else {
			System.out.println("Definitivamente necesitas mas clases");
		}
	}

	@Override
	public String toString() {
		return "Piano [numTeclas=" + numTeclas + ", isAfinado=" + isAfinado + ", getPrecio()=" + getPrecio()
				+ ", isAfinado()=" + isAfinado() + ", getMarca()=" + getMarca() + ", getModelo()=" + getModelo()
				+ ", getColor()=" + getColor() + "]";
	}

}

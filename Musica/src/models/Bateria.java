package models;

public class Bateria extends Instrumento {
	private int numTimbales;
	private int numPlatillos;

	public Bateria(String marca, String modelo, String color, float precio, int numTimbales, int numPlatillos) {

		super(marca, modelo, color, precio);

		this.numPlatillos = numPlatillos;
		this.numTimbales = numTimbales;
	}

	@Override
	public void afinarInstrumento() {
		this.isAfinado = true;
	}

	@Override
	public void tocarInstrumento() {
		if (isAfinado) {
			System.out.println("Se nota que llevas el ritmo en la sangre... ¡Sabroson!");
		} else {
			System.out.println("Definitivamente necesitas mas clases");
		}
	}

	@Override
	public String toString() {
		return "Bateria [numTimbales=" + numTimbales + ", numPlatillos=" + numPlatillos + ", isAfinado=" + isAfinado
				+ ", getPrecio()=" + getPrecio() + ", isAfinado()=" + isAfinado() + ", getMarca()=" + getMarca()
				+ ", getModelo()=" + getModelo() + ", getColor()=" + getColor() + "]";
	}

}

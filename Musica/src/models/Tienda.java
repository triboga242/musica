package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

	private ArrayList<Instrumento> listaInstrumentos;
	private ArrayList<Instrumento> historialInstrumentosVendidos;
	private float ventasTotales;
	private String nombre;

	public Tienda(String nombre) {
		this.nombre = nombre;
		this.listaInstrumentos = new ArrayList<Instrumento>();
		this.historialInstrumentosVendidos = new ArrayList<Instrumento>();
	}

	public void Menu1() {
		System.out.println("Bienvenido a esta su tienda [" + this.nombre + "]");
		int opcion;
		do {

			System.out.println();
			System.out.println("******MENU PRINCIPAL******");
			System.out.println("1.Ventas totales");
			System.out.println("2.Añadir instrumentos al stock");
			System.out.println("3.Probar Instrumento");
			System.out.println("4.Vender Instrumento");
			System.out.println("5.Listar todos los instrumentos");
			System.out.println("6.Salir de la tienda");

			opcion = leerInt();
			switch (opcion) {

			case 1:
				System.out.println(getVentasTotales());
				listaHistorialVentas();
				break;
			case 2:
				aniadirInstrumento();
				break;
			case 3:
				probarInstrumento();
				break;
			case 4:
				venderInstrumento();
				break;
			case 5:
				listaInstrumentos();
				break;
			case 6:
				System.out.println("Hasta la próxima, que tenga una músical tarde.");
				break;
			default:
				System.out.println("Opcion no contemplada");
				break;
			}
		} while (opcion != 6);

	}

	private void aniadirInstrumento() {

		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		String marca, modelo, color;
		float precio;
		int opcion = mostrarMenu();

		System.out.println("Marca");
		marca = entrada.nextLine();
		System.out.println("Modelo");
		modelo = entrada.nextLine();
		System.out.println("Color");
		color = entrada.nextLine();
		System.out.println("Precio");
		precio = leerFloat();

		switch (opcion) {
		case 1:
			int numCuerdas, tipoIndice;
			System.out.println("Número de cuerdas");
			numCuerdas = leerInt();
			System.out.println("Tipo");
			tipoIndice = menuTipoGuit();
			Instrumento guitarra = new Guitarra(marca, modelo, color, precio, numCuerdas, tipoIndice);
			insertarInstrumento(guitarra);
			break;
		case 2:
			int numPlatillos, numTimbales;
			System.out.println("Número de platillos");
			numPlatillos = leerInt();
			System.out.println("Número de timbales");
			numTimbales = leerInt();
			Instrumento bateria = new Bateria(marca, modelo, color, precio, numPlatillos, numTimbales);
			insertarInstrumento(bateria);
			break;
		case 3:
			System.out.println("Número de teclas");
			int numTeclas = leerInt();
			Instrumento piano = new Piano(marca, modelo, color, precio, numTeclas);
			insertarInstrumento(piano);
			break;
		default:
			System.out.println("Opcion no contemplada");
			break;

		}
	}

	private void probarInstrumento() {
		boolean existe;
		int orden = 0;
		if (listaInstrumentos.isEmpty()) {
			System.out.println("No disponemos de instrumentos para probar en estos momentos.");
		} else {
			listaInstrumentos();
			System.out.println("Cúal desea llevarse trastear?");
			do {
				orden = leerInt();
				if (orden < listaInstrumentos.size()) {
					System.out.println("Casi consigue darle a un instrumento existente, no desespere");
					existe = false;
				} else {
					System.out.println("Estupenda eleccion");
					existe = true;
				}
			} while (!existe);

			int opcion = menuProbar();
			switch (opcion) {
			case 1:
				listaInstrumentos.get(orden - 1).tocarInstrumento();
				break;
			case 2:
				listaInstrumentos.get(orden - 1).afinarInstrumento();
				break;
			default:
				System.out.println("Opcion no contemplada");
				break;
			}

		}
	}

	private void insertarInstrumento(Instrumento i) {
		if (listaInstrumentos.contains(i)) {
			System.out.println("El instrumento ya se encuentra en stock");
		} else {
			listaInstrumentos.add(i);
		}
	}

	private int mostrarMenu() {

		int opcion;
		do {
			System.out.println("/** SUBMENU - CREAR INSTRUMENTO **/");
			System.out.println("1. Guitarra");
			System.out.println("2. Batería");
			System.out.println("3. Piano");

			System.out.println("¿Qué desea crear?: ");
			opcion = leerInt();

		} while (opcion < 1 || opcion > 3);
		return opcion;
	}

	private int menuTipoGuit() {
		int opcion;
		do {
			System.out.println("/** SUBMENU - CREAR GUITARRA **/");
			System.out.println("1. Eléctrica");
			System.out.println("2. Acústica");
			System.out.println("3. Clásica");

			System.out.println("¿Qué desea crear?: ");
			opcion = leerInt();

		} while (opcion < 1 || opcion > 3);
		return opcion;
	}

	private int menuProbar() {
		int opcion;
		do {
			System.out.println("/** SUBMENU - PROBAR INSTRUMENTO **/");
			System.out.println("1. Tocar");
			System.out.println("2. Afinar");

			System.out.println("¿Qué desea hacer?");
			opcion = leerInt();

		} while (opcion < 1 || opcion > 2);
		return opcion;
	}

	private float venderInstrumento() {
		int orden = 0;
		float precio = 0;
		boolean existe = false;
		if (listaInstrumentos.isEmpty()) {
			System.out.println("No disponemos de instrumentos en Stock en estos momentos.");
		} else {
			listaInstrumentos();
			System.out.println("Cúal desea llevarse puesto?");

			do {
				orden = leerInt();
				if (orden > listaInstrumentos.size()) {
					System.out.println("Casi consigue darle a un instrumento existente, no desespere");
					existe = false;
				} else {
					System.out.println("Estupenda elección");
					existe = true;
				}
			} while (!existe);
			historialInstrumentosVendidos.add(listaInstrumentos.get(orden - 1));
			precio = listaInstrumentos.get(orden - 1).getPrecio();
			this.ventasTotales += precio;
			listaInstrumentos.remove(orden - 1);
		}
		return precio;
	}

	private void listaInstrumentos() {
		int orden = 1;

		for (Instrumento instrumento : listaInstrumentos) {
			System.out.println(orden + "." + instrumento.toString());
			orden++;
		}
	}

	private void listaHistorialVentas() {
		int orden = 1;

		for (Instrumento instrumento : historialInstrumentosVendidos) {
			System.out.println(orden + "." + instrumento.toString());
			orden++;
		}
	}

	public float getVentasTotales() {
		return ventasTotales;
	}

	private int leerInt() {
		boolean esCorrecto = false;
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		String teclado;
		int num = 0;
		do {
			teclado = entrada.nextLine();
			try {
				num = Integer.parseInt(teclado);
				if (num < 0) {
					esCorrecto = false;
					System.out.println("[ERROR] Igual deberías probar con un número positivo");
				}
				esCorrecto = true;
			} catch (Exception e) {
				System.out.println("[ERROR] Igual deberías probar con un número ");
				esCorrecto = false;
			}
		} while (!esCorrecto);
		return num;
	}

	private float leerFloat() {
		boolean esCorrecto = false;
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		String teclado;
		float num = 0;
		do {
			teclado = entrada.nextLine();
			try {
				num = Float.parseFloat(teclado);
				if (num < 0) {
					esCorrecto = false;
					System.out.println("[ERROR] Igual deberías probar con un número positivo");
				}
				esCorrecto = true;
			} catch (Exception e) {
				System.out.println("[ERROR] Igual deberías probar con un número ");
				esCorrecto = false;
			}
		} while (!esCorrecto);
		return num;
	}
}

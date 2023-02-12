import java.util.Arrays;
import java.util.Scanner;

public class menuFinal {

	public static void main(String[] args) {
		int num, posicion;
		int posicionCon = 0;
		String[] datos = new String[3];
		String[] fecha = new String[3];
		String[] valor = new String[3];
		int posicionFil;
		inicializar(datos, fecha, valor, "");

		do {
			menu();
			num = pedirNumMenu();
			switch (num) {
			case 1:
				do {
					posicion = buscarLibre(datos, fecha, valor, "");
					if (posicion != -1) {
						System.out.println("Introduce una pelicula");
						datos[posicion] = pedirString();
						System.out.println("Introduce una Fecha");
						fecha[posicion] = pedirString();
						System.out.println("Introduce una valoracion");
						valor[posicion] = pedirString();
					} else {
						System.out.println("Ha superado el maximo de peliculas para almacenar, elimine algun dato");
					}

				} while (confirmacion("Desea seguir introduciendo una pelicula (s/n)") == 's');
				mostrar(datos, fecha, valor);
				break;
			case 2:
				do {
					posicionFil = buscar(datos, fecha, valor, posicionCon);
					if (posicionFil != datos.length) {
						System.out.println("Introduce el nombre de la nueva pelicula");
						datos[posicionFil] = pedirString();
						System.out.println("Introduce la fecha de la nueva pelicula");
						fecha[posicionFil] = pedirString();
						System.out.println("Introduce la valoracion de la nueva pelicula");
						valor[posicionFil] = pedirString();
					}
				} while (confirmacion("Desea modificar otra pelicuala (s/n)") == 's');
				mostrar(datos, fecha, valor);
				break;
			case 3:
				do {
					posicionFil = buscar(datos, fecha, valor, posicionCon);
					if (posicionFil != datos.length) {
						System.out.println("La pelicula se ha borrado correctamente");
						datos[posicionFil] = "";
						fecha[posicionFil] = "";
						valor[posicionFil] = "";
					}
				} while (confirmacion("Desea borrar otra pelicula (s/n)") == 's');
				mostrar(datos, fecha, valor);

				break;
			case 4:
				buscar(datos, fecha, valor, posicionCon);
				break;
			}
		} while (num != 5);
		System.out.println("Gracias por utilizar el Menu de MiniMestri :D");
	}
	/* MENU */

	private static void menu() {
		System.out.println("-------------------------");
		System.out.println("| 1 |    Anadir		|");
		System.out.println("-------------------------");
		System.out.println("| 2 |	Modificar	|");
		System.out.println("-------------------------");
		System.out.println("| 3 |	 Borrar		|");
		System.out.println("-------------------------");
		System.out.println("| 4 |	Consultar	|");
		System.out.println("-------------------------");
		System.out.println("| 5 |     Salir		|");
		System.out.println("-------------------------");

	}

	/* BUSCAR POSICION LIBRE */

	private static int buscarLibre(String[] lista, String[] lisFe, String[] lisVal, String dato) {
		int posicion = -1;
		int longitud = lista.length;
		boolean encontrado = false;
		int contador = 0;

		while (contador < longitud && !encontrado) {
			if (lista[contador].equals(dato)) {
				encontrado = true;
				posicion = contador;
			}
			contador++;
		}

		return posicion;
	}

	/* BUSCAR */
	private static int buscar(String[] lista, String[] lisFe, String[] lisVal, int contador) {
		int longitud = lista.length;
		boolean encontrado = false;
		String buscar;
		System.out.println("Introduce el nombre de la pelicula");
		buscar = pedirString();
		do {
			if (lista[contador].equals(buscar)) {
				encontrado = true;

			}
			contador++;
		} while (contador < longitud && !encontrado);

		if (encontrado) {
			contador -= 1;
		} else {
			System.out.println("La pelicula no existe");
		}
		return contador;
	}

	/*
	 * 
	 * 
	 */
	public static void mostrar(String[] lista, String[] lisFe, String[] lisVal) {
		int longitud = lista.length;

		for (int i = 0; i < longitud; i++) {
			System.out.println("Pelicula: " + lista[i] + "; Es de la fecha " + lisFe[i] + " y tiene una valoracion de ["
					+ lisVal[i] + "]");

		}
	}

	public static void inicializar(String[] lista, String[] lisFe, String[] lisVal, String dato) {
		int longitud = lista.length;

		for (int i = 0; i < longitud; i++) {
			lista[i] = dato;
			lisFe[i] = dato;
			lisVal[i] = dato;
		}
	}

	/* Pedir numero entero */
	private static int pedirNum() {

		int num;

		Scanner lector = new Scanner(System.in);

		num = lector.nextInt();
		lector.nextLine();

		return num;

	}

	/* Pedir numero menu */
	private static int pedirNumMenu() {

		int num;
		Scanner lector = new Scanner(System.in);

		num = lector.nextInt();
		lector.nextLine();

		while (num < 1 || num > 5) {
			System.out.println("Error vuelva a elegir una opcion");
			num = lector.nextInt();
			lector.nextLine();
		}

		return num;

	}

	/* pedir string */
	private static String pedirString() {

		String dato;
		Scanner lector = new Scanner(System.in);

		dato = lector.nextLine();

		return dato;

	}

	private static char confirmacion(String texto) {
		char letra = 0;
		Scanner lector = new Scanner(System.in);

		System.out.println(texto);
		letra = lector.next().charAt(0);

		while (letra != 's' && letra != 'n') {
			System.out.println("No se reconoce, vuelva a introducir (n o s)");
			letra = lector.next().charAt(0);
		}
		return letra;
	}
}

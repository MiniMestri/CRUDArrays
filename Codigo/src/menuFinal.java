import java.util.Arrays;
import java.util.Scanner;

public class menuFinal {

	public static void main(String[] args) {
		int num, posicion;
		int posicionCon = 0;
		String[] datos = new String[20];
		int posicionFil;
		inicializar(datos, "x");

		do {
			menu();
			num = pedirNumMenu();
			switch (num) {
			case 1:
				posicion = buscarLibre(datos, "x");
				System.out.println("Introduce una pelicula");
				datos[posicion] = pedirString();
				System.out.println(Arrays.toString(datos));

				break;
			case 2:
				posicionFil = buscar(datos, posicionCon);
				System.out.println("Que modificacion le quieres hacer");
				datos[posicionFil - 1] = pedirString();
				System.out.println(Arrays.toString(datos));
				break;
			case 3:
				posicionFil = buscar(datos, posicionCon);
				System.out.println("Desea borrar la pelicula");
				datos[posicionFil - 1] = "x";
				System.out.println(Arrays.toString(datos));

				break;
			case 4:
				buscar(datos, posicionCon);
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

	private static int buscarLibre(String[] lista, String dato) {
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
	private static int buscar(String[] lista, int contador) {
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

		return contador;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public static void inicializar(String[] lista, String dato) {
		int longitud = lista.length;

		for (int i = 0; i < longitud; i++) {
			lista[i] = dato;
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

import java.util.Arrays;
import java.util.Scanner;

public class menuFinal {

	public static void main(String[] args) {
		int num, posicion;
		int posicionCon = 0;
		String[] datos = new String[20];
		String[] fecha = new String[20];
		String[] valor = new String[20];
		int posicionFil;
		inicializar(datos, fecha, valor, "x");

		do {
			menu();
			num = pedirNumMenu();
			switch (num) {
			case 1:
				do {
					posicion = buscarLibre(datos, fecha,valor, "x");
					System.out.println("Introduce una pelicula");
					datos[posicion] = pedirString();
					System.out.println("Introduce una Fecha");
					fecha[posicion] = pedirString();
					System.out.println("Introduce una valoracion");
					valor[posicion]=pedirString();
				} while (confirmacion("Desea seguir introduciendo una pelicula (s/n)") == 's');
				mostrar(datos,fecha,valor);
				break;
			case 2:
				posicionFil = buscar(datos, posicionCon);
				datos[posicionFil - 1] = pedirString();
				System.out.println(Arrays.toString(datos));
				break;
			case 3:
				posicionFil = buscar(datos, posicionCon);
				System.out.println("Desea borrar la pelicula");
				datos[posicionFil - 1] = "x";
				fecha[posicionFil - 1] = "x";
				valor[posicionFil - 1] = "x";
				System.out.println(Arrays.toString(datos));
				System.out.println(Arrays.toString(fecha));
				System.out.println(Arrays.toString(valor));

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

	private static int buscarLibre(String[] lista, String[] lisFe,String[] lisVal, String dato) {
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
	public static void mostrar(String[] lista, String[] lisFe, String[] lisVal) {
		int longitud=lista.length;

		System.out.println("PELICULAS----FECHA----VALORACION");
	
			for(int i=0;i<longitud;i++) {
				System.out.println("Pelicula: " +lista[i]+"; Es del año "+lisFe[i]+" y tiene una valoracion de ["+lisVal[i]+"]");

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

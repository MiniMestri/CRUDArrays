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
						fecha[posicion] = comprobacionFecha("Introduce una fecha");
						valor[posicion] = comprobacionValor("Introduce una valoracion");
					} else {
						System.out.println("Ha superado el maximo de peliculas para almacenar, elimine algun dato");
					}

				} while (confirmacion("Desea seguir creando peliculas (s/n)") == 's');
				mostrar(datos, fecha, valor);
				break;
			case 2:
				do {
					posicionFil = buscar(datos, fecha, valor, posicionCon);
					if (posicionFil != datos.length) {
						System.out.println("Introduce el nombre de una nueva pelicula");
						datos[posicionFil] = pedirString();
						fecha[posicionFil] = comprobacionFecha("Introduce la fecha de la nueva pelicula");
						valor[posicionFil] = comprobacionValor("Introduce la valoracion de la nueva pelicula");
					}
				} while (confirmacion("Desea modificar otra pelicula (s/n)") == 's');
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
	public static String comprobacionValor(String texto) {
		String fecha;
		int longitud;
		String cadena = "1234567890";
		boolean encontrado;

		System.out.println(texto);
		do {
			encontrado = false;
			fecha = pedirString();
			longitud = fecha.length();

			if (cadena.indexOf(fecha.charAt(0)) == -1) {
				encontrado = true;
				System.out.println("El valor introducido no es numerico vuelve a introducirlo");
			} else if (longitud != 1) {
				System.out.println("La longitud no es la correcta vuelva a introducir la fecha");
			}
		} while (encontrado || longitud != 1);
		return fecha;

	}

	public static String comprobacionFecha(String texto) {
		String fecha;
		int longitud;
		String cadena = "1234567890";
		boolean encontrado;

		System.out.println(texto);
		do {
			encontrado = false;
			fecha = pedirString();
			longitud = fecha.length();

			for (int i = 0; i < longitud && !encontrado; i++) {
				if (cadena.indexOf(fecha.charAt(i)) == -1) {
					encontrado = true;
					System.out.println("El valor introducido no es numerico vuelve a introducirlo");
				} else if (longitud != 4) {
					System.out.println("La longitud no es la correcta vuelva a introducir la fecha");
					encontrado = true;
				}
			}
		} while (encontrado || longitud != 4);
		return fecha;
	}

	public static void mostrar(String[] lista, String[] lisFe, String[] lisVal) {
		String vacio = "";
		int i = 0;
		boolean encontrado = false;
		do {
			if (lista[i].equals(vacio)) {
				encontrado = true;
			} else {
				System.out.println(
						"Pelicula: " + lista[i] + "; Fecha " + lisFe[i] + " Valoracion de [" + lisVal[i] + "]");
			}
			i++;
		} while (!encontrado);
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

import java.util.Arrays;
import java.util.Scanner;

public class MENU {

	public static void main(String[] args) {

		String[] contenedorPeli = new String[20];
		int[] contenedorFecha = new int[20];
		int[] contenedorValoracion = new int[20];

		menu();
		switch (pedirNumMenu()) {
		case 1:

			anadirPeli(contenedorPeli, contenedorFecha);
			System.out.println(Arrays.toString(contenedorPeli));
			System.out.println(Arrays.toString(contenedorFecha));
			menu();
			menuSwitch(contenedorPeli,contenedorFecha);
			break;
		case 2:
			System.out.println("Modificar");

			menu();

			break;
		case 3:
			System.out.println("Borrar");

			menu();

			break;
		case 4:

			do {
				buscar(contenedorPeli);
				System.out.println();
			} while (confirmacion("Quieres buscar otra pelicula (si/no)?") == 's');
			menu();
			menuSwitch(contenedorPeli,contenedorFecha);
			break;
		case 5:
			System.out.println("Gracias por utilizar el Menu de MiniMestri :D");
			break;
		}

	}

	/******** MENU PRINT ******/
	private static void menu() {
		System.out.println("1-Anadir");
		System.out.println("2-Modificar");
		System.out.println("3-Borrar");
		System.out.println("4-Consultar");
		System.out.println("5-Salir");

	}

	/********* MENU SWITCH ********/
	private static void menuSwitch(String[] contenedorPeli, int[] contenedorFecha) {

		switch (pedirNumMenu()) {
		case 1:
			anadirPeli(contenedorPeli, contenedorFecha);
			System.out.println(Arrays.toString(contenedorPeli));
			System.out.println(Arrays.toString(contenedorFecha));
			menu();
			menuSwitch(contenedorPeli,contenedorFecha);
			break;
		case 2:
			System.out.println("Modificar");

			menu();

			break;
		case 3:
			System.out.println("Borrar");

			menu();

			break;
		case 4:
			do {
				buscar(contenedorPeli);
				System.out.println();
			} while (confirmacion("Quieres buscar otra pelicula (si/no)?") == 's');
			menu();
			menuSwitch(contenedorPeli,contenedorFecha);
			break;
		case 5:
			System.out.println("Gracias por utilizar el Menu de MiniMestri :D");
			break;
		}
	}

	/********* AÑADIR ********/
	private static void anadirPeli(String[] cadenas, int[] ano) {
		int longitud = 20;
		int contador=0;
		Scanner lector = new Scanner(System.in);
		do {
			System.out.println("Introduce un dato");
			cadenas[contador] = pedirString();
			System.out.println("Introduce un ano");
			ano[contador] = pedirNum();
			
			contador++;
		}while(confirmacion("Quieres buscar otra pelicula (si/no)?")=='s');

	}

	/********** BUSCAR ********/
	private static void buscar(String[] contenedorPeli) {
		int contador = 0;
		int longitud = contenedorPeli.length;
		String buscar;
		boolean encontrado = false;

		System.out.println("Introduce el nombre de una pelicula");
		buscar = pedirString();
		do {
			if (buscar.equals(contenedorPeli[contador])) {
				System.out.println("SI");
				encontrado = true;
			}

			contador++;
		} while (contador < longitud && !encontrado);

	}

	/*********** FIN BUSCAR ********/

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

	private static int pedirNum() {

		int num;
		Scanner lector = new Scanner(System.in);

		num = lector.nextInt();
		lector.nextLine();

		return num;

	}

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

	private static String pedirString() {

		String dato;
		Scanner lector = new Scanner(System.in);

		dato = lector.nextLine();

		return dato;

	}

	private static float pedirFloat(String texto) {
		float num;
		Scanner lector = new Scanner(System.in);

		System.out.println(texto);
		num = lector.nextFloat();
		lector.nextLine();

		while (num < 0 || num > 10) {
			System.out.println("Recuerda valorar la pelicula de (1-10)");
			num = lector.nextFloat();
			lector.nextLine();
		}

		return num;
	}

}

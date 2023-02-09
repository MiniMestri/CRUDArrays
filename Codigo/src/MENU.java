import java.util.Scanner;

public class MENU {

	public static void main(String[] args) {

		menu();
		menuSwitch();

	}

	public static void menu() {
		System.out.println("1-Anadir");
		System.out.println("2-Modificar");
		System.out.println("3-Borrar");
		System.out.println("4-Consultar");
		System.out.println("5-Salir");

	}

	public static void menuSwitch() {

		switch (pedirNum()) {
		case 1:
			System.out.println("Anadir");

			menu();
			menuSwitch();
			break;
		case 2:
			System.out.println("Modificar");

			menu();
			menuSwitch();
			break;
		case 3:
			System.out.println("Borrar");

			menu();
			menuSwitch();
			break;
		case 4:

			do {
				buscar("Que pelicula quieres buscar");
				System.out.println("Quieres buscar otra pelicula (si/no)?");
			} while (confirmacion() == 's');
			menu();
			menuSwitch();
			break;
		case 5:
			System.out.println("Gracias por utilizar el Menu de MiniMestri :D");
			break;
		}
	}

	public static String[] anadir() {
		String[] peliculas = { "avatar", "titanic", "jurasic" };

		return peliculas;

	}

	public static String[] buscar(String texto) {
		String[] pelicula = { "avatar", "titanic", "jurasic" };
		String[] ano = { "2012", "1997", "2001" };
		String peli;
		int contador = 0;
		int longitud = pelicula.length;
		boolean encontrado = false;

		System.out.println(texto);
		peli = pedirString();
		do {
			if (pelicula[contador].equals(peli)) {
				System.out.println(pelicula[contador] + " " + ano[contador]);
				encontrado = true;
			}
			contador++;
		} while (contador < longitud && !encontrado);

		return pelicula;
	}

	public static char confirmacion() {
		char letra = 0;
		Scanner lector = new Scanner(System.in);

		letra = lector.next().charAt(0);

		while (letra != 's' && letra != 'n') {
			System.out.println("No se reconoce, vuelva a introducir (n o s)");
			letra = lector.next().charAt(0);
		}

		return letra;
	}

	public static int pedirNum() {

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

	public static String pedirString() {

		String dato;
		Scanner lector = new Scanner(System.in);

		dato = lector.nextLine();

		return dato;

	}

}

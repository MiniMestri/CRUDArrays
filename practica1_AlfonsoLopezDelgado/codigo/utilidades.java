import java.util.Scanner;

/**
 * La clase utilidades proporcionará métodos repetitivos en el programa
 * principal y de la clase scanner
 * 
 * @author Alfonso Lopez Delgado
 * 
 */
public class utilidades {

	public static void main(String[] args) {

	}

	/**
	 * Introducción de datos por teclado
	 * 
	 * @return String
	 */
	public static String pedirString() {

		String dato;
		Scanner lector = new Scanner(System.in);

		dato = lector.nextLine();

		return dato;

	}

	/**
	 * Sentencia repetitiva para evitar volver al menú principal donde solo deja la
	 * introducción por teclado de dos valores
	 * 
	 * @return char s o n
	 * @param texto Lanza un texto por pantalla
	 */

	public static char confirmacion(String texto) {
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

	/**
	 * Introducción mediante teclado de un número para el menú. Comprobación de
	 * dicho número este dentro de los parametros indicados.
	 * 
	 * @return int
	 * 
	 */
	public static int pedirNumMenu() {

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
}

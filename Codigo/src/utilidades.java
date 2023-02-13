import java.util.Scanner;

public class utilidades {

	public static void main(String[] args) {

	}

	public static String pedirString() {

		String dato;
		Scanner lector = new Scanner(System.in);

		dato = lector.nextLine();
		
		return dato;
		
	}

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

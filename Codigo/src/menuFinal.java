public class menuFinal {

	public static void main(String[] args) {
		int num, posicionLibre;
		int posicionContador = 0;
		String[] datos = new String[20];
		String[] fecha = new String[20];
		String[] valoracion = new String[20];
		int posicionComodin;
		inicializar(datos, fecha, valoracion, "");

		do {
			menu();
			num = utilidades.pedirNumMenu();
			switch (num) {
			case 1:
				do {
					posicionLibre = buscarLibre(datos, fecha, valoracion, "");
					if (posicionLibre != -1) {
						System.out.println("Introduce una pelicula");
						datos[posicionLibre] = utilidades.pedirString();
						fecha[posicionLibre] = comprobacionFecha("Introduce una fecha");
						valoracion[posicionLibre] = comprobacionValoracion("Introduce una valoracion");
					} else {
						System.out.println("Ha superado el maximo de peliculas para almacenar, elimine algun dato");
					}

				} while (utilidades.confirmacion("Desea seguir creando peliculas (s/n)") == 's');
				mostrar(datos, fecha, valoracion);
				break;
			case 2:
				do {
					posicionComodin = buscar(datos, fecha, valoracion, posicionContador);
					if (posicionComodin != datos.length) {
						System.out.println("Introduce el nombre de una nueva pelicula");
						datos[posicionComodin] = utilidades.pedirString();
						fecha[posicionComodin] = comprobacionFecha("Introduce la fecha de la nueva pelicula");
						valoracion[posicionComodin] = comprobacionValoracion(
								"Introduce la valoracion de la nueva pelicula");
					}
				} while (utilidades.confirmacion("Desea modificar otra pelicula (s/n)") == 's');
				mostrar(datos, fecha, valoracion);
				break;
			case 3:
				do {
					posicionComodin = buscar(datos, fecha, valoracion, posicionContador);
					if (posicionComodin != datos.length) {
						System.out.println("La pelicula se ha borrado correctamente");
						datos[posicionComodin] = "";
						fecha[posicionComodin] = "";
						valoracion[posicionComodin] = "";
					}
				} while (utilidades.confirmacion("Desea borrar otra pelicula (s/n)") == 's');

				break;
			case 4:
				if (utilidades.confirmacion("Quiere mostrar todo (s) o buscar solo una pelicula (n)") == 's') {
					mostrar(datos, fecha, valoracion);
				} else {
					do {
						posicionComodin = buscar(datos, fecha, valoracion, posicionContador);
						System.out.println("La pelicula " + datos[posicionComodin] + " se estreno en el ano "
								+ fecha[posicionComodin] + ". Tiene una valoracion de (" + valoracion[posicionComodin]
								+ "/10)");
					} while (utilidades.confirmacion("Quiere buscar otra pelicula (s/n)") == 's');
				}
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
		buscar = utilidades.pedirString();
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

	private static String comprobacionValoracion(String texto) {
		String fecha;
		int longitud;
		String cadena = "1234567890";
		boolean encontrado;

		System.out.println(texto);
		do {
			encontrado = false;
			fecha = utilidades.pedirString();
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

	private static String comprobacionFecha(String texto) {
		String fecha;
		int longitud;
		String cadena = "1234567890";
		boolean encontrado;

		System.out.println(texto);
		do {
			encontrado = false;
			fecha = utilidades.pedirString();
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

	private static void mostrar(String[] lista, String[] lisFe, String[] lisVal) {
		String vacio = "";
		int i = 0;
		boolean encontrado = false;
		do {
			if (lista[i].equals(vacio)) {
				encontrado = true;
			} else {
				System.out.println(
						"Pelicula: " + lista[i] + "; Fecha (" + lisFe[i] + ") Valoracion de [" + lisVal[i] + "]");
			}
			i++;
		} while (!encontrado);
	}



	private static void inicializar(String[] lista, String[] lisFe, String[] lisVal, String dato) {
		int longitud = lista.length;

		for (int i = 0; i < longitud; i++) {
			lista[i] = dato;
			lisFe[i] = dato;
			lisVal[i] = dato;
		}
	}

}

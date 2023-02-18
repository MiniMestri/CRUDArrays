/**
 * Programa CRUD donde mediante interacción por teclado se navegará por las
 * distintas opciones del menú con el tema peliculas
 * 
 * 
 * @author Alfonso Lopez Delgado
 */
public class menuFinal {

	public static void main(String[] args) {
		int num, posicionComodin;
		String[] datos = new String[20];
		String[] fecha = new String[20];
		String[] valoracion = new String[20];

		inicializar(datos, fecha, valoracion, "");
		do {
			menu();
			num = utilidades.pedirNumMenu();
			switch (num) {
			case 1:
				do {
					posicionComodin = buscarLibre(datos, fecha, valoracion, "");
					if (posicionComodin != -1) {
						System.out.println("Introduce una pelicula");
						datos[posicionComodin] = utilidades.pedirString();
						fecha[posicionComodin] = comprobacionFecha("Introduce una fecha");
						valoracion[posicionComodin] = comprobacionValoracion("Introduce una valoracion");
					} else {
						System.out.println("Ha superado el maximo de peliculas para almacenar, elimine algun dato");
					}

				} while (utilidades.confirmacion("Desea seguir creando peliculas (s/n)") == 's');
				break;
			case 2:
				do {
					posicionComodin = buscar(datos, fecha, valoracion);
					if (posicionComodin != datos.length) {
						System.out.println("Introduce el nombre de una nueva pelicula");
						datos[posicionComodin] = utilidades.pedirString();
						fecha[posicionComodin] = comprobacionFecha("Introduce la fecha de la nueva pelicula");
						valoracion[posicionComodin] = comprobacionValoracion(
								"Introduce la valoracion de la nueva pelicula");
					}
				} while (utilidades.confirmacion("Desea modificar otra pelicula (s/n)") == 's');

				break;
			case 3:
				do {
					posicionComodin = buscar(datos, fecha, valoracion);
					if (posicionComodin != datos.length) {
						System.out.println("La pelicula se ha borrado correctamente");
						datos[posicionComodin] = "";
						fecha[posicionComodin] = "";
						valoracion[posicionComodin] = "";
					}
				} while (utilidades.confirmacion("Desea borrar otra pelicula (s/n)") == 's');

				break;
			case 4:
				do {
					if (utilidades.confirmacion("Quiere mostrar todo (s) o buscar solo una pelicula (n)") == 's') {
						mostrar(datos, fecha, valoracion);
					} else {
						posicionComodin = buscar(datos, fecha, valoracion);
						if (posicionComodin != datos.length) {
							System.out.println("La pelicula " + datos[posicionComodin] + " se estreno en el ano "
									+ fecha[posicionComodin] + ". Tiene una valoracion de ("
									+ valoracion[posicionComodin] + "/9)");
						}
					}
				} while (utilidades.confirmacion("Desea hacer otra consulta (s/n)") == 's');
				break;
			default:
				System.out.println("Gracias por utilizar el Menu de MiniMestri :D");
			}
		} while (num != 5);
	}

	/**
	 * Estética menú
	 */

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

	/**
	 * Método para calcular la próxima posición del array sin datos guardados
	 * 
	 * 
	 * @param lista  Array lista para alamacenar peliculas
	 * @param lisFe  Array lista para alamacenar fecha
	 * @param lisVal Array lista para alamacenar la valoración
	 * @param dato   String de inicializacion
	 * 
	 * @return int posición
	 */
	public static int buscarLibre(String[] lista, String[] lisFe, String[] lisVal, String dato) {
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

	/**
	 * Método para buscar una película que coincida con alguna del Array lista
	 * previamente introducido, con el dato introducido por teclado.
	 * 
	 * 
	 * @param lista  Array lista para alamacenar peliculas.
	 * @param lisFe  Array lista para alamacenar fecha.
	 * @param lisVal Array lista para alamacenar la valoración.
	 * 
	 * @return int Posición de la película buscada
	 */
	public static int buscar(String[] lista, String[] lisFe, String[] lisVal) {
		int longitud = lista.length;
		int contador = 0;
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

	/**
	 * Método de introducción por teclado de una valoracion tipo String y posterior
	 * validación, controlando la simbología y la longitud.
	 * 
	 * @param texto Lanza un texto por pantalla.
	 * 
	 * @return String Fecha de la película en Sring.
	 */
	public static String comprobacionValoracion(String texto) {
		String valoracion;
		int longitud;
		String cadena = "1234567890";
		boolean encontrado;

		System.out.println(texto);
		do {
			encontrado = false;
			valoracion = utilidades.pedirString();
			longitud = valoracion.length();

			if (cadena.indexOf(valoracion.charAt(0)) == -1) {
				encontrado = true;
				System.out.println("El valor introducido no es numerico vuelve a introducirlo");
			} else if (longitud != 1) {
				System.out.println("La longitud no es la correcta vuelva a introducir la fecha");
			}
		} while (encontrado || longitud != 1);
		return valoracion;

	}

	/**
	 * Método de introducción por teclado de una fecha tipo String y posterior
	 * validación, controlando la simbología y la longitud.
	 * 
	 * @param texto Lanza un texto por pantalla.
	 * 
	 * @return String Fecha de la película en Sring.
	 */
	public static String comprobacionFecha(String texto) {
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

	/**
	 * Método para mostrar los datos, previamente introducidos mediante otros
	 * métodos, y sacarlos por pantalla.
	 * 
	 * 
	 * @param lista  Array lista para alamacenar peliculas.
	 * @param lisFe  Array lista para alamacenar fecha.
	 * @param lisVal Array lista para alamacenar la valoración.
	 * 
	 */
	public static void mostrar(String[] lista, String[] lisFe, String[] lisVal) {
		int longitud = lista.length;

		for (int i = 0; i < longitud; i++) {
			System.out
					.println("Pelicula: " + lista[i] + "; Fecha (" + lisFe[i] + ") Valoracion de [" + lisVal[i] + "]");
		}
	}

	/**
	 * Método que inicializa lista, lisFe, lisVal con lo introducido en el
	 * paramatetro dato
	 * 
	 * 
	 * @param lista  Array lista para alamacenar peliculas.
	 * @param lisFe  Array lista para alamacenar fecha.
	 * @param lisVal Array lista para alamacenar la valoración.
	 * @param dato   String de inicialización
	 * 
	 */

	public static void inicializar(String[] lista, String[] lisFe, String[] lisVal, String dato) {
		int longitud = lista.length;

		for (int i = 0; i < longitud; i++) {
			lista[i] = dato;
			lisFe[i] = dato;
			lisVal[i] = dato;
		}
	}

}

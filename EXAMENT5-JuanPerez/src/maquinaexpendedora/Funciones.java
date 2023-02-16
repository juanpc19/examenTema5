package maquinaexpendedora;

import java.util.Arrays;

public class Funciones {

	// creo atributo nombresGolosinas e inicializo sus posiciones con valores
	// introducidos manualmente
	// guardara los nomobres de las golosinas
	static String[][] nombresGolosinas = { { "KitKat", "Chicles de fresa", "Lacasitos", "Palotes" },
			{ "Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix" },
			{ "Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta" },
			{ "Lacasitos", "Crunch", "Milkybar", "KitKat" } };

	// creo atributo precio e inicializo sus posiciones con valores introducidos
	// manualmente
	// guardara los precios de las golosinas
	static double[][] precio = { { 1.1, 0.8, 1.5, 0.9 }, { 1.8, 1, 1.2, 1 }, { 1.8, 1.3, 1.2, 0.8 },
			{ 1.5, 1.1, 1.1, 1.1 } };

	// creo atributo cantidadGolosinas e inicializo sus posiciones con valores
	// introducidos manualmente
	// guardara las cantidades existentes de golosinas en la maquina
	static int[][] cantidadGolosinas = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	// creo atributo ventas y le doy longitud 0
	// guardara los nombres de las golosinas compradas
	static String ventas[] = new String[0];

	// creo atributo total y lo inicializo a 0
	// guardara el costo total de todos los productos comprados
	static int total = 0;

	/**
	 * funcion estatica que llenara las posiciones del array cantidadGolosinas con
	 * el valor de num
	 * 
	 * @param num parametro de entrada usado para dar valor a posiciones de
	 *            cantidadGolosinas
	 */
	static void rellenarMatriz(int num) {
		// recorro fila
		for (int i = 0; i < cantidadGolosinas[0].length; i++) {
			// recorro columna
			for (int j = 0; j < cantidadGolosinas.length; j++) {
				// sumo a posicion fila columna de array cantidadGolosinas valor de num
				cantidadGolosinas[i][j] += num;
			}
		}
	}

	/**
	 * funcion estatica que mostrara al usuario el codigo, nombre y precio de
	 * golosina seleccionada
	 */
	static void mostrarGolosinas() {
		// recorro fila
		for (int i = 0; i < nombresGolosinas[0].length; i++) {
			// recorro columna
			for (int j = 0; j < nombresGolosinas.length; j++) {
				// muestro a usuario codigo de golosina
				System.out.print(i + "" + j + " ");
				// muestro a usuario nombre de golosina
				System.out.print(nombresGolosinas[i][j] + " ");
				// muestro a usuario precio de golosina
				System.out.print(precio[i][j]);
				// print para crear espacio
				System.out.println();
				System.out.println();
			}
		}

	}

	/**
	 * funcion estatica que combrobara que el codigo introducido por el usuario
	 * corresponde al de una golosina
	 * 
	 * @param fila    parametro de entrada que dara valor a la fila del array
	 * @param columna parametro de entrada que dara valor a la columna del array
	 * @return resultado guardara true si el codigo de la golosina se encuentra en
	 *         el array y falseen caso contrario
	 */
	static boolean validarPos(int fila, int columna) {
		boolean resultado = false;// declaro e inicializo variable a false
		// compruebo si tanto fila como columna corresponden a posiciones validas
		if (fila >= 0 && fila < nombresGolosinas.length && columna >= 0 && columna < nombresGolosinas.length) {
			// si lo hacen resultado toma valor igual true
			resultado = true;
		}
		// devuelvo resultado
		return resultado;
	}

	/**
	 * funcion estatica que comprobara si quedan existencias de la golosina
	 * solicitada
	 * 
	 * @param fila    parametro de entrada que dara valor a la fila del array
	 * @param columna parametro de entrada que dara valor a la columna del array
	 * @return resultado guardara true si hay existencias de la golosina y false en
	 *         caso contrario
	 */
	static boolean hayValorPosicion(int fila, int columna) {
		boolean resultado = false;// declaro e inicializo variable a false
		// compruebo si el valor del elemento en la posicion fila columna del array
		// cantidadGolosinas es mayor a 0
		if (cantidadGolosinas[fila][columna] > 0) {
			// de serlo reultado toma valor igual a true
			resultado = true;
		}
		// devuelvo resultado
		return resultado;
	}

	/**
	 * funcion estatica que añadira la golosina seleccionada a array ventas creando
	 * previamente una nueva posicion para ella y ademas sumara el precio de dicha
	 * golosina a total
	 * 
	 * @param fila    parametro de entrada que dara valor a la fila del array
	 * @param columna parametro de entrada que dara valor a la columna del array
	 */
	static void anyadirVenta(int fila, int columna) {
		// añado posicion a array ventas
		Funciones.ventas = Arrays.copyOf(Funciones.ventas, Funciones.ventas.length + 1);
		// relleno esta ultima posicion con valor contenido en array nombresGolosinas en
		// posicion [fila][columna]
		Funciones.ventas[Funciones.ventas.length - 1] = Funciones.nombresGolosinas[fila][columna];

		// sumo a total valor contenido en array precio en posicion [fila][columna]
		total += precio[fila][columna];
	}

	/**
	 * funcion estatica que decrementara el valor del elemento contenido en la
	 * posicion indicada usando cantidad
	 * 
	 * @param fila     parametro de entrada que dara valor a la fila del array
	 * @param columna  parametro de entrada que dara valor a la columna del array
	 * @param cantidad contiene valor usado para incrementar contenido de posicion
	 *                 indicada
	 */
	static void aumentarPosicion(int fila, int columna, int cantidad) {
		// resto cantidad al valor contenido en array cantidadGolosinas posicion
		// [fila][columna]
		cantidadGolosinas[fila][columna] = cantidadGolosinas[fila][columna] - cantidad;
	}

	/**
	 * funcion estatica que aumentara el valor del elemento contenido en la posicion
	 * indicada usando cantidad
	 * 
	 * @param fila     parametro de entrada que dara valor a la fila del array
	 * @param columna  parametro de entrada que dara valor a la columna del array
	 * @param cantidad cantidad contiene valor usado para decrementar contenido de
	 *                 posicion indicada
	 */
	static void reducirPosicion(int fila, int columna, int cantidad) {
		// sumo cantidad al valor contenido en array cantidadGolosinas posicion
		// [fila][columna]
		cantidadGolosinas[fila][columna] = cantidadGolosinas[fila][columna] + cantidad;
	}

	/**
	 * funcion estatica que mostrara al usuario las lista de productos comprados y
	 * el valor total de los mismos
	 */
	static void imprimirVentasTotales() {
		// muestro al usuario los valores guardados en las posiciones del array ventas
		System.out.println(Arrays.toString(ventas));
		// muestro al usuario el valor de total
		System.out.println("Coste total " + total);

	}

}

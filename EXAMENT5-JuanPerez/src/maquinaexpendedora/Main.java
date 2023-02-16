package maquinaexpendedora;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int opcionUsuario = 0;// guardara la opcion seleccionada por el usuario y la inicializo a 0

		int filaUsuario = 0;// guardara la fila seleccionada por el usuario y la inicializo a 0

		int columnaUsuario = 0;// guardara la columna seleccionada por el usuario y la inicializo a 0

		String contraseña = "";// guardara la contraseña introducida por el tecnico

		// creo escaner y lo nombro dogma
		Scanner dogma = new Scanner(System.in);

		// llamo a funcion rellenarMatriz con parametro de entrada igual a 5
		Funciones.rellenarMatriz(5);

		// bucle que se ejecutara mientras opcionUsuario diferente a 4
		while (opcionUsuario != 4) {

			// muestro al usuario las opciones de la maquina
			System.out.println("1. Mostrar golosinas. ");

			System.out.println("2. Pedir golosinas. ");

			System.out.println("3. Rellenar golosinas. ");

			System.out.println("4. Apagar maquina. ");

			// recojo opcionUsuario con escaner
			opcionUsuario = dogma.nextInt();

			// si la opcionUsuario no corresponde a opcines de la maquina se lo indico con
			// un mensaje
			if (opcionUsuario < 1 || opcionUsuario > 4) {
				System.out.println("Asegurese de seleccionar una opcion valida.");
			}

			// hago switch que evaluara opcionUsuario
			switch (opcionUsuario) {

			// en caso de opcionUsuario ser igual a 1
			case 1 -> {
				// llamo a funcion mostrarGolosinas
				Funciones.mostrarGolosinas();
			}
			// en caso de opcionUsuario ser igual a 2
			case 2 -> {
				// le solicito un valor para filaUsuario
				System.out.println("Introduzca la fila del producto deseado");
				// y se lo asigno con escaner
				filaUsuario = dogma.nextInt();

				// le solicito un valor para columnaUsuario
				System.out.println("Introduzca la columna del producto deseado");
				// y se lo asigno con escaner
				columnaUsuario = dogma.nextInt();

				// llamo a funcion validarPos con los datos introducidos por usuario y compruebo
				// que me devuelve true
				if (Funciones.validarPos(filaUsuario, columnaUsuario) == true) {

					// si me devuelve true compruebo la siguiente condicion

					// llamo a funcion hayValorPosicion con los datos introducidos por usuario y
					// compruebo
					// que me devuelve true
					if (Funciones.hayValorPosicion(filaUsuario, columnaUsuario) == true) {

						// si me devuelve true llamo a funcion anyadirVenta con los datos introducidos
						// por usuario
						Funciones.anyadirVenta(filaUsuario, columnaUsuario);

						// y llamo a funcion reducirPosicion con los datos introducidos por usuario
						Funciones.reducirPosicion(filaUsuario, columnaUsuario, 1);

						// de no devolverme true le comunico a usuario el error con mensaje
					} else {
						System.out.println("Ha indicado un producto agotado, seleccione otro producto.");
					}

					// de no devolverme true le comunico a usuario el error con mensaje
				} else {
					System.out.println("Ha indicado un producto no existente, introduzca otro codigo.");
				}
			}
			// en caso de opcionUsuario ser igual a 3
			case 3 -> {
				// solicito a tecnico su contraseña
				System.out.println("Identificate con tu contraseña de tecnico:");
				// asigno el valor a contraseña mediante escaner
				contraseña = dogma.next();

				// si contraseña es igual a la estipulada
				if (contraseña.equals("Maquina2023")) {
					// le solicito valor para fila
					System.out.println("Introduzca la fila del producto deseado");
					// asigno el valor a filaUsuario mediante escaner
					filaUsuario = dogma.nextInt();

					// le solicito valor para columna
					System.out.println("Introduzca la columna del producto deseado");
					// asigno el valor a columnaUsuario mediante escaner
					columnaUsuario = dogma.nextInt();

					// y llamo a funcion aumentarPosicion con valores intruoducidos por usuario
					Funciones.aumentarPosicion(columnaUsuario, filaUsuario, 1);

					// de ser contraseña erronea lo comunico con mensaje
				} else {
					System.out.println("Contraseña erronea, seleccione opcion 3 si quiere probar de nuevo.");
				}
			}
			// en caso de opcionUsuario ser igual a 4
			case 4 -> {
				// llamo a funcion imprimirVentasTotales
				Funciones.imprimirVentasTotales();
			}
			}
		}

		// cierro escaner
		dogma.close();
	}

}

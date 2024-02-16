package fecha;

/***
 * Clase fecha donde se realizara funciones
 */
public class Fecha {
	/***
	 * Numero entero privado
	 */
	private int d; 
	public static final int DIEZ = 10;
	private int dia; //d�a
	private int mes; //mes
	private int año; //a�o

	/***
	 * Numero entero privado
	 */
	private int m; 
	
	/***
	 * Numero entero privado
	 */
	private int a; 

	/***
	 * Constructor sin parametros
	 */
	public Fecha() {

	}

	/***
	 * Constructor con parametros
	 * 
	 * @param dia  Numero entero que contiene un dia
	 * @param mes  Numero entero que contiene un mes
	 * @param anio Numero entero que contiene un año
	 */
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.año = anio;
	}

	/***
	 * Funcion que corrige las variables si los numeros son mayores que 30,21,29 o
	 * si son bisiestos
	 * 
	 * @return Numero entero con la variable corregida
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto;
		boolean anioCorrecto;
		anioCorrecto = año > 0;
		mesCorrecto = mes >= 1 && mes <= 12;
		boolean diaMayor1 = dia >= 1;
		switch (mes) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && dia <= 29;
			} else {
				diaCorrecto = diaMayor1 && dia <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && dia <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && dia <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}


	/***
	 * Funcion que realiza una operacion si año es bisiesto
	 * 
	 * @return True o false (Boolean)
	 */

	private boolean esBisiesto() {
		return año % 4 == 0 && año % 100 != 0 || año % 400 == 0;
	}


	/***
	 * Funcion que aumenta el mes y el año si el dia o el mes es distinto que el
	 * resultado fecha correcta
	 */
	public void diaSiguiente() {
		d++;
	}

	public void nextDay() {
		dia++;

		if (!fechaCorrecta()) {
			dia = 1;
			mes++;
			if (!fechaCorrecta()) {
				mes = 1;
				año++;
			}
		}
	}

	/***
	 * Funcion que imprime la fecha
	 */

	// M�todo toString
	public String toString() {
		String fecha="";
		if (dia < DIEZ && mes < DIEZ) {
			fecha= "0" + dia + "-0" + mes + "-" + año;
		} else if (dia < DIEZ && mes >= DIEZ) {
			fecha= "0" + dia + "-" + mes + "-" + año;
		} else if (dia >= DIEZ && mes < DIEZ) {
			fecha= dia + "-0" + mes + "-" + año;
		} else {
			fecha= dia + "-" + mes + "-" + año;
		}
		return fecha;
	}

}

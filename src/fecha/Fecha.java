package fecha;

/***
 * Clase fecha donde se realizara funciones
 */
public class Fecha {
	/***
	 * Numero entero privado
	 */
	private int d; 
	
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
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	/***
	 * Funcion que corrige las variables si los numeros son mayores que 30,21,29 o
	 * si son bisiestos
	 * 
	 * @return Numero entero con la variable corregida
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	/***
	 * Funcion que realiza una operacion si año es bisiesto
	 * 
	 * @return True o false (Boolean)
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	/***
	 * Funcion que aumenta el mes y el año si el dia o el mes es distinto que el
	 * resultado fecha correcta
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	/***
	 * Funcion que imprime la fecha
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}

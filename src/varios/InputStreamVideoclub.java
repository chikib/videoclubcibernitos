package varios;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamVideoclub {

	public static String cadena;
	public static void pedirCadena(){
		try {
			// Obtención del objeto Reader
			InputStreamReader conv = new InputStreamReader (System.in);
			// Obtención del BufferedReader
			BufferedReader entrada = new BufferedReader (conv);
			System.out.println("========> Introduzca una opción: ");
			cadena = entrada.readLine();
		}catch (IOException e)	{
			System.out.println ("Error");
		}
	}
	
	public static void pedirCadena(String mensaje){
		try {
			// Obtención del objeto Reader
			InputStreamReader conv = new InputStreamReader (System.in);
			// Obtención del BufferedReader
			BufferedReader entrada = new BufferedReader (conv);
			System.out.println(mensaje);
			cadena = entrada.readLine();
		}catch (IOException e)	{
			System.out.println ("Error");
		}
	}
}

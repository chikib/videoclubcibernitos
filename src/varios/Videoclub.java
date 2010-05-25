package varios;
import java.util.ArrayList;
import java.util.List;

import articulos.Articulo;
import articulos.ArticuloAlquilado;


public class Videoclub {
	
	public static List<Articulo> listaPeliculas = new ArrayList();
	public static List<ArticuloAlquilado> listaPeliculasAlquiladas = new ArrayList();
	/*List<Soporte> listaSoportes = new ArrayList();
	List<Categoria> listaCategorias = new ArrayList();
	List<Usuario> listaUsuarios = new ArrayList();
	*/
	
	public static void main (String[] args){
		mostrarMenuPrincipal();
	}
	
	//Método estático que muestra el menú principal
	public static void mostrarMenuPrincipal(){
		boolean fin = false;
		String cadena = "";
		
		do{
			System.out.println("(1) Alquilar");
			System.out.println("(2) Devolver");
			System.out.println("(3) Gestión de usuarios");
			System.out.println("(4) Gestión de películas");
			System.out.println("(5) Consultas");
			System.out.println("(6) Facturación");
			System.out.println("(7) Salir");
			InputStreamVideoclub.pedirCadena();
			cadena = InputStreamVideoclub.cadena;
			try{
				switch(Integer.parseInt(cadena)){
				case 1: alquilar();break;
				case 2: devolver();break;
				case 3: mostrarMenuUsuarios();break;
				case 4: ;break;
				case 5: ;break;
				case 6: ;break;
				case 7: fin = true; break;
				default: System.out.println("Elija una opción válida");
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opción válida");
			}
		}while(!fin);
	}
	
	public static void mostrarMenuUsuarios(){
		boolean fin = false;
		String cadena = "";
		
		do{
			System.out.println("(1) Alta de usuario");
			System.out.println("(2) Modificación datos");
			System.out.println("(3) Activar usuario");
			System.out.println("(4) Desactivar usuario");
			System.out.println("(5) Volver");
			InputStreamVideoclub.pedirCadena();
			cadena = InputStreamVideoclub.cadena;
			try{
				switch(Integer.parseInt(cadena)){
				case 1: ;break;
				case 2: ;break;
				case 3: ;break;
				case 4: ;break;
				case 5: mostrarMenuPrincipal();fin = true; break;
				default: System.out.println("Elija una opción válida");
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opción válida");
			}
		}while(!fin);
	}
	
	public static void alquilar(){
		//Identifico al usuario
		identificarUsuario();
		//Identifico la película
		identificarPelicula();
	}
	
	public static void identificarUsuario(){
		InputStreamVideoclub.pedirCadena("Introduzca el número de socio del cliente: ");
		String cadena = InputStreamVideoclub.cadena;
		int numeroSocio;
		try{
			numeroSocio = Integer.parseInt(cadena);
			
		}
		catch(NumberFormatException e){
			System.out.println("El dato introducido no es válido");
			identificarUsuario();
		}
	}
	
	public static void identificarPelicula(){
		
	}
	
	public static void devolver(){
		
	}
}

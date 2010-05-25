package varios;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import usuario.Usuario;

import articulos.Articulo;
import articulos.ArticuloAlquilado;
import articulos.Categoria;
import articulos.Proveedor;
import articulos.Soporte;


public class Videoclub {
	
	
	public static List<Usuario> listaUsuarios = new ArrayList();
	/*List<Soporte> listaSoportes = new ArrayList();
	List<Categoria> listaCategorias = new ArrayList();
	
	*/
	
	public static void main (String[] args){
		mostrarMenuPrincipal();
	}
	
	//Método estático que muestra el menú principal
	public static void mostrarMenuPrincipal(){
		Articulo.listaPeliculas.add(new Articulo(1, 12345, "Avatar", "La película Avatar...", new Categoria(), new Soporte(), 
				new Proveedor(1, "Proveedor", "X98765431", "954678987", "calle real", "", ""), 2, false, new Date(), 60, false, "A34", true));
		listaUsuarios.add(new Usuario(1, "Azucena", "BV", "28888888D", "calle rioja", "955676767", true, true));
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
				case 1: ArticuloAlquilado.alquilar();break;
				case 2: ArticuloAlquilado.devolver();break;
				case 3: mostrarMenuUsuarios();break;
				case 4: mostrarMenuPeliculas();break;
				case 5: ;break;
				case 6: ;break;
				case 7: fin = true; System.out.println("\n*** Fin de programa ***"); break;
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
	
	public static void mostrarMenuPeliculas(){
		boolean fin = false;
		String cadena = "";
		
		do{
			System.out.println("(1) Alta de películas");
			System.out.println("(2) Modificación  de películas");
			System.out.println("(3) Desactivar películas");
			System.out.println("(4) Volver");
			InputStreamVideoclub.pedirCadena();
			cadena = InputStreamVideoclub.cadena;
			try{
				switch(Integer.parseInt(cadena)){
				case 1: menuAltaPelicula();break;
				case 2: ;break;
				case 3: ;break;
				case 4: mostrarMenuPrincipal();fin = true; break;
				default: System.out.println("Elija una opción válida");
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opción válida");
			}
		}while(!fin);
	}
	
	public static void menuAltaPelicula(){
		
	}
}

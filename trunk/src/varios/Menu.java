package varios;

import java.util.List;

import usuario.Usuario;
import articulos.Articulo;
import articulos.ArticuloAlquilado;

public class Menu {
	//M�todo que muestra el men� principal
	public void mostrarMenuPrincipal(){
		boolean fin = false;
		String cadena = "";
		
		do{
			System.out.println("(1) Alquilar");
			System.out.println("(2) Devolver");
			System.out.println("(3) Gesti�n de usuarios");
			System.out.println("(4) Gesti�n de pel�culas");
			System.out.println("(5) Consultas");
			System.out.println("(6) Facturaci�n");
			System.out.println("(7) Salir");
			InputStreamVideoclub.pedirCadena();
			cadena = InputStreamVideoclub.cadena;
			String mensaje = "";
			try{
				switch(Integer.parseInt(cadena)){
				case 1:{
					InputStreamVideoclub.pedirCadena("Indique la cantidad de pel�culas que desee alquilar");
					List<String> listaMensajes = ArticuloAlquilado.alquilar(Integer.parseInt(InputStreamVideoclub.cadena));
					if(listaMensajes.size()>0){
						for(String mensajeDev: listaMensajes){
							mensaje +=mensajeDev+"\n";
						}
						throw new VideoException(mensaje); 
					}
					break;
				}
				case 2: {
					InputStreamVideoclub.pedirCadena("Indique la cantidad de pel�culas que desee devolver");
					List<String> listaMensajes = ArticuloAlquilado.gestionDevolver(Integer.parseInt(InputStreamVideoclub.cadena));
					if(listaMensajes.size()>0){
						for(String mensajeDev: listaMensajes){
							mensaje +=mensajeDev+"\n";
						}
						throw new VideoException(mensaje); 
					}
					break;
				}
				case 3: mostrarMenuUsuarios();break;
				case 4: mostrarMenuPeliculas();break;
				case 5: mostrarMenuConsultas();break;
				case 6: mostrarMenuFacturacion();break;
				case 7: {
					fin = true; 
					System.out.println("\n*** Fin de programa ***"); 
					break;
				}default: {
					System.out.println("Elija una opci�n v�lida");
					}
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opci�n v�lida");
			}catch(VideoException e){
				System.out.println("La lista de errores es:\n"+e.getMessage());
			}
		}while(!fin);
	}
	
	public void mostrarMenuUsuarios(){
		boolean fin = false;
		String cadena = "";
		String mensaje = "";
		
		do{
			System.out.println("(1) Alta de usuario");
			System.out.println("(2) Modificaci�n datos");
			System.out.println("(3) Consultar datos de un usuario");
			System.out.println("(4) Volver");
			InputStreamVideoclub.pedirCadena();
			cadena = InputStreamVideoclub.cadena;
			try{
				switch(Integer.parseInt(cadena)){
				case 1: {
					mensaje = menuAltaUsuario();
					if(!mensaje.equals("")){
						throw new VideoException(mensaje);
					}
					break;
				}
				case 2: {
					mensaje = menuEditarUsuario();
					if(!mensaje.equals("")){
						throw new VideoException(mensaje);
					}
					break;
				}
				case 3: {
					mensaje = menuConsultarUsuario();
					if(!mensaje.equals("")){
						throw new VideoException(mensaje);
					}
					break;
				}
				case 4: fin = true; break;
				default: System.out.println("Elija una opci�n v�lida");
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opci�n v�lida");
			}catch(VideoException e){
				System.out.println(e.getMessage());
			}
		}while(!fin);
	}
	
	public void mostrarMenuPeliculas(){
		boolean fin = false;
		String cadena = "";
		String mensaje = "";
		do{
			System.out.println("(1) Alta de pel�culas");
			System.out.println("(2) Modificaci�n  de pel�culas");
			System.out.println("(3) Desactivar pel�cula");
			System.out.println("(4) Activar pel�cula");
			System.out.println("(5) Volver");
			InputStreamVideoclub.pedirCadena();
			cadena = InputStreamVideoclub.cadena;
			try{
				switch(Integer.parseInt(cadena)){
					case 1: {
						mensaje = menuAltaPelicula();
						if(!mensaje.equals("")){
							throw new VideoException(mensaje);
						}
						break;
					}
					case 2: {
						mensaje = menuEditarPelicula();
						if(!mensaje.equals("")){
							throw new VideoException(mensaje);
						}
						break;
					}
					case 3: {
						mensaje = menuEstadoPelicula(false);
						if(!mensaje.equals("")){
							throw new VideoException(mensaje);
						}
						break;
					}
					case 4: {
						mensaje = menuEstadoPelicula(true);
						if(!mensaje.equals("")){
							throw new VideoException(mensaje);
						}
						break;
					}
					case 5: fin = true; break;
					default: System.out.println("Elija una opci�n v�lida");
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opci�n v�lida");
			}catch(VideoException e){
				System.out.println(e.getMessage());
			}
		}while(!fin);
	}
	
	public  String menuAltaPelicula(){
		Articulo art = new Articulo();
		String mensaje =art.rellenaPelicula(); 
		
		if(mensaje.equals("")){
			return art.insertar();
		}
		return mensaje;
	}
	
	public String menuEditarPelicula(){
		Articulo art = Articulo.identificarPelicula();
		art.menuMostrarCampos();
		return art.menuModificarPelicula();
	}
	
	public String menuEstadoPelicula(boolean estado){
		Articulo art = Articulo.identificarPelicula();
		try{
			if(art.isAlquilable()==estado){
				throw new VideoException("El art�culo ya tiene ese estado");
			}
		}catch(VideoException e){
			System.out.println(">>>>>>>>> "+e.getMessage()+" <<<<<<<<<<");
		}
		return art.modificarActivacion(estado);
	}
	
	public String menuAltaUsuario(){
		Usuario usu = new Usuario();
		String mensaje = usu.rellenaUsuario();
		if(mensaje.equals("")){
			return usu.altaUsuario();
		}
		return mensaje;
	}
	
	public String menuEditarUsuario(){
		String mensaje = "";
		//Solicito el nombre, apellidos y dni del usuario que desea modificar
		InputStreamVideoclub.pedirCadena("Introduce el nombre del usuario a buscar: ");
		String nombre = InputStreamVideoclub.cadena;
		InputStreamVideoclub.pedirCadena("Introduce los apellidos del usuario a buscar: ");
		String apellidos = InputStreamVideoclub.cadena;
		InputStreamVideoclub.pedirCadena("Introduce el dni: ");
		String dni = InputStreamVideoclub.cadena;
		List<Usuario> resBusqueda = new Usuario().buscaUs(nombre, apellidos, dni);
		//Muestro los resultados de la b�squeda para que elija uno
		if(resBusqueda!=null && resBusqueda.size()>0){
			int i=0;
			//Muestro los resultados
			for(Usuario usu:resBusqueda){
				System.out.println("********** Opci�n "+i+": ************");
				System.out.println(usu.usPantalla());
				i++;
			}
			//Solicito que elija uno
			boolean error = false;
			int opc = 0;
			do{
				InputStreamVideoclub.pedirCadena("Introduce la opci�n que deseas modificar (S�lo el n�mero): ");
				String opcion = InputStreamVideoclub.cadena;
				try{
					opc = Integer.parseInt(opcion);
					if(opc>i && opc>=0){
						throw new VideoException("La opci�n debe ser mayor o igual que cero y menor de "+i);
					}else{
						error = false;
					}
				}catch(NumberFormatException e){
					error = true;
					System.out.println("La opci�n debe ser num�rica");
				}catch(VideoException e){
					System.out.println(e.getMessage());
					error = true;
				}
			}while(error);
			
			Usuario usu = resBusqueda.get(opc);
			usu.mostrarCamposUsuario();
			mensaje = usu.modUs();
			
		}
		//busco los datos del usuario a modificar
		return mensaje;
	}
	
	public String menuConsultarUsuario(){
		String mensaje = "";
		//Solicito el nombre, apellidos y dni del usuario que desea modificar
		InputStreamVideoclub.pedirCadena("Introduce el nombre del usuario a buscar: ");
		String nombre = InputStreamVideoclub.cadena;
		InputStreamVideoclub.pedirCadena("Introduce los apellidos del usuario a buscar: ");
		String apellidos = InputStreamVideoclub.cadena;
		InputStreamVideoclub.pedirCadena("Introduce el dni: ");
		String dni = InputStreamVideoclub.cadena;
		List<Usuario> resBusqueda = new Usuario().buscaUs(nombre, apellidos, dni);
		
		if(resBusqueda!=null && resBusqueda.size()>0){
			System.out.println("\nSe ha encontrado "+resBusqueda.size()+" usuarios:");
			System.out.println("-----------------------------------------------");
			for(Usuario usu:resBusqueda){
				System.out.println(usu.usPantalla());
				System.out.println("-----------------------------------------------\n");
			}
		}else{
			System.out.println("***** Usuario no encontrado *****");
		}
		return mensaje;
	}
	
	public void mostrarMenuConsultas(){
		
	}
	
	public void mostrarMenuFacturacion(){
		
	}
}

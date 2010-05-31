package varios;

import java.util.ArrayList;
import java.util.List;

import usuario.Usuario;
import articulos.Articulo;
import articulos.ArticuloAlquilado;
import articulos.Proveedor;
import facturas.*;
import varios.*;

public class Menu {
	//Método que muestra el menú principal
	public void mostrarMenuPrincipal(){
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
			String mensaje = "";
			try{
				switch(Integer.parseInt(cadena)){
				case 1:{
					InputStreamVideoclub.pedirCadena("Indique la cantidad de películas que desee alquilar");
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
					InputStreamVideoclub.pedirCadena("Indique la cantidad de películas que desee devolver");
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
					System.out.println("Elija una opción válida");
					}
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opción válida");
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
			System.out.println("(2) Modificación datos");
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
				default: System.out.println("Elija una opción válida");
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opción válida");
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
			System.out.println("(1) Alta de películas");
			System.out.println("(2) Modificación  de películas");
			System.out.println("(3) Desactivar película");
			System.out.println("(4) Activar película");
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
					default: System.out.println("Elija una opción válida");
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opción válida");
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
				throw new VideoException("El artículo ya tiene ese estado");
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
		//Muestro los resultados de la búsqueda para que elija uno
		if(resBusqueda!=null && resBusqueda.size()>0){
			int i=0;
			//Muestro los resultados
			for(Usuario usu:resBusqueda){
				System.out.println("********** Opción "+i+": ************");
				System.out.println(usu.usPantalla());
				i++;
			}
			//Solicito que elija uno
			boolean error = false;
			int opc = 0;
			do{
				InputStreamVideoclub.pedirCadena("Introduce la opción que deseas modificar (Sólo el número): ");
				String opcion = InputStreamVideoclub.cadena;
				try{
					opc = Integer.parseInt(opcion);
					if(opc>i && opc>=0){
						throw new VideoException("La opción debe ser mayor o igual que cero y menor de "+i);
					}else{
						error = false;
					}
				}catch(NumberFormatException e){
					error = true;
					System.out.println("La opción debe ser numérica");
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
	
	
	//**************** FACTURACION ******************
	
	public void mostrarMenuFacturacion(){
		boolean fin = false;
		String cadena = "";
		
		do{
			System.out.println("(1) Facturas");
			System.out.println("(2) Albaranes");
			System.out.println("(3) Volver");
			
			
			InputStreamVideoclub.pedirCadena();
			cadena = InputStreamVideoclub.cadena;
			
			try{
				switch(Integer.parseInt(cadena)){
				case 1: menuFactura();break;
				case 2: menuAlbaran();break;
				case 3: mostrarMenuPrincipal();fin = true; break;
				
				default: System.out.println("Elija una opción válida");
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opción válida");
			}
		}while(!fin);
	}
	
	
	
	//********************* MENU FACTURA ********************
	
	public void menuFactura(){
		boolean fin = false;
		String cadena = "";
		String mensaje = "";
		
		do{
			System.out.println("(1) Consultar factura por codigo");
			System.out.println("(2) Consultar factura entre dos fechas");
			System.out.println("(3) Volver");
			
			InputStreamVideoclub.pedirCadena();
			cadena = InputStreamVideoclub.cadena;
			Factura fac = new Factura();
			try{
				switch(Integer.parseInt(cadena)){
					case 1: {
						mensaje=menuConsultarFacturaCodigo();
						if(!mensaje.equals("")){
							throw new VideoException(mensaje);
						}
						break;
					}
					case 2: 
						mensaje=menuConsultarFacturaFechas();
						if(!mensaje.equals("")){
							throw new VideoException(mensaje);
						}
						break;
					case 3: mostrarMenuFacturacion();fin = true;
					break;
				
				default: System.out.println("Elija una opción válida");
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opción válida");
			}
			catch(VideoException e){
				System.out.println(">>>>>>>>> "+e.getMessage()+" <<<<<<<<<<");
			}
			
		}while(!fin);
	}

	//Este menu lo vamos a utilizar en la consultas de facturas
	public String menuConsultarFactura(List<Factura> resBusqueda){
		String mensaje="";
		if(resBusqueda!=null && resBusqueda.size()>0){
			for(Factura fac : resBusqueda){
				System.out.println(fac.fcPantalla());
				System.out.println("-----------------------------------------------\n");
			}
		}else{
			mensaje="Factura no encontrada";
		}
		return mensaje;
	}
	
	public String menuConsultarFacturaCodigo(){
		String mensaje="";
		//Solicito el codigo de la factura
		InputStreamVideoclub.pedirCadena("Introduzca el codigo de la factura: ");
		String cad = InputStreamVideoclub.cadena;
		int cod=Integer.parseInt(cad);
		Factura resBusqueda = new Factura().buscarFactura(cod);
		
		System.out.println(resBusqueda.fcPantalla());
		
		return mensaje;
	}
	
	public String menuConsultarFacturaFechas(){
		String mensaje="";
		Factura fac = new Factura();
		//Solicito mes, año y la diferencia de meses a buscar
		InputStreamVideoclub.pedirCadena("Introduzca el mes de las facturas: ");
		String cad = InputStreamVideoclub.cadena;
		int mes=Integer.parseInt(cad);
		
		InputStreamVideoclub.pedirCadena("Introduzca el año de las facturas: ");
		String cad2 = InputStreamVideoclub.cadena;
		int ano=Integer.parseInt(cad2);
		
		InputStreamVideoclub.pedirCadena("Introduzca el rango de meses de las facturas: ");
		String cad3 = InputStreamVideoclub.cadena;
		int rango=Integer.parseInt(cad3);
		
		List<Factura> resBusqueda = new ArrayList();
		resBusqueda=fac.buscarFacturaFechas(mes,ano,rango);
		
		mensaje=menuConsultarFactura(resBusqueda);
		return mensaje;
	}
	
		
	//********************* MENU ALBARAN ********************
	
	public void menuAlbaran(){
		boolean fin = false;
		String cadena = "";
		String mensaje="";
		Albaran al = new Albaran();
		
		do{
			System.out.println("(1) Consultar albaran por codigo");
			System.out.println("(2) Consultar albaran entre dos fechas");
			System.out.println("(3) Cancelar un albaran");
			System.out.println("(4) Volver");
			
			InputStreamVideoclub.pedirCadena();
			cadena = InputStreamVideoclub.cadena;
			
			try{
				switch(Integer.parseInt(cadena)){
				case 1: 
					mensaje=menuConsultarAlbaranCodigo();
					if(!mensaje.equals("")){
						throw new VideoException(mensaje);
					}
					break;
				
				case 2: 
					mensaje=menuConsultarAlbaranFechas();
					if(!mensaje.equals("")){
						throw new VideoException(mensaje);
					}
				break;
				
				case 3: 
					InputStreamVideoclub.pedirCadena("Introduzca el codigo del albaran a borrar");
					String cad = InputStreamVideoclub.cadena;
					int cod=Integer.parseInt(cad);
					al.cancelarAlbaran(cod);break;
				
				case 4: mostrarMenuFacturacion();fin = true; break;
				
				default: System.out.println("Elija una opción válida");
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opción válida");
			}
			catch(VideoException e){
				System.out.println(">>>>>>>>> "+e.getMessage()+" <<<<<<<<<<");
			}
		}while(!fin);
	}

	//Este menu lo vamos a utilizar en la consultas de facturas
	public String menuConsultarAlbaran(List<Albaran> resBusqueda){
		String mensaje="";
		if(resBusqueda!=null && resBusqueda.size()>0){
			for(Albaran alb : resBusqueda){
				System.out.println(alb.alPantalla());
				System.out.println("-----------------------------------------------\n");
			}
		}else{
			mensaje="Factura no encontrada";
		}
		return mensaje;
	}
	
	public String menuConsultarAlbaranCodigo(){
		String mensaje="";
		//Solicito el codigo de la factura
		InputStreamVideoclub.pedirCadena("Introduzca el codigo del albaran: ");
		String cad = InputStreamVideoclub.cadena;
		int cod=Integer.parseInt(cad);
		Albaran resBusqueda = new Albaran().buscarAlbaran(cod);
		
		System.out.println(resBusqueda.alPantalla());
		
		return mensaje;
		
	}

	public String menuConsultarAlbaranFechas(){
		String mensaje="";
		Albaran al = new Albaran();
		//Solicito mes, año y la diferencia de meses a buscar
		InputStreamVideoclub.pedirCadena("Introduzca el mes de los albaranes: ");
		String cad = InputStreamVideoclub.cadena;
		int mes=Integer.parseInt(cad);
		
		InputStreamVideoclub.pedirCadena("Introduzca el año de los albaranes: ");
		String cad2 = InputStreamVideoclub.cadena;
		int ano=Integer.parseInt(cad2);
		
		InputStreamVideoclub.pedirCadena("Introduzca el rango de meses de los albaranes: ");
		String cad3 = InputStreamVideoclub.cadena;
		int rango=Integer.parseInt(cad3);
		
		List<Albaran> resBusqueda = new ArrayList();
		resBusqueda=al.buscarAlbaranFechas(mes,ano,rango);
		
		mensaje=menuConsultarAlbaran(resBusqueda);
		return mensaje;
	}
	
	public void mostrarMenuProveedores(){
		boolean fin = false;
		String cadena = "";
		
		do{
			System.out.println("(1) Crear proveedor");
			System.out.println("(2) Modificar proveedor");
			System.out.println("(3) Eliminar proveedor");
			System.out.println("(4) Volver");
			
			InputStreamVideoclub.pedirCadena();
			cadena = InputStreamVideoclub.cadena;
			try{
				switch(Integer.parseInt(cadena)){
				case 1: {
					String mensaje = menuAltaProveedor();
					if(!mensaje.equals("")){
						throw new VideoException(mensaje);
					}
					break;
				}
				case 2: menuEditarProveedor();break;
				case 3: break;
				case 4: fin = true; break;
				
				default: System.out.println("Elija una opción válida");
				}
			}catch(NumberFormatException e){
				System.out.println("Elija una opción válida");
			}catch(VideoException e){
				System.out.println(e.getMessage());
			}
		}while(!fin);
	}
	
	public String menuAltaProveedor(){
		String mensaje = "";
		InputStreamVideoclub.pedirCadena("Indique el CIF del proveedor que desea insertar");
		String cif = InputStreamVideoclub.cadena;
		Proveedor prov = new Proveedor().consultarProveedor(cif);
		if(prov!=null){
			mensaje = "El proveedor ya existe en la base de datos";
		}else{
			prov = rellenarProveedor();
			mensaje = prov.crearProveedor();
			if(mensaje.equals("")){
				System.out.println("**** Proveedor insertado correctamente ****");
			}
		}
		return mensaje;
	}
	
	public String menuEditarProveedor(){
		String mensaje = "";
		InputStreamVideoclub.pedirCadena("Indique el CIF del proveedor que desea modificar");
		String cif = InputStreamVideoclub.cadena;
		Proveedor prov = new Proveedor().consultarProveedor(cif);
		if(prov==null){
			mensaje = "El proveedor indicado no existe en la base de datos";
		}else{
			System.out.println("Los datos que puede modificar son:");
			prov.obtenerDatos();
			prov = rellenarEditarProveedor(prov);
			mensaje = prov.editarProveedor();
			if(mensaje.equals("")){
				System.out.println("**** Proveedor actualizado correctamente ****");
			}
		}
		return mensaje;
	}
	
	public Proveedor rellenarProveedor(){
		Proveedor prov = new Proveedor();
		String cadena = "";
		boolean vacio = false;
		do{
			InputStreamVideoclub.pedirCadena(" Introducir el nombre (*): ");
			cadena = InputStreamVideoclub.cadena;
			if(cadena.equals("")){
				vacio = true;
				System.out.println("El campo nombre es obligatorio");
			}else{
				prov.setNombre(cadena);
				vacio = false;
			}
		}while(vacio);
		
		vacio = false;
		do{
			InputStreamVideoclub.pedirCadena(" Introducir el CIF (*): ");
			cadena = InputStreamVideoclub.cadena;
			if(cadena.equals("")){
				vacio = true;
			}else{
				prov.setCif(cadena);
			}
		}while(vacio);
		
		InputStreamVideoclub.pedirCadena(" Introducir el teléfono: ");
		cadena = InputStreamVideoclub.cadena;
		prov.setTelefono(cadena);
		
		InputStreamVideoclub.pedirCadena(" Introducir el fax: ");
		cadena = InputStreamVideoclub.cadena;
		prov.setFax(cadena);
		
		InputStreamVideoclub.pedirCadena(" Introducir la dirección: ");
		cadena = InputStreamVideoclub.cadena;
		prov.setDireccion(cadena);
		
		InputStreamVideoclub.pedirCadena(" Introducir la web: ");
		cadena = InputStreamVideoclub.cadena;
		prov.setWeb(cadena);
		
		return prov;
	}
	
	public Proveedor rellenarEditarProveedor(Proveedor prov){
		boolean fin = false;
		boolean vacio = false;
		String cadena = "";	
		do
		{	
			InputStreamVideoclub.pedirCadena("Introduzca el número asociado al campo que desea modificar o 7 para terminar");
			cadena = InputStreamVideoclub.cadena;
			try{
				switch(Integer.parseInt(cadena))
				{
					case 1: {
						vacio = false;
						do{
							InputStreamVideoclub.pedirCadena("(1) Introducir nombre (*) : ");
							cadena = InputStreamVideoclub.cadena;
							if(cadena.equals("")){
								System.out.println("El campo nombre no puede estar vacío");
								vacio = true;
							}else{
								prov.setNombre(cadena);
								vacio = false;
							}
						}while(vacio);
						break;
					}
					case 2: {
						vacio = false;
						do{
							InputStreamVideoclub.pedirCadena("(2) Introducir cif : ");
							cadena = InputStreamVideoclub.cadena;
							if(cadena.equals("")){
								System.out.println("El campo nombre no puede estar vacío");
								vacio = false;
							}else{
								prov.setCif(cadena);
								vacio = false;
							}
						}while(vacio);
						break;	
					}
					case 3:
						InputStreamVideoclub.pedirCadena("(3) Introducir telefono : ");
						cadena = InputStreamVideoclub.cadena;
						prov.setTelefono(cadena);
						break;
					case 4:
						InputStreamVideoclub.pedirCadena("(4) Introducir dirección : ");
						cadena = InputStreamVideoclub.cadena;
						prov.setDireccion(cadena);
						break;
					case 5 :
						InputStreamVideoclub.pedirCadena("(5) Introducir web : ");
						cadena = InputStreamVideoclub.cadena;
						prov.setWeb(cadena);
						break;
					case 6 :
						InputStreamVideoclub.pedirCadena("(6) Introducir fax : ");
						cadena = InputStreamVideoclub.cadena;
						prov.setFax(cadena);
						break;
					case 7 :
						fin=true;
						break;
					default: System.out.println("Elija una opción válida");
												
				}
			}catch(NumberFormatException e)
			{
				System.out.println("Elija una opción válida");
				prov.editarProveedor();
			}
						
		}while(!fin ); 
		return prov;
		
	}

}

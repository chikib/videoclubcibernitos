package usuario;

import java.util.List;
import bbdd.Usuarios;
import varios.InputStreamVideoclub;
import varios.Menu;
import varios.VideoException;

public class Usuario {

	private int codigo;
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private String telefono;
	private boolean activo;
	private boolean bloqueado;
	
	// get y set
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public boolean isBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	
	
	// Constructor Usuario creacion objeto por paso de parametros   
	public Usuario (int vcod,String vnom ,String vapell, String vdni,
			String vdir, String vtel, boolean vactivo, boolean bloqueado)
	{
		this.codigo = vcod ;
		this.nombre = vnom ;
		this.apellidos = vapell ;
		this.dni = vdni ;
		this.direccion = vdir ;
		this.telefono = vtel ;
		this.activo = vactivo ;
		this.bloqueado = bloqueado ;
	}
	// Constructor Usuario sin parametros   
	public Usuario ()
	{
		
	}
		
	public String rellenaUsuario()
	{
		//en este metodo se procedera al almacenamiento de los atributos del objeto
		String cadena = "";
		String mensaje = "";
		try
		{				
			InputStreamVideoclub.pedirCadena("Introducir Nombre : ");
			cadena = InputStreamVideoclub.cadena;
			setNombre(cadena);
			
			InputStreamVideoclub.pedirCadena("Introducir Apellidos : ");
			cadena = InputStreamVideoclub.cadena;
			setApellidos(cadena);
			
			InputStreamVideoclub.pedirCadena("Introducir Dni : ");
			cadena = InputStreamVideoclub.cadena;
			setDni(cadena);
			
			InputStreamVideoclub.pedirCadena("Introducir Dirección : ");
			cadena = InputStreamVideoclub.cadena;
			setDireccion(cadena);
			
			InputStreamVideoclub.pedirCadena("Introducir Teléfono : ");
			cadena = InputStreamVideoclub.cadena;
			setTelefono(cadena);
			
			boolean error = false;
			do{
				InputStreamVideoclub.pedirCadena("Introducir el valor de Usuario activo (1 para cierto y 0 para falso) : ");
				cadena = InputStreamVideoclub.cadena;
				if(!cadena.equals("1") && !cadena.equals("0")){
					error = true;
				}else{
					error = false;
					setActivo(Boolean.parseBoolean(cadena));
				}
			}while(error);
			
			error = false;
			do{
				InputStreamVideoclub.pedirCadena("Introducir el valor de Bloqueado (1 para cierto y 0 para falso): ");
				cadena = InputStreamVideoclub.cadena;
				if(!cadena.equals("1") && !cadena.equals("0")){
					error = true;
				}else{
					error = false;
					setBloqueado(Boolean.parseBoolean(cadena));
				}
			}while(error);
		}
		catch(NumberFormatException e)
		{
			mensaje = "Ha ocurrido un error al transformar uno de los valores indicados en la inserción";
		}
		return mensaje;
	}
	
	public String altaUsuario(){
		String mensaje = "";
		Usuarios usu = new Usuarios();
		int res = usu.insertar(this);
		if(res==0){
			mensaje = "No se ha podido insertar el artículo";
		}else{
			System.out.println("\n******** Usuarios insertado *********\n");
		}
		return mensaje;
	}
	
	public String  usPantalla ()
	{		
		return ("Código         : " + codigo+ "\n" +
		"Nombre         : " + nombre + "\n" +
		"Apellidos      : " + apellidos + "\n" +
		"Dni            : " + dni + "\n" +
		"Dirección      : " + direccion + "\n" +
		"Telefono       : " + telefono + "\n" +
		"Usuario activo : " + activo + "\n" +
		"Bloqueado      : " + bloqueado);
				
	}	
	
	public List<Usuario> buscaUs(String nombre, String apellidos, String dni)
	{
		return new Usuarios().buscarUsuarioDatos(nombre, apellidos, dni);	
	}
	
	
	public void mostrarCamposUsuario(){
		String activo = "0";
		if(isActivo()){
			activo = "1";
		}
		String bloqueado = "0";
		if(isBloqueado()){
			bloqueado = "1";
		}
		System.out.println("La lista de campos que se pueden modificar son: ");
		System.out.println ("-----------------------------------");
		System.out.println ("(1) Nombre : "+getNombre());
		System.out.println ("(2) Apellidos : "+getApellidos());
		System.out.println ("(3) Dni : "+getDni());
		System.out.println ("(4) Dirección : "+getDireccion());
		System.out.println ("(5) Telefono : "+getTelefono());
		System.out.println ("(6) Usuario activo : "+activo);
		System.out.println ("(7) Bloqueado : "+bloqueado);
		System.out.println ("(8) Salir ");
		System.out.println ("-----------------------------------");
	}
	
	public String modUs ()
	{
		boolean fin = false;
		String cadena = "";
		String mensaje = "";
		// metodo busqueda en la coleccion el codigo de 
		//usuario y devuelve el indice de la lista donde se encuentra 		
		
		//si se ha encontrado el usuario procedemos a 
		 //capturar los datos que queremos modificar 		
		do
		{	
			InputStreamVideoclub.pedirCadena("Introduzca el número asociado al campo que desea modificar");
			cadena = InputStreamVideoclub.cadena;
			try{
				switch(Integer.parseInt(cadena))
				{
					case 1: 
						InputStreamVideoclub.pedirCadena("(2) Introducir Nombre : ");
						cadena = InputStreamVideoclub.cadena;
						setNombre(cadena);
						break;
					case 2: 
						InputStreamVideoclub.pedirCadena("(3) Introducir Apellidos : ");
						cadena = InputStreamVideoclub.cadena;
						setApellidos(cadena);
						break;
					case 3:
						InputStreamVideoclub.pedirCadena("(4) Introducir Dni : ");
						cadena = InputStreamVideoclub.cadena;
						setDni(cadena);
						break;
					case 4:
						InputStreamVideoclub.pedirCadena("(5) Introducir Dirección : ");
						cadena = InputStreamVideoclub.cadena;
						setDireccion(cadena);
						break;
					case 5 :
						InputStreamVideoclub.pedirCadena("(6) Introducir Telefono : ");
						cadena = InputStreamVideoclub.cadena;
						setTelefono(cadena);
						break;
					case 6:
						boolean error = false;
						do{
							InputStreamVideoclub.pedirCadena("Introducir el valor de Usuario activo (1 para cierto y 0 para falso) : ");
							cadena = InputStreamVideoclub.cadena;
							if(!cadena.equals("1") && !cadena.equals("0")){
								error = true;
							}else{
								error = false;
								setActivo(Boolean.parseBoolean(cadena));
							}
						}while(error);
						break;
					case 7:
						error = false;
						do{
							InputStreamVideoclub.pedirCadena("Introducir el valor de Bloqueado (1 para cierto y 0 para falso): ");
							cadena = InputStreamVideoclub.cadena;
							if(!cadena.equals("1") && !cadena.equals("0")){
								error = true;
							}else{
								error = false;
								setBloqueado(Boolean.parseBoolean(cadena));
							}
						}while(error);
						break;
					case 8:
						Usuarios usuBbdd= new Usuarios();
						int res = usuBbdd.modificar(this);
						if(res==0){
							mensaje = "Ha ocurrido un error al modificar el artículo";
						}else{
							System.out.println("Modiicación realizada con éxito");
						}
						fin= true; 
						break;
					default: System.out.println("Elija una opción válida");
												
				}
			}catch(NumberFormatException e)
			{
				System.out.println("Elija una opción válida");
				modUs();
			}
						
		}while(!fin ); 
		return mensaje;
	}
	
	public static Usuario buscaUscod(int codUs) 
	{
		// se introduce el codigo de usuario que se desea encontrar 
		//y si lo encu8entra, devuelve el objeto usuario 	
		Usuarios usubbdd = new Usuarios();
		return usubbdd.buscarUsuario(codUs);
	}
	
	public static Usuario identificarUsuario(){
		InputStreamVideoclub.pedirCadena("Introduzca el número de socio del cliente o 0 para volver al menú anterior: ");
		String cadena = InputStreamVideoclub.cadena;
		Usuario usu = null;
		int numeroSocio;
		try{
			numeroSocio = Integer.parseInt(cadena);
			switch(numeroSocio){
				case 0: new Menu().mostrarMenuPrincipal();break;
				default: {
					usu = Usuario.buscaUscod(numeroSocio);
					if(usu!=null){
						return usu;
					}else{
						throw new VideoException("*** El número de socio indicado no existe ***\n");
					}
						
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("El dato introducido no es válido");
			identificarUsuario();
		}
		catch(VideoException e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}

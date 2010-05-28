package usuario;

import bbdd.Usuarios;
import varios.InputStreamVideoclub;
import varios.VideoException;
import varios.Videoclub;


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
		
	public void altaUsuario ()
	{
	//en este metodo se procedera al almacenamiento de los atributos del objeto
	//	boolean fin = false;
		String cadena = "";
		//int i = 1;
		Usuario oUsu = new Usuario(); 
		
		try
		{
				System.out.println ("(1) Introducir C�digo : "); 
				InputStreamVideoclub.pedirCadena();
				cadena = InputStreamVideoclub.cadena;
				oUsu.setCodigo(Integer.parseInt(cadena));
				
				
				System.out.println ("(2) Introducir Nombre : ");
				InputStreamVideoclub.pedirCadena();
				cadena = InputStreamVideoclub.cadena;
				oUsu.setNombre(cadena);
				
				System.out.println ("(3) Introducir Apellidos : ");
				InputStreamVideoclub.pedirCadena();
				cadena = InputStreamVideoclub.cadena;
				oUsu.setApellidos(cadena);
				
				System.out.println ("(4) Introducir Dni : ");
				InputStreamVideoclub.pedirCadena();
				cadena = InputStreamVideoclub.cadena;
				oUsu.setDni(cadena);
				
				System.out.println ("(5) Introducir Direcci�n : ");
				InputStreamVideoclub.pedirCadena();
				cadena = InputStreamVideoclub.cadena;
				oUsu.setDireccion(cadena);
				
				System.out.println ("(6) Introducir Telefono : ");
				InputStreamVideoclub.pedirCadena();
				cadena = InputStreamVideoclub.cadena;
				oUsu.setTelefono(cadena);
				
				System.out.println ("(7) Introducir Usuario activo : ");
				InputStreamVideoclub.pedirCadena();
				cadena = InputStreamVideoclub.cadena;
				oUsu.setActivo(Boolean.parseBoolean(cadena));
				
				System.out.println ("(8) Introducir Bloqueado : ");
				InputStreamVideoclub.pedirCadena();
				cadena = InputStreamVideoclub.cadena;
				oUsu.setBloqueado(Boolean.parseBoolean(cadena));
				
				System.out.println(" Proceso de alta finalizado. ");
				
			
		}
		catch(NumberFormatException e)
		{
			System.out.println("Elija una opci�n v�lida");
		}
		
		//a�ado a la lista el objeto creado con los datos del nuevo usuario
		Videoclub.listaUsuarios.add(oUsu); 
		
	}
	
	public String  usPantalla (int indiceLista)
	{
		/* Hya que introducir el indice de la lista donde se encuentra el usuario buscado
		 * Este m�todo devuelve una cadena formateada para ser impresa por pantalla*/
		
		/*System.out.print ("Datos del Usuario");
		System.out.print ("C�digo : " + this.codigo);
		System.out.print ("Nombre : " + this.nombre);
		System.out.print ("Apellidos : " + this.apellidos);
		System.out.print ("Dni : " + this.dni);
		System.out.print ("Direcci�n : " + this.direccion);
		System.out.print ("Telefono : " + this.telefono);
		System.out.print ("Usuario activo : " + this.activo);
		System.out.print ("Bloqueado : " + this.bloqueado);*/
		
		Videoclub.listaUsuarios.get(indiceLista);
		Usuario us = new Usuario();
		
		
		return ("Datos del Usuario" + "/n" +
		"C�digo         : " + us.codigo+ "/n" +
		"Nombre         : " + us.nombre + "/n" +
		"Apellidos      : " + us.apellidos + "/n" +
		"Dni            : " + us.dni + "/n" +
		"Direcci�n      : " + us.direccion + "/n" +
		"Telefono       : " + us.telefono + "/n" +
		"Usuario activo : " + us.activo + "             " +
		"Bloqueado      : " + us.bloqueado);
				
	}	
	
	public void buscaUs(String dni, String nombre, String apellidos)
	{
		//metodo no definido esperando a la creacion de bbdd para hacer la busqueda mediante select 
	}
	
	//public void modUs ( String vnom ,String vapell, String vdni)
	public void modUs ( int codUs)
	{
		/*boolean fin = false;
		String cadena = "";
		int indiceLista;
		
		//indiceLista = buscaUs(vdni,vapell,vnom);  metodo busqueda en la coleccion 
		indiceLista = buscaUscod(codUs); 
		// metodo busqueda en la coleccion el codigo de 
		//usuario y devuelve el indice de la lista donde se encuentra 
		//usPantalla(indiceLista); //mostramos los datos del usuario por pantalla
		
		
		//si se ha encontrado el usuario procedemos a 
		 //capturar los datos que queremos modificar 
		do
		{	System.out.println ("-----------------------------------");
			System.out.println ("(1) Introducir C�digo : ");
			System.out.println ("(2) Introducir Nombre : ");
			System.out.println ("(3) Introducir Apellidos : ");
			System.out.println ("(4) Introducir Dni : ");
			System.out.println ("(5) Introducir Direcci�n : ");
			System.out.println ("(6) Introducir Telefono : ");
			System.out.println ("(7) Introducir Usuario activo : ");
			System.out.println ("(8) Introducir Bloqueado : ");
			System.out.println ("(9) Salir : ");
			System.out.println ("-----------------------------------");
			
			InputStreamVideoclub.pedirCadena();
			cadena = InputStreamVideoclub.cadena;
			try{
				switch(Integer.parseInt(cadena))
				{
					
					case 1:
						System.out.println ("(1) Introducir C�digo : "); 
						InputStreamVideoclub.pedirCadena();
						cadena = InputStreamVideoclub.cadena;
						setCodigo(Integer.parseInt(cadena));
						break;
					case 2: 
						System.out.println ("(2) Introducir Nombre : ");
						InputStreamVideoclub.pedirCadena();
						cadena = InputStreamVideoclub.cadena;
						setNombre(cadena);
						break;
					case 3: 
						System.out.println ("(3) Introducir Apellidos : ");
						InputStreamVideoclub.pedirCadena();
						cadena = InputStreamVideoclub.cadena;
						setApellidos(cadena);
						break;
					case 4:
						System.out.println ("(4) Introducir Dni : ");
						InputStreamVideoclub.pedirCadena();
						cadena = InputStreamVideoclub.cadena;
						setDni(cadena);
						break;
					case 5:
						System.out.println ("(5) Introducir Direcci�n : ");
						InputStreamVideoclub.pedirCadena();
						cadena = InputStreamVideoclub.cadena;
						setDireccion(cadena);
						break;
					case 6 :
						System.out.println ("(6) Introducir Telefono : ");
						InputStreamVideoclub.pedirCadena();
						cadena = InputStreamVideoclub.cadena;
						setTelefono(cadena);
						break;
					case 7:
						System.out.println ("(7) Introducir Usuario activo : ");
						InputStreamVideoclub.pedirCadena();
						cadena = InputStreamVideoclub.cadena;
						setActivo(Boolean.parseBoolean(cadena));
						break;
					case 8:
						System.out.println ("(8) Introducir Bloqueado : ");
						InputStreamVideoclub.pedirCadena();
						cadena = InputStreamVideoclub.cadena;
						setBloqueado(Boolean.parseBoolean(cadena));
						break;
					case 9:
						fin = true;					
						System.out.println(" Proceso de alta finalizado. ");
						break;
					default: System.out.println("Elija una opci�n v�lida");
												
				}
			}catch(NumberFormatException e)
			{
				System.out.println("Elija una opci�n v�lida");
			}
						
		}while(!fin ); 
		
		Usuario us = new Usuario();
		Videoclub.listaUsuarios.set( indiceLista , us);*/
			
	}
	
	public static Usuario buscaUscod(int codUs) 
	{
		// se introduce el codigo de usuario que se desea encontrar 
		//y si lo encu8entra, devuelve el objeto usuario 
		
		//creamos el iterador para recorrer  la lista de usuarios
		
		/*for (Usuario us : Videoclub.listaUsuarios)
		{
			if (us.getCodigo() == codUs)
			{
				//Videoclub.listaUsuarios.indexOf(us);
				return i; // devuelve la posicion en que se encuentra el cliente dentro de la lista
			}
			i++;
		}*/
	
		Usuarios usubbdd = new Usuarios();
		return usubbdd.buscarUsuario(codUs);
	}
	/*public int buscaUs(String dni, String nombre, String apellidos) 
	{
		// se introduce el dni , nombre y apellidos  de usuario que se desea encontrar 
		//y si lo encu8entra, devuelve el objeto usuario 
		
		//creamos el iterador para recorrer  la lista de usuarios
		
		for (Usuario us : Videoclub.Listausuarios)
		{
			
		}
	}*/
	
	public static Usuario identificarUsuario(){
		InputStreamVideoclub.pedirCadena("Introduzca el n�mero de socio del cliente o 0 para volver al men� anterior: ");
		String cadena = InputStreamVideoclub.cadena;
		Usuario usu = null;
		int numeroSocio;
		try{
			numeroSocio = Integer.parseInt(cadena);
			switch(numeroSocio){
				case 0: Videoclub.mostrarMenuPrincipal();break;
				default: {
					usu = Usuario.buscaUscod(numeroSocio);
					if(usu!=null){
						return usu;
					}else{
						throw new VideoException("*** El n�mero de socio indicado no existe ***\n");
					}
					/*if(pos>=0){
						return Videoclub.listaUsuarios.get(pos);
					}else{
						throw new VideoException("*** El n�mero de socio indicado no existe ***\n");
					}*/
						
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("El dato introducido no es v�lido");
			identificarUsuario();
		}
		catch(VideoException e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}

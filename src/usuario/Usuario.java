package usuario;

import varios.InputStreamVideoclub;
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
				System.out.println ("(1) Introducir Código : "); 
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
				
				System.out.println ("(5) Introducir Dirección : ");
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
			System.out.println("Elija una opción válida");
		}
		
		
		Videoclub.listaUsuarios.add( oUsu);
		
	}
	
	public String  usPantalla (int indicelista)
	{
		/* Hya que introducir los parametros dni,nombre y apellidos del usuario a mostrar
		 * Este método devuelve una cadena formateada para ser impresa por pantalla*/
		
		/*System.out.print ("Datos del Usuario");
		System.out.print ("Código : " + this.codigo);
		System.out.print ("Nombre : " + this.nombre);
		System.out.print ("Apellidos : " + this.apellidos);
		System.out.print ("Dni : " + this.dni);
		System.out.print ("Dirección : " + this.direccion);
		System.out.print ("Telefono : " + this.telefono);
		System.out.print ("Usuario activo : " + this.activo);
		System.out.print ("Bloqueado : " + this.bloqueado);*/
		
		return ("Datos del Usuario" + "/n" +
		"Código         : " + this.codigo + "/n" +
		"Nombre         : " + this.nombre + "/n" +
		"Apellidos      : " + this.apellidos + "/n" +
		"Dni            : " + this.dni + "/n" +
		"Dirección      : " + this.direccion + "/n" +
		"Telefono       : " + this.telefono + "/n" +
		"Usuario activo : " + this.activo + "             " +
		"Bloqueado      : " + this.bloqueado);
				
	}	
	
	public void buscaUs(String dni, String nombre, String apellidos)
	{
		//metodo no definido esperando a la creacion de bbdd para hacer la busqueda mediante select 
	}
	
	public void modUs ( String vnom ,String vapell, String vdni)
	{
		boolean fin = false;
		String cadena = "";
	//	private int indiceLista;
		
		//indicelista = buscaUs(vdni,vapell,vnom); /* metodo busqueda en la coleccion */
		//usPantalla(indiceLista); //mostramos los datos del usuario por pantalla
		
		
		/*si se ha encontrado el usuario procedemos a 
		 *capturar los datos que queremos modificar */
		do
		{
			System.out.println ("(1) Introducir Código : ");
			System.out.println ("(2) Introducir Nombre : ");
			System.out.println ("(3) Introducir Apellidos : ");
			System.out.println ("(4) Introducir Dni : ");
			System.out.println ("(5) Introducir Dirección : ");
			System.out.println ("(6) Introducir Telefono : ");
			System.out.println ("(7) Introducir Usuario activo : ");
			System.out.println ("(8) Introducir Bloqueado : ");
			System.out.println ("(9) Salir : ");
			
			InputStreamVideoclub.pedirCadena();
			cadena = InputStreamVideoclub.cadena;
			try{
				switch(Integer.parseInt(cadena))
				{
					
					case 1:
						System.out.println ("(1) Introducir Código : "); 
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
						System.out.println ("(5) Introducir Dirección : ");
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
					default: System.out.println("Elija una opción válida");
												
				}
			}catch(NumberFormatException e)
			{
				System.out.println("Elija una opción válida");
			}
						
		}while(!fin ); 
			
	}
	
	/*public int buscaUscod(int cod) 
	{
		// se introduce el codigo de usuario que se desea encontrar 
		//y si lo encu8entra, devuelve el objeto usuario 
		
		//creamos el iterador para recorrer  la lista de usuarios
		
		for (Usuario us : Videoclub.listaUsuarios)
		{
			
		}
	}*/
	/*public int buscaUs(String dni, String nombre, String apellidos) 
	{
		// se introduce el dni , nombre y apellidos  de usuario que se desea encontrar 
		//y si lo encu8entra, devuelve el objeto usuario 
		
		//creamos el iterador para recorrer  la lista de usuarios
		
		for (Usuario us : Videoclub.Listausuarios)
		{
			
		}
	}*/
	
}

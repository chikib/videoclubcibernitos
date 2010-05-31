package articulos;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import bbdd.Articulos;
import varios.InputStreamVideoclub;
import varios.Menu;
import varios.VideoException;

public class Articulo {
	private int codigo;
	private long codigoBarras;
	private String titulo;
	private String descripcion;
	private Categoria categoria;
	private Soporte soporte;
	private Proveedor proveedor;
	private double precioAlquiler;
	private boolean alquilado;
	private Date fechaCompra;
	private double precioCompra;
	private boolean novedad;
	private String localizacion;
	private boolean alquilable;
	
	public Articulo(){
		
	}
	public Articulo(int codigo,long codigoBarras,String titulo,String descripcion,Categoria categoria,Soporte soporte,Proveedor proveedor,
			double precioAlquiler,boolean alquilado,Date fechaCompra,double precioCompra,boolean novedad,String localizacion,boolean alquilable){
		this.codigo = codigo;
		this.codigoBarras = codigoBarras;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.soporte = soporte;
		this.proveedor = proveedor;
		this.precioAlquiler = precioAlquiler;
		this.alquilado = alquilado;
		this.fechaCompra = fechaCompra;
		this.precioCompra = precioCompra;
		this.novedad = novedad;
		this.localizacion = localizacion;
		this.setAlquilable(alquilable);
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigoBarras(long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public long getCodigoBarras() {
		return codigoBarras;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setSoporte(Soporte soporte) {
		this.soporte = soporte;
	}
	public Soporte getSoporte() {
		return soporte;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	public double getPrecioAlquiler() {
		return precioAlquiler;
	}
	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
	public boolean isAlquilado() {
		return alquilado;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setNovedad(boolean novedad) {
		this.novedad = novedad;
	}
	public boolean isNovedad() {
		return novedad;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public String getLocalizacion() {
		return localizacion;
	}

	public void setAlquilable(boolean alquilable) {
		this.alquilable = alquilable;
	}

	public boolean isAlquilable() {
		return alquilable;
	}
	
	/*public static int buscaArticuloDisponible(int codigo){
		int i = 0;
		for (Articulo articulo : listaPeliculas)
		{
			if (articulo.getCodigoBarras() == codigo && articulo.isAlquilado() == false)
			{
				//Videoclub.listaUsuarios.indexOf(us);
				return i; // devuelve la posicion en que se encuentra el cliente dentro de la lista
			}
			i++;
		}
	
		return -1;
	}*/
	
	public static Articulo buscaArticulo(int codigo){
		Articulos artbbdd = new Articulos();
		Articulo art = artbbdd.buscarArticuloCodigoBarras(codigo);		
		return art;
	}
	
	/*public static int identificarPeliculaDisponible(){
		InputStreamVideoclub.pedirCadena("Introduzca el código de barras de la película o 0 para volver al menú anterior: ");
		String cadena = InputStreamVideoclub.cadena;
		int codigo;
		try{
			codigo = Integer.parseInt(cadena);
			switch(codigo){
				case 0: new Menu().mostrarMenuPrincipal();break;
				default: {
						int pos = Articulo.buscaArticuloDisponible(codigo);
						if(pos>=0){
							return pos;
						}else{
							throw new VideoException("*** El número de película indicada no existe ***\n");
						}
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("El dato introducido no es válido");
			identificarPeliculaDisponible();
		}catch(VideoException e){
			System.out.println(e.getMessage());
		}
		return -1;
	}*/
	
	public static Articulo identificarPelicula(){
		InputStreamVideoclub.pedirCadena("Introduzca el código de barras de la película o 0 para volver al menú anterior: ");
		String cadena = InputStreamVideoclub.cadena;
		Articulo art = null;
		int codigo;
		try{
			codigo = Integer.parseInt(cadena);
			switch(codigo){
				case 0: new Menu().mostrarMenuPrincipal();break;
				default: {
					art = buscaArticulo(codigo);
					if(art!=null){
						return art;
					}else{
						throw new VideoException("*** El número de película indicada no existe ***\n");
					}
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("El dato introducido no es válido");
			identificarPelicula();
		}catch(VideoException e){
			System.out.println(e.getMessage());
		}
		return art;
	}
	
	public String rellenaPelicula()
	{
		String mensaje = "";
		try{
			String cadena = "";
			InputStreamVideoclub.pedirCadena(" Introducir título : ");
			cadena = InputStreamVideoclub.cadena;
			setTitulo(cadena);
		
			InputStreamVideoclub.pedirCadena(" Introducir descripción : ");
			cadena = InputStreamVideoclub.cadena;				
			setDescripcion(cadena);
							
			InputStreamVideoclub.pedirCadena(" Introducir precio del alquiler : ");
			cadena = InputStreamVideoclub.cadena;
			setPrecioAlquiler(Double.parseDouble(cadena));
			
			setAlquilado(false);
			
			InputStreamVideoclub.pedirCadena(" Indicar si es alquilable (0 para falso, 1 para cierto): ");
			cadena = InputStreamVideoclub.cadena;
			setAlquilable(cadena.equals("1"));
			
			InputStreamVideoclub.pedirCadena(" Introducir el precio de compra : ");
			cadena = InputStreamVideoclub.cadena;
			setPrecioCompra(Double.parseDouble(cadena));
			boolean error = false;
			do{
				error = false;
				InputStreamVideoclub.pedirCadena(" Introducir la fecha de compra (dd/mm/yyyy) : ");
				cadena = InputStreamVideoclub.cadena;
				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try{
					setFechaCompra(sdf.parse(cadena));
				}catch(ParseException e){
					System.out.println(e.getMessage());
					error = true;
				}
			}while(error);
			
			InputStreamVideoclub.pedirCadena(" Indicar si es una novedad (0 para falso, 1 para cierto): ");
			cadena = InputStreamVideoclub.cadena;				
			setNovedad(cadena.equals("1"));
			
			InputStreamVideoclub.pedirCadena(" Introducir localización : ");
			cadena = InputStreamVideoclub.cadena;				
			setLocalizacion(cadena);
			
			InputStreamVideoclub.pedirCadena(" Introducir código de barras : ");
			cadena = InputStreamVideoclub.cadena;				
			setCodigoBarras(Long.parseLong(cadena));
			
			Proveedor prov = new Proveedor();
			prov.imprimirProveedores();
			InputStreamVideoclub.pedirCadena("Elija uno de los siguientes proveedores: ");
			cadena = InputStreamVideoclub.cadena;				
			prov.setCodigo(Integer.parseInt(cadena));
			setProveedor(prov);
			
			Soporte soporte = new Soporte();
			soporte.imprimirSoportes();
			InputStreamVideoclub.pedirCadena("Elija uno de los siguientes soportes: ");
			cadena = InputStreamVideoclub.cadena;				
			soporte.setCodigo(Integer.parseInt(cadena));
			setSoporte(soporte);
			
			Categoria categoria = new Categoria();
			categoria.imprimirCategorias();
			InputStreamVideoclub.pedirCadena("Elija una de las siguientes categorías: ");
			cadena = InputStreamVideoclub.cadena;				
			categoria.setCodigo(Integer.parseInt(cadena));
			setCategoria(categoria);
		}catch(NumberFormatException e){
			mensaje = "Ha ocurrido un error al transformar uno de los valores indicados en la inserción";
		}
		return mensaje;
	}	
	
	public void menuMostrarCampos(){
		String sNovedad = "0";
		if(isNovedad()){
			sNovedad = "1";
		}
		
		String sAlquilado = "0";
		if(isAlquilado()){
			sAlquilado = "1";
		}
		
		String sAlquilable = "0";
		if(isAlquilable()){
			sAlquilable = "1";
		}
		
		System.out.println("La lista de campos que se pueden modificar son: ");
		System.out.println("(1) Título: "+getTitulo());
		System.out.println("(2) Descripción: "+getDescripcion());
		System.out.println("(3) Categoría: "+getCategoria().getCodigo()+", "+getCategoria().getTematica());
		new Categoria().imprimirCategorias();
		System.out.println("(4) Soporte: "+getSoporte().getCodigo()+", "+getSoporte().getTipo());
		new Soporte().imprimirSoportes();
		System.out.println("(5) Proveedor: "+getProveedor().getCodigo()+", "+getProveedor().getNombre());
		new Proveedor().imprimirProveedores();
		System.out.println("(6) Precio de alquiler: "+getPrecioAlquiler());
		System.out.println("(7) Alquilado: "+sAlquilado);
		System.out.println("(8) Fecha de compra: "+getFechaCompra());
		System.out.println("(9) Precio de compra: "+getPrecioCompra());
		System.out.println("(10) Novedad: "+sNovedad);
		System.out.println("(11) Localización: "+getLocalizacion());
		System.out.println("(12) Código de barras: "+getCodigoBarras());
		System.out.println("(13) Alquilable: "+sAlquilable);
		System.out.println("(14) Salir ");
	}
	
	public String menuModificarPelicula(){
		int opcion ;
		boolean salir = false;
		String mensaje = "";
		//mostrar los campos de ese artículo y sus valores
		try{
			do{
				InputStreamVideoclub.pedirCadena(" Indica el campo que desea modificar o la opción indicada para terminar: ");
				opcion = Integer.parseInt(InputStreamVideoclub.cadena);
				switch(opcion){
					case 1: {//titulo
						InputStreamVideoclub.pedirCadena("Nuevo valor para el título: ");
						String titulo = InputStreamVideoclub.cadena;
						setTitulo(titulo);
						break;
					}case 2:{//descripcion
						InputStreamVideoclub.pedirCadena("Nuevo valor para la descripción: ");
						String descripcion = InputStreamVideoclub.cadena;
						setDescripcion(descripcion);
						break;
					}case 3:{//categoria
						InputStreamVideoclub.pedirCadena("Nuevo valor para la categoría: ");
						String categoria = InputStreamVideoclub.cadena;
						Categoria cat = new Categoria();
						cat.setCodigo(Integer.parseInt(categoria));
						setCategoria(cat);
						break;
					}case 4:{//soporte
						InputStreamVideoclub.pedirCadena("Nuevo valor para el soporte: ");
						String sSoporte = InputStreamVideoclub.cadena;
						Soporte soporte = new Soporte();
						soporte.setCodigo(Integer.parseInt(sSoporte));
						setSoporte(soporte);
						break;
					}case 5:{//proveedor
						InputStreamVideoclub.pedirCadena("Nuevo valor para el proveedor: ");
						String proveedor = InputStreamVideoclub.cadena;
						Proveedor prov = new Proveedor();
						prov.setCodigo(Integer.parseInt(proveedor));
						setProveedor(prov);
						break;
					}case 6:{//precioAlquiler
						InputStreamVideoclub.pedirCadena("Nuevo valor para el precio de alquiler: ");
						String precio = InputStreamVideoclub.cadena;
						setPrecioAlquiler(Double.parseDouble(precio));
						break;
					}case 7:{//alquilado
						InputStreamVideoclub.pedirCadena("Nuevo valor para la opción de alquilado (Indicar 1 para cierto y 0 para falso): ");
						String alquilado = InputStreamVideoclub.cadena;
						setAlquilado(alquilado.equals("1"));
					}case 8:{//fechaCompra
						try{
							InputStreamVideoclub.pedirCadena("Nuevo valor para la fecha de compra (Formato dd/mm/yyyy): ");
							DateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
							Date fechaCompra = sdf.parse(InputStreamVideoclub.cadena);
							setFechaCompra(fechaCompra);
						}catch(ParseException e){
							System.out.println("Error en el formato de la fecha");
						}
						break;
					}case 9:{//precioCompra
						InputStreamVideoclub.pedirCadena("Nuevo valor para el precio de compra: ");
						String precio = InputStreamVideoclub.cadena;
						setPrecioCompra(Double.parseDouble(precio));
						break;
					}case 10:{//novedad
						InputStreamVideoclub.pedirCadena("Nuevo valor para la opción de novedad (Indicar 1 para cierto y 0 para falso): ");
						String alquilado = InputStreamVideoclub.cadena;
						setAlquilado(alquilado.equals("1"));
						break;
					}case 11:{//localizacion
						InputStreamVideoclub.pedirCadena("Nuevo valor para la localización: ");
						String localizacion = InputStreamVideoclub.cadena;
						setTitulo(localizacion);
						break;
					}case 12:{//codigoBarras
						InputStreamVideoclub.pedirCadena("Nuevo valor para el código de barras: ");
						String codigoBarras = InputStreamVideoclub.cadena;
						setTitulo(codigoBarras);
						break;
					}case 13:{
						InputStreamVideoclub.pedirCadena("Nuevo valor para la opción de alquilable (Indicar 1 para cierto y 0 para falso): ");
						String alquilable = InputStreamVideoclub.cadena;
						setAlquilable(alquilable.equals("1"));
						break;
					}case 14:{
						//Confirmar que los datos finales son los que desea guardar
						Articulos artBbdd = new Articulos();
						int res = artBbdd.editar(this);
						if(res==0){
							mensaje = "Ha ocurrido un error al modificar el artículo";
						}else{
							System.out.println("Modiicación realizada con éxito");
						}
						salir= true; 
						break;
					}default:{
						System.out.println("** Opción incorrecta **");
					}
				}
			}while(!salir);
		}catch(NumberFormatException e){
			System.out.println("Error en el formato de la opción");
			menuModificarPelicula();
		}
		return mensaje;
	}
	
	public String rellenaPeliculaEdicion()
	{
		String mensaje = "";
		try{
			String cadena = "";
			InputStreamVideoclub.pedirCadena(" Introducir título : ");
			cadena = InputStreamVideoclub.cadena;
			setTitulo(cadena);
		
			InputStreamVideoclub.pedirCadena(" Introducir descripción : ");
			cadena = InputStreamVideoclub.cadena;				
			setDescripcion(cadena);
							
			InputStreamVideoclub.pedirCadena(" Introducir precio del alquiler : ");
			cadena = InputStreamVideoclub.cadena;
			setPrecioAlquiler(Double.parseDouble(cadena));
			
			setAlquilado(false);
			
			InputStreamVideoclub.pedirCadena(" Indicar si es alquilable (0 para falso, 1 para cierto): ");
			cadena = InputStreamVideoclub.cadena;
			setAlquilable(cadena.equals("1"));
			
			InputStreamVideoclub.pedirCadena(" Introducir el precio de compra : ");
			cadena = InputStreamVideoclub.cadena;
			setPrecioCompra(Double.parseDouble(cadena));
			boolean error = false;
			do{
				error = false;
				InputStreamVideoclub.pedirCadena(" Introducir la fecha de compra (dd/mm/yyyy) : ");
				cadena = InputStreamVideoclub.cadena;
				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				try{
					setFechaCompra(sdf.parse(cadena));
				}catch(ParseException e){
					System.out.println(e.getMessage());
					error = true;
				}
			}while(error);
			
			InputStreamVideoclub.pedirCadena(" Indicar si es una novedad (0 para falso, 1 para cierto): ");
			cadena = InputStreamVideoclub.cadena;				
			setNovedad(cadena.equals("1"));
			
			InputStreamVideoclub.pedirCadena(" Introducir localización : ");
			cadena = InputStreamVideoclub.cadena;				
			setLocalizacion(cadena);
			
			InputStreamVideoclub.pedirCadena(" Introducir código de barras : ");
			cadena = InputStreamVideoclub.cadena;				
			setCodigoBarras(Long.parseLong(cadena));
			
			Proveedor prov = new Proveedor();
			prov.imprimirProveedores();
			InputStreamVideoclub.pedirCadena("Elija uno de los siguientes proveedores: ");
			cadena = InputStreamVideoclub.cadena;				
			prov.setCodigo(Integer.parseInt(cadena));
			setProveedor(prov);
			
			Soporte soporte = new Soporte();
			soporte.imprimirSoportes();
			InputStreamVideoclub.pedirCadena("Elija uno de los siguientes soportes: ");
			cadena = InputStreamVideoclub.cadena;				
			soporte.setCodigo(Integer.parseInt(cadena));
			setSoporte(soporte);
			
			Categoria categoria = new Categoria();
			categoria.imprimirCategorias();
			InputStreamVideoclub.pedirCadena("Elija una de las siguientes categorías: ");
			cadena = InputStreamVideoclub.cadena;				
			categoria.setCodigo(Integer.parseInt(cadena));
			setCategoria(categoria);
		}catch(NumberFormatException e){
			mensaje = "Ha ocurrido un error al transformar uno de los valores indicados en la inserción";
		}
		return mensaje;
	}
	
	public String insertar(){
		String mensaje = "";
		Articulos art = new Articulos();
		int res = art.insertar(this);
		if(res==0){
			mensaje = "No se ha podido insertar el artículo";
		}else{
			System.out.println("\n******** Artículo insertado *********\n");
		}
		return mensaje;
	}
	
	public String editar(){
		String mensaje = "";
		Articulos art = new Articulos();
		int res = art.editar(this);
		if(res==0){
			mensaje = "No se ha podido modificar el artículo";
		}else{
			System.out.println("\n******** Artículo modificado *********\n");
		}
		return mensaje;
	}
	
	public String modificarActivacion(boolean estado){
		String mensaje = "";
		Articulos art = new Articulos();
		setAlquilable(estado);
		int res = art.modificarActivacion(this);
		if(res==0){
			mensaje = "No se ha podido modificar el estado del artículo";
		}else{
			System.out.println("\n******** Artículo modificado *********\n");
		}
		return mensaje;
	}
}

package articulos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bbdd.Articulos;

import varios.InputStreamVideoclub;
import varios.VideoException;
import varios.Videoclub;
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
	
	public static List<Articulo> listaPeliculas = new ArrayList();
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
	
	public static int buscaArticuloDisponible(int codigo){
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
	}
	
	public static Articulo buscaArticulo(int codigo){
		int i = 0;
		Articulos artbbdd = new Articulos();
		Articulo art = artbbdd.buscarArticuloCodigoBarras(codigo);
		/*for (Articulo articulo : listaPeliculas)
		{
			if (articulo.getCodigoBarras() == codigo)
			{
				//Videoclub.listaUsuarios.indexOf(us);
				return i; // devuelve la posicion en que se encuentra el cliente dentro de la lista
			}
			i++;
		}*/
		
		return art;
	}
	
	public static int identificarPeliculaDisponible(){
		InputStreamVideoclub.pedirCadena("Introduzca el código de barras de la película o 0 para volver al menú anterior: ");
		String cadena = InputStreamVideoclub.cadena;
		int codigo;
		try{
			codigo = Integer.parseInt(cadena);
			switch(codigo){
				case 0: Videoclub.mostrarMenuPrincipal();break;
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
	}
	
	public static Articulo identificarPelicula(){
		InputStreamVideoclub.pedirCadena("Introduzca el código de barras de la película o 0 para volver al menú anterior: ");
		String cadena = InputStreamVideoclub.cadena;
		Articulo art = null;
		int codigo;
		try{
			codigo = Integer.parseInt(cadena);
			switch(codigo){
				case 0: Videoclub.mostrarMenuPrincipal();break;
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
}

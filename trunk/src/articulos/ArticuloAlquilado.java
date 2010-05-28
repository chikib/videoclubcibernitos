package articulos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bbdd.Articulos;
import usuario.Usuario;

public class ArticuloAlquilado {
	private int codigo;
	private Articulo articulo;
	private Date fechaAlquiler;
	private Date fechaDevolucion;
	private Usuario cliente;
	private String observaciones;
	private int recargo;
	private int precio;
	private int tiempo;
	
	public static List<ArticuloAlquilado> listaPeliculasAlquiladas = new ArrayList();
	
	public ArticuloAlquilado(){
		
	}
	
	public ArticuloAlquilado(Usuario usuario, Articulo articulo){
		this.cliente = usuario;
		this.articulo = articulo;
	}
	
	public ArticuloAlquilado(int codigo,Articulo articulo,Date fechaAlquiler,Date fechaDevolucion,Usuario cliente,String observaciones,
			int recargo,int precio,int tiempo){
		this.codigo = codigo;
		this.articulo = articulo;
		this.fechaAlquiler = fechaAlquiler;
		this.fechaDevolucion = fechaDevolucion;
		this.cliente = cliente;
		this.observaciones = observaciones;
		this.recargo = recargo;
		this.precio = precio;
		this.tiempo = tiempo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}
	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	public Usuario getCliente() {
		return cliente;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setRecargo(int recargo) {
		this.recargo = recargo;
	}
	public int getRecargo() {
		return recargo;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getPrecio() {
		return precio;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public int getTiempo() {
		return tiempo;
	}
	
	public static void alquilar(){
		//Identifico al usuario
		Usuario usuario = Usuario.identificarUsuario();
		if(usuario!=null){
			//Identifico la pel�cula
			Articulo articulo = Articulo.identificarPelicula();
			//Articulo articulo = Articulo.listaPeliculas.get(posArticulo);
			int recargo = 0;
			int tiempo = 0;
			if(articulo.isNovedad()){
				recargo = articulo.getCategoria().getRecargoNovedad();
				tiempo = articulo.getCategoria().getTiempoAlquilerNovedad();
			}else{
				recargo = articulo.getCategoria().getRecargoBase();
				tiempo = articulo.getCategoria().getTiempoAlquiler();
			}
			//listaPeliculasAlquiladas.add(new ArticuloAlquilado(ArticuloAlquilado.generarCodigo(), articulo, new Date(),null , 
			//		usuario, "", recargo, articulo.getPrecioAlquiler(), tiempo));
			articulo.setAlquilado(true);
			//Articulo.listaPeliculas.set(posArticulo, articulo);
			
			System.out.println("*** Art�culo alquilado ***");
			
		}
	}
	
	
	public static void gestionDevolver(){
		//Identifico al usuario
		Usuario usuario = Usuario.identificarUsuario();
		if(usuario!=null){
			//Identifico la pel�cula
			/*this. = Articulo.identificarPelicula();
			
			//Articulo articulo = Articulo.listaPeliculas.get(posArticulo);
			//ArticuloAlquilado articuloDev = buscar(usuario, articulo);
			art.setAlquilado(false);
			articuloDev.setFechaDevolucion(new Date());
			Articulo.listaPeliculas.set(posArticulo, articulo);
			System.out.println("*** Art�culo devuelto ***");*/
			Articulo articulo = Articulo.identificarPelicula();
			articulo.setAlquilado(false);
			Articulos artBbdd = new Articulos();
			//artBbdd.guardar(articulo);
			ArticuloAlquilado articuloDev = new ArticuloAlquilado();
			articuloDev.setFechaDevolucion(new Date());
			
			System.out.println("*** Art�culo devuelto ***");
		}
	}
	
	public static int generarCodigo(){
		if(listaPeliculasAlquiladas.size()>0){
			return listaPeliculasAlquiladas.get(listaPeliculasAlquiladas.size()-1).getCodigo()+1;
		}
		return 1;
	}
	
	public static ArticuloAlquilado buscar(Usuario usuario, Articulo articulo){
		for(ArticuloAlquilado artAlq: listaPeliculasAlquiladas){
			if(artAlq.getArticulo().equals(articulo) && artAlq.getCliente().equals(usuario)){
				return artAlq;
			}
		}
		return null;
	}
}

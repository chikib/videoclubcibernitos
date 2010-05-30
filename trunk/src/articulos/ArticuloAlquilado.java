package articulos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import facturas.Albaran;
import facturas.Factura;
import facturas.LineaAlbaran;
import facturas.LineaFactura;

import bbdd.Articulos;
import bbdd.ArticulosAlquilados;
import bbdd.Categorias;
import usuario.Usuario;

public class ArticuloAlquilado {
	private int codigo;
	private Articulo articulo;
	private Date fechaAlquiler;
	private Date fechaDevolucion;
	private Usuario cliente;
	private String observaciones;
	private int recargo;
	private double precio;
	private int tiempo;
	
	public ArticuloAlquilado(){
		this.articulo = new Articulo();
		this.cliente = new Usuario();
	}
	
	public ArticuloAlquilado(Usuario usuario, Articulo articulo){
		this.cliente = usuario;
		this.articulo = articulo;
	}
	
	public ArticuloAlquilado(int codigo,Articulo articulo,Date fechaAlquiler,Date fechaDevolucion,Usuario cliente,String observaciones,
			int recargo,double precio,int tiempo){
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
	
	public ArticuloAlquilado(Articulo articulo,Date fechaAlquiler,Date fechaDevolucion,Usuario cliente,String observaciones,
			int recargo,double precio,int tiempo){
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
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPrecio() {
		return precio;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public int getTiempo() {
		return tiempo;
	}
	
	public static List alquilar(int cantidad){
		String mensaje = "";
		List listaMensajes = new ArrayList();
		//Identifico al usuario
		Usuario usuario = Usuario.identificarUsuario();
		//Creo el albar�n
		Albaran albaran = new Albaran(0,0,new Date(),usuario,false);
		//Identifico la pel�cula
		if(usuario!=null){
			for(int i=0;i!=cantidad;i++){
				Articulo articulo = Articulo.identificarPelicula();
				if(articulo!=null && !articulo.isAlquilado() && articulo.isAlquilable()){
					int recargo = 0;
					int tiempo = 0;
					//Recupero la categor�a de base de datos
					Categorias categoriaBbdd = new Categorias();
					Categoria cat = categoriaBbdd.buscarCategoriaCodigo(articulo.getCategoria().getCodigo());
					if(cat!=null){
						articulo.setCategoria(cat);
						if(articulo.isNovedad()){
							recargo = cat.getRecargoNovedad();
							tiempo = cat.getTiempoAlquilerNovedad();
						}else{
							recargo = cat.getRecargoBase();
							tiempo = cat.getTiempoAlquiler();
						}
						//Creo una relaci�n entre el art�culo y el cliente
						ArticuloAlquilado artAlq = new ArticuloAlquilado(articulo,new Date(),null,usuario,"",recargo,articulo.getPrecioAlquiler(),tiempo);
						ArticulosAlquilados artAlqBbdd = new ArticulosAlquilados();
						//Guardar cambio en bbdd
						Articulos artBbdd = new Articulos();
						//Establezco que el art�culo est� alquilado
						articulo.setAlquilado(true);
						if(artBbdd.setArticuloAlquilado(articulo)==1){
							if(artAlqBbdd.insertar(artAlq)==1){
								albaran.setPrecioTotal(albaran.getPrecioTotal()+artAlq.getPrecio());
								//crear la l�nea de albar�n
								LineaAlbaran linea = new LineaAlbaran(0, artAlq.getPrecio(), artAlq, albaran);
								mensaje = linea.guardar();
								if(mensaje.equals("")){
									System.out.println("*** Art�culo alquilado ***\n");
								}else{
									listaMensajes.add(mensaje);
								}
							}else{
								//Si la inserci�n en articulos alquilados da error doy marcha atr�s en que el art�culo est� alquilado
								articulo.setAlquilado(false);
								artBbdd.setArticuloAlquilado(articulo);
								listaMensajes.add("Ha ocurrido un error al asignar el art�culo al cliente");
							}
						}else{
							listaMensajes.add("Ha habido un problema al establecer que el art�culo ha sido alquilado");
						}
					}else{
						listaMensajes.add("Ha habido un problema al identificar la categor�a del art�culo");
					}
				}else{
					listaMensajes.add("El art�culo no existe o ya est� alquilado");
				}
			}
			//Guardar en bbdd el albar�n
		}else{
			listaMensajes.add("Ha habido un error al identificar el usuario");
		}
		return listaMensajes;
	}
	
	public static List gestionDevolver(int cantidad){
		String mensaje = "";
		//Identifico al usuario
		Usuario usuario = Usuario.identificarUsuario();
		List listaMensajes = new ArrayList();
		if(usuario!=null){
			Factura factura = new Factura(0,0,new Date(),usuario);
			//Devuelvo cada art�culo
			for(int i=0;i!=cantidad;i++){
				//Identifico la pel�cula
				Articulo articulo = Articulo.identificarPelicula();
				if(articulo!=null && articulo.isAlquilado()){
					//Identifico el art�culo alquilado en base de datos
					ArticulosAlquilados artDevBbdd = new ArticulosAlquilados();
					ArticuloAlquilado articuloDev = new ArticuloAlquilado();
					articuloDev = artDevBbdd.consultaArtAlqCodigo(usuario.getCodigo(),articulo.getCodigo());
					if(articuloDev!=null){
						articuloDev.setArticulo(articulo);
						articuloDev.setCliente(usuario);
						articulo.setAlquilado(false);
						Articulos artBbdd = new Articulos();
						//Cambio el atributo alquilado a falso
						if(artBbdd.setArticuloAlquilado(articulo)==1){
							//Actualizo la fecha de devoluci�n
							articuloDev.setFechaDevolucion(new Date());
							if(artDevBbdd.actualizarFechaDevolucion(articuloDev)==1){
								//Creo la factura y calculo si hay recargo
								Date fechaAlquiler = articuloDev.fechaAlquiler;
								int tiempoAlquiler = articuloDev.tiempo;
								int recargo=articuloDev.getRecargo();
								double precio = articuloDev.getPrecio();
								GregorianCalendar gc = new GregorianCalendar();
								gc.setTime(fechaAlquiler);
								gc.add(Calendar.DAY_OF_YEAR, tiempoAlquiler);
								if(new Date().after(gc.getTime())){
									precio += precio*(recargo/100);
								}
								factura.setPrecioTotal(factura.getPrecioTotal()+precio);
								//Creo la l�nea de la factura para este art�culo
								LineaFactura linea = new LineaFactura(0, precio, articuloDev, factura, recargo);
								mensaje = linea.guardar();
								if(mensaje.equals("")){
									System.out.println("*** Art�culo devuelto ***");
								}else{
									listaMensajes.add(mensaje);
								}
								
							}else{
								articulo.setAlquilado(true);
								artBbdd.setArticuloAlquilado(articulo);
								listaMensajes.add("Se ha producido un error al establecer la fecha de devoluci�n");
							}
						}else{
							listaMensajes.add("Se ha producido un error al establecer que el art�culo ha sido alquilado");
						}
					}else{
						listaMensajes.add("El cliente indicado no tiene ese art�culo alquilado");
					}
				}else{
					listaMensajes.add("El art�culo no existe o no est� alquilado");
				}
			}
			//Guardar en bbdd la factura
		}else{
			listaMensajes.add("El usuario no ha sido encontrado");
		}
		return listaMensajes;
	}
	
	/*public static int generarCodigo(){
		if(listaPeliculasAlquiladas.size()>0){
			return listaPeliculasAlquiladas.get(listaPeliculasAlquiladas.size()-1).getCodigo()+1;
		}
		return 1;
	}*/
	
	/*public static ArticuloAlquilado buscar(Usuario usuario, Articulo articulo){
		for(ArticuloAlquilado artAlq: listaPeliculasAlquiladas){
			if(artAlq.getArticulo().equals(articulo) && artAlq.getCliente().equals(usuario)){
				return artAlq;
			}
		}
		return null;
	}*/
}

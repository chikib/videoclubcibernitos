package articulos;
import java.util.Date;
public class Articulo {
	private int codigo;
	private long codigoBarras;
	private String titulo;
	private String descripcion;
	private Categoria categoria;
	private Soporte soporte;
	private Proveedor proveedor;
	private int precioAlquiler;
	private boolean alquilado;
	private Date fechaCompra;
	private int precioCompra;
	private boolean novedad;
	private String localizacion;
	private boolean alquilable;
	
	public Articulo(int codigo,long codigoBarras,String titulo,String descripcion,Categoria categoria,Soporte soporte,Proveedor proveedor,
			int precioAlquiler,boolean alquilado,Date fechaCompra,int precioCompra,boolean novedad,String localizacion,boolean alquilable){
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
	public void setPrecioAlquiler(int precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	public int getPrecioAlquiler() {
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
	public void setPrecioCompra(int precioCompra) {
		this.precioCompra = precioCompra;
	}
	public int getPrecioCompra() {
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
	
}

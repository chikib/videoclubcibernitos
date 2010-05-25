package linea;
import articulos.ArticuloAlquilado;;

public class Linea {

	private int codigo;
	private int precio;
	private ArticuloAlquilado articulo;
	
	
	// set y get
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public ArticuloAlquilado getArticulo() {
		return articulo;
	}
	public void setArticulo(ArticuloAlquilado articulo) {
		this.articulo = articulo;
	}
	
}

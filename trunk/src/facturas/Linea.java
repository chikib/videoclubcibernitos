package facturas;

import articulos.ArticuloAlquilado;

public class Linea {
	private int codigo;
	private ArticuloAlquilado artAlq;
	private double precio;
	
	public Linea(){
		
	}
	
	public Linea(int codigo,double precio,ArticuloAlquilado artAlq){
		this.codigo = codigo;
		this.precio = precio;
		this.artAlq = artAlq;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setArtAlq(ArticuloAlquilado artAlq) {
		this.artAlq = artAlq;
	}
	public ArticuloAlquilado getArtAlq() {
		return artAlq;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPrecio() {
		return precio;
	}
}

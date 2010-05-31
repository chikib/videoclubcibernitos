package facturas;
import bbdd.LineasFactura;
import articulos.ArticuloAlquilado;
public class LineaFactura extends Linea{
	private Factura factura;
	private int recargo;
	public LineaFactura(){
		
	}
	
	public LineaFactura(int codigo, double precio, ArticuloAlquilado artAlq,Factura factura, int recargo){
		super (codigo,precio,artAlq);
		this.factura = factura;
		this.setRecargo(recargo);
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setRecargo(int recargo) {
		this.recargo = recargo;
	}

	public int getRecargo() {
		return recargo;
	}	
	
	public String guardar(){
		String mensaje = "";
		LineasFactura art = new LineasFactura();
		int res = art.insertar(this);
		if(res==0){
			mensaje = "No se ha podido insertar el artículo";
		}else{
			System.out.println("\n******** Artículo insertado *********\n");
		}
		return mensaje;
	}
}
	

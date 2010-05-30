package facturas;
import articulos.ArticuloAlquilado;
public class LineaAlbaran extends Linea {
	private Albaran albaran;
	public LineaAlbaran(int codigo,double precio, ArticuloAlquilado artAlq, Albaran albaran){
		super(codigo,precio,artAlq);
		this.setAlbaran(albaran);
	}
	
	public LineaAlbaran(){
		
	}

	public void setAlbaran(Albaran albaran) {
		this.albaran = albaran;
	}

	public Albaran getAlbaran() {
		return albaran;
	}
	
	public String guardar(){
		return "";
	}
}

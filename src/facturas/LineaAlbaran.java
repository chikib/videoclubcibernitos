package facturas;
import bbdd.LineasAlbaran;
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
		String mensaje = "";
		LineasAlbaran lf = new LineasAlbaran();
		int res = lf.insertar(this);
		if(res==0){
			mensaje = "No se ha podido insertar el artículo";
		}else{
			System.out.println("\n******** Artículo insertado *********\n");
		}
		return mensaje;
	}
}

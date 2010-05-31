package bbdd;
import facturas.LineaFactura;

public class LineasFactura {
	
	public int insertar(LineaFactura lf){
		Conexion con = new Conexion();
		int res = con.insertarUpdate("insert into lineasFactura(articuloAlquilado,precio,factura,recargo) " +
				"values("+lf.getArtAlq().getCodigo()+","+lf.getPrecio()+","+lf.getFactura().getCodigo()+" " +
				","+lf.getRecargo()+")");
		con.cerrarConexion();
		return res;
	}	
}

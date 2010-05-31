package bbdd;

import facturas.LineaAlbaran;

public class LineasAlbaran {
	
	public int insertar(LineaAlbaran lf){
		Conexion con = new Conexion();		
		int res = con.insertarUpdate("insert into lineasAlbaran(codigo,articuloAlquilado,albaran,precio) " +
				"values("+lf.getCodigo()+","+lf.getArtAlq().getCodigo()+","+lf.getAlbaran().getCodigo()+"," +
				" "+lf.getPrecio()+")");
		con.cerrarConexion();
		return res;
	}	
}

package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import articulos.ArticuloAlquilado;
import facturas.Albaran;
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
	
	public LineaAlbaran consultarLineaAlbaran(int codigo){
		Conexion con = new Conexion();
		LineaAlbaran la = null;
		try{
			ResultSet rs = con.consulta("select codigo, articuloAlquilado,albaran,precio from" +
					"lineasFactura where codigo = "+codigo);
			if(rs.next()){
				la = new LineaAlbaran();
				la.setCodigo(rs.getInt("codigo"));
				ArticuloAlquilado artAlq = new ArticuloAlquilado();
				artAlq.setCodigo(rs.getInt("articuloAlquilado"));
				la.setArtAlq(artAlq);
				Albaran albaran = new Albaran();
				albaran.setCodigo(rs.getInt("albaran"));
				la.setAlbaran(albaran);
				la.setPrecio(rs.getInt("precio"));
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			con.cerrarConexion();
		}
		return la;
	}
	
	public List<LineaAlbaran> consultarLineaAlbaranPorAlbaran(int codAlbaran){
		Conexion con = new Conexion();
		List<LineaAlbaran> listaLineas = new ArrayList<LineaAlbaran>();
		LineaAlbaran la = null;
		try{
			ResultSet rs = con.consulta("select codigo, articuloAlquilado,albaran,precio from" +
					"lineasFactura where albaran = "+codAlbaran);
			while(rs.next()){
				la = new LineaAlbaran();
				la.setCodigo(rs.getInt("codigo"));
				ArticuloAlquilado artAlq = new ArticuloAlquilado();
				artAlq.setCodigo(rs.getInt("articuloAlquilado"));
				la.setArtAlq(artAlq);
				Albaran albaran = new Albaran();
				albaran.setCodigo(rs.getInt("albaran"));
				la.setAlbaran(albaran);
				la.setPrecio(rs.getInt("precio"));
				listaLineas.add(la);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			con.cerrarConexion();
		}
		return listaLineas;
	}
}

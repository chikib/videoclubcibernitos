package bbdd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import articulos.ArticuloAlquilado;
import facturas.Factura;
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
	
	public LineaFactura consultarLineaFactura(int codigo){
		Conexion con = new Conexion();
		LineaFactura lf = null;
		try{
			ResultSet rs = con.consulta("select codigo,articuloAlquilado,factura,precio,recargo from " +
					"lineasFactura where codigo = "+codigo);
			if(rs.next()){
				lf = new LineaFactura();
				lf.setCodigo(rs.getInt("codigo"));
				ArticuloAlquilado artAlq = new ArticuloAlquilado();
				artAlq.setCodigo(rs.getInt("articuloAlquilado"));
				lf.setArtAlq(artAlq);
				Factura factura = new Factura();
				factura.setCodigo(rs.getInt("factura"));
				lf.setFactura(factura);
				lf.setPrecio(rs.getInt("precio"));
				lf.setRecargo(rs.getInt("recargo"));
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return lf;
	}
	
	public List<LineaFactura> consultarLineaFacturaPorFactura(int codFactura){
		Conexion con = new Conexion();
		List<LineaFactura> listaLineas = new ArrayList<LineaFactura>();
		LineaFactura lf = null;
		try{
			ResultSet rs = con.consulta("select codigo,articuloAlquilado,factura,precio,recargo from " +
					"lineasFactura where codigo = "+codFactura);
			while(rs.next()){
				lf = new LineaFactura();
				lf.setCodigo(rs.getInt("codigo"));
				ArticuloAlquilado artAlq = new ArticuloAlquilado();
				artAlq.setCodigo(rs.getInt("articuloAlquilado"));
				lf.setArtAlq(artAlq);
				Factura factura = new Factura();
				factura.setCodigo(rs.getInt("factura"));
				lf.setFactura(factura);
				lf.setPrecio(rs.getInt("precio"));
				lf.setRecargo(rs.getInt("recargo"));
				listaLineas.add(lf);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return listaLineas;
	}
}

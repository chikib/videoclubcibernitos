package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import articulos.Articulo;
import articulos.Categoria;
import articulos.Proveedor;
import articulos.Soporte;

public class Articulos {
	
	public Articulo buscarArticuloCodigoBarras(int codigo){
		Articulo art = null;
		Conexion con = new Conexion();
		StringBuilder stb = new StringBuilder("SELECT codigo, titulo, codigoBarras,precio,descripcion," +
				"categoria,soporte,proveedor,alquilado,fechaCompra,precioCompra,novedad,localizacion " +
				"from articulos WHERE codigoBarras = "+codigo);
		try{
			ResultSet res = con.consulta(stb.toString());
			if(res.next()){
				art = new Articulo();
				art.setCodigo(res.getInt("codigo"));
				art.setTitulo(res.getString("titulo"));
				art.setCodigoBarras(res.getLong("codigoBarras"));
				art.setPrecioAlquiler(res.getDouble("precio"));
				art.setDescripcion(res.getString("descripcion"));
				
				Categoria cat = new Categoria();
				cat.setCodigo(res.getInt("categoria"));
				art.setCategoria(cat);
				Soporte soporte = new Soporte();
				soporte.setCodigo(res.getInt("soporte"));
				Proveedor prov = new Proveedor();
				prov.setCodigo(res.getInt("proveedor"));
				art.setAlquilado(res.getBoolean("alquilado"));
				art.setFechaCompra(res.getDate("fechaCompra"));
				art.setPrecioCompra(res.getDouble("precioCompra"));
				art.setNovedad(res.getBoolean("novedad"));
				art.setLocalizacion(res.getString("localizacion"));
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println(e.getMessage());
		}
		finally{
			con.cerrarConexion();
		}
		return art;
	}
}

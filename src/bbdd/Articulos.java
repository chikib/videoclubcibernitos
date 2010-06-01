package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import articulos.Articulo;
import articulos.Categoria;
import articulos.Proveedor;
import articulos.Soporte;

public class Articulos {
	
	public Articulo buscarArticuloCodigoBarras(int codigo){
		Articulo art = null;
		Conexion con = new Conexion();
		StringBuilder stb = new StringBuilder("SELECT codigo, titulo, codigoBarras,precio,descripcion," +
				"categoria,soporte,proveedor,alquilado,fechaCompra,precioCompra,novedad,localizacion,alquilable " +
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
				art.setSoporte(soporte);
				Proveedor prov = new Proveedor();
				prov.setCodigo(res.getInt("proveedor"));
				art.setProveedor(prov);
				art.setAlquilado(res.getBoolean("alquilado"));
				art.setFechaCompra(res.getDate("fechaCompra"));
				art.setPrecioCompra(res.getDouble("precioCompra"));
				art.setNovedad(res.getBoolean("novedad"));
				art.setLocalizacion(res.getString("localizacion"));
				art.setAlquilable(res.getBoolean("alquilable"));
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
	
	public List buscarArticuloNombre(String nombre){
		Articulo art = null;
		List<Articulo> listaPeliculas = new ArrayList<Articulo>();
		Conexion con = new Conexion();
		StringBuilder stb = new StringBuilder("SELECT codigo, titulo, codigoBarras,precio,descripcion," +
				"categoria,soporte,proveedor,alquilado,fechaCompra,precioCompra,novedad,localizacion,alquilable " +
				"from articulos WHERE upper(titulo) like '%"+nombre.toUpperCase()+"%'");
		try{
			ResultSet res = con.consulta(stb.toString());
			while(res.next()){
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
				art.setSoporte(soporte);
				Proveedor prov = new Proveedor();
				prov.setCodigo(res.getInt("proveedor"));
				art.setProveedor(prov);
				art.setAlquilado(res.getBoolean("alquilado"));
				art.setFechaCompra(res.getDate("fechaCompra"));
				art.setPrecioCompra(res.getDouble("precioCompra"));
				art.setNovedad(res.getBoolean("novedad"));
				art.setLocalizacion(res.getString("localizacion"));
				art.setAlquilable(res.getBoolean("alquilable"));
				listaPeliculas.add(art);
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
		return listaPeliculas;
	}
	
	public int setArticuloAlquilado(Articulo articulo){
		Conexion con = new Conexion();
		int res = con.insertarUpdate("update articulos set alquilado = "+articulo.isAlquilado()+" where codigo = "+articulo.getCodigo());
		con.cerrarConexion();
		return res;
	}
	
	
	public int insertar(Articulo art){
		Conexion con = new Conexion();
		String alquilable = "0";
		if(art.isAlquilable()){
			alquilable = "1";
		}
		String novedad = "0";
		if(art.isNovedad()){
			novedad = "1";
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		int res = con.insertarUpdate("insert into articulos (titulo,descripcion,codigoBarras,precio,categoria,soporte,proveedor,alquilado," +
				"fechaCompra,precioCompra,novedad,localizacion,alquilable) values ('"+art.getTitulo()+"','"+art.getDescripcion()+"'" +
				","+art.getCodigoBarras()+","+art.getPrecioAlquiler()+","+art.getCategoria().getCodigo()+","+art.getSoporte().getCodigo()+"" +
				","+art.getProveedor().getCodigo()+",1,'"+df.format(art.getFechaCompra())+"',"+art.getPrecioCompra()+","+novedad+",'"+art.getLocalizacion()+"'" +
				","+alquilable+")");
		con.cerrarConexion();
		return res;
	}
	
	public int editar(Articulo art){
		Conexion con = new Conexion();
		String alquilable = "0";
		if(art.isAlquilable()){
			alquilable = "1";
		}
		String novedad = "0";
		if(art.isNovedad()){
			novedad = "1";
		}
		String alquilado = "0";
		if(art.isAlquilado()){
			alquilado = "1";
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		int res = con.insertarUpdate("update articulos set titulo = '"+art.getTitulo()+"', descripcion='"+art.getDescripcion()+"', " +
				"codigoBarras='"+art.getCodigoBarras()+"', precio="+art.getPrecioAlquiler()+", categoria = "+art.getCategoria().getCodigo()+"," +
				"soporte= "+art.getSoporte().getCodigo()+", proveedor="+art.getProveedor().getCodigo()+", alquilado="+alquilado+"," +
				"fechaCompra='"+df.format(art.getFechaCompra())+"', novedad="+novedad+", localizacion='"+art.getLocalizacion()+"', alquilable="+alquilable+" " +
				" where codigo = "+art.getCodigo());
		con.cerrarConexion();
		return res;
	}
	
	public int modificarActivacion(Articulo art){
		Conexion con = new Conexion();
		String alquilable = "0";
		if(art.isAlquilable()){
			alquilable = "1";
		}
		int res = con.insertarUpdate("update articulos set alquilable = "+alquilable+" where codigo = "+art.getCodigo());
		con.cerrarConexion();
		return res;
	}	
}

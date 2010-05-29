package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import articulos.Categoria;
import articulos.Soporte;

public class Categorias {
	
	public Categoria buscarCategoriaCodigo(int codigo){
		Categoria cat = null;
		Conexion con = new Conexion();
		StringBuilder stb = new StringBuilder("select codigo,tematica,recargoBase,recargoNovedad,tiempoAlquiler," +
				"tiempoAlquilerNovedad from categorias where codigo="+codigo);
		ResultSet res = con.consulta(stb.toString());
		try{
			if(res.next()){
				cat = new Categoria();
				cat.setCodigo(res.getInt("codigo"));
				cat.setTematica(res.getString("tematica"));
				cat.setRecargoBase(res.getInt("recargoBase"));
				cat.setRecargoNovedad(res.getInt("recargoNovedad"));
				cat.setTiempoAlquiler(res.getInt("tiempoAlquiler"));
				cat.setTiempoAlquilerNovedad(res.getInt("tiempoAlquilerNovedad"));
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			con.cerrarConexion();
		}
		return cat;
	}
	
	public List getCategorias(){
		Categoria categoria = null;
		List listaCategorias = new ArrayList();
		Conexion con = new Conexion();
		StringBuilder stb = new StringBuilder("select codigo,tematica from categorias order by tematica");
		try{
			ResultSet res = con.consulta(stb.toString());
			while(res.next()){
				categoria = new Categoria();
				categoria.setCodigo(res.getInt("codigo"));
				categoria.setTematica(res.getString("tematica"));
				listaCategorias.add(categoria);
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
		return listaCategorias; 
	}
}

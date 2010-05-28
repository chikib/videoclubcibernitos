package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import articulos.Categoria;

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
}

package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import articulos.Soporte;

public class Soportes {
	
	public List getSoportes(){
		Soporte soporte = null;
		List listaSoportes = new ArrayList();
		Conexion con = new Conexion();
		StringBuilder stb = new StringBuilder("select codigo,tipo from soportes order by tipo");
		try{
			ResultSet res = con.consulta(stb.toString());
			while(res.next()){
				soporte = new Soporte();
				soporte.setCodigo(res.getInt("codigo"));
				soporte.setTipo(res.getString("tipo"));
				listaSoportes.add(soporte);
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
		return listaSoportes;
	}
	
	
}

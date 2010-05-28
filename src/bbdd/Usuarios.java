package bbdd;
import java.sql.ResultSet;
import java.sql.SQLException;

import usuario.Usuario;

public class Usuarios {
	public Usuario buscarUsuario(int codigo){
		Conexion con = new Conexion();
		Usuario usu = new Usuario();
		StringBuilder stb = new StringBuilder("SELECT codigo, nombre, apellidos FROM CLIENTES " +
				"WHERE codigo = "+codigo);
		ResultSet res = con.consulta(stb.toString());
		try{
			if(res.next())
			{
				usu.setCodigo(res.getInt("codigo"));
				usu.setNombre(res.getString("nombre"));
				usu.setApellidos(res.getString("apellidos"));
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		return null;
	}
}

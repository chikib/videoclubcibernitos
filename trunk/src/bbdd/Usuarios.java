package bbdd;
import java.sql.ResultSet;
import java.sql.SQLException;

import usuario.Usuario;

public class Usuarios {
	public Usuario buscarUsuario(int codigo){
		Conexion con = new Conexion();
		Usuario usu = null;
		StringBuilder stb = new StringBuilder("SELECT codigo, nombre, apellidos FROM clientes " +
				"WHERE codigo = "+codigo);
		System.out.println(stb.toString());
		ResultSet res = con.consulta(stb.toString());
		try{
			if(res.next())
			{
				usu = new Usuario();
				usu.setCodigo(res.getInt("codigo"));
				usu.setNombre(res.getString("nombre"));
				usu.setApellidos(res.getString("apellidos"));
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		return usu;
	}
}

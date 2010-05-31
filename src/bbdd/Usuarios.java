package bbdd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import usuario.Usuario;

public class Usuarios {
	public Usuario buscarUsuario(int codigo){
		Conexion con = new Conexion();
		Usuario usu = null;
		StringBuilder stb = new StringBuilder("SELECT codigo, nombre, apellidos,dni,direccion,telefono,bloqueado,activo FROM clientes " +
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
				usu.setDni(res.getString("dni"));
				usu.setDireccion(res.getString("direccion"));
				usu.setTelefono(res.getString("telefono"));
				usu.setBloqueado(res.getBoolean("bloqueado"));
				usu.setActivo(res.getBoolean("activo"));
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return usu;
	}
	
	public List<Usuario> buscarUsuarioDatos(String nombre, String apellidos, String dni){
		Conexion con = new Conexion();
		List<Usuario> resultado = new ArrayList<Usuario>();
		ResultSet res = con.consulta("select codigo, nombre, apellidos, dni, direccion,telefono,bloqueado,activo from clientes where upper(nombre) " +
		"like '%" + nombre.toUpperCase() + "%' and upper(apellidos) like '%" + apellidos.toUpperCase() + "%' and upper(dni) " +
				"like '%" + dni.toUpperCase() + "%'");
		Usuario usu = new Usuario();
		try{
			while(res.next()){
				usu = new Usuario();
				usu.setCodigo(res.getInt("codigo"));
				usu.setNombre(res.getString("nombre"));
				usu.setApellidos(res.getString("apellidos"));
				usu.setDni(res.getString("dni"));
				usu.setDireccion(res.getString("direccion"));
				usu.setTelefono(res.getString("telefono"));
				usu.setBloqueado(res.getBoolean("bloqueado"));
				usu.setActivo(res.getBoolean("activo"));
				resultado.add(usu);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			con.cerrarConexion();
		}
		return resultado;
	}
	
	public int insertar(Usuario usu){
		Conexion con = new Conexion();
		String bloqueado = "0";
		if(usu.isBloqueado()){
			bloqueado = "1";
		}
		
		String activo = "0";
		if(usu.isActivo()){
			activo = "1";
		}
		
		int res = con.insertarUpdate("insert into clientes (nombre,apellidos,dni,direccion,telefono,bloqueado,activo) values" +
				" ('"+usu.getNombre()+"','"+usu.getApellidos()+"','"+usu.getDni()+"','"+usu.getDireccion()+"','"+usu.getTelefono()+"'" +
						", "+bloqueado+","+activo+")");
		
		con.cerrarConexion();
		return res;
	}
	
	public int modificar(Usuario oUsu){
		Conexion con = new Conexion();
		String bloqueado = "0";
		if(oUsu.isBloqueado()){
			bloqueado = "1";
		}
		
		String activo = "0";
		if(oUsu.isActivo()){
			activo = "1";
		}
		int res = con.insertarUpdate("update clientes set nombre = '" + oUsu.getNombre() + "',apellidos = '" + oUsu.getApellidos() + 
			 "', dni = '" + oUsu.getDni() + "', direccion = '" + oUsu.getDireccion() + "', telefono = '" + 
			 oUsu.getTelefono()+ "', bloqueado = "+bloqueado+", activo="+activo+
			 " where codigo = "+oUsu.getCodigo());
		con.cerrarConexion();
		return res;
	}
}

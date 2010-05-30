package bbdd;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import usuario.Usuario;
import facturas.*;


public class Albaranes {
	Conexion con = new Conexion();
	Usuario miUsuario = new Usuario();
	public Albaran buscarAlbaran(int codigo){
		Albaran al = null;
		
		StringBuilder stb = new StringBuilder("SELECT codigo, precioTotal, fecha, cliente, cancelado " +
				"FROM albaranes WHERE codigo = " + codigo);
		
		try{
			ResultSet res = con.consulta(stb.toString());
			if(res.next()){
				al = new Albaran();
				al.setCodigo(res.getInt("codigo"));
				al.setPrecioTotal(res.getDouble("precioTotal"));
				al.setFecha(res.getDate("fecha"));
				Usuario usu = new Usuario();
				usu.setCodigo(res.getInt("cliente"));
				al.setCliente(usu);
				al.setCancelado(res.getBoolean("cancelado"));
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
		
		return al;
	}
	
	public int crearAlbaran(int cod, double preTota, Date fech, Usuario clie, boolean canc){
		String cancelado = "0";
		if(canc){
			cancelado = "1";
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder stb = new StringBuilder("INSERT INTO albaranes(codigo, precioTotal, fecha, cliente, cancelado)" +
				"VALUES ("+cod+", preTota, '"+df.format(fech)+"', "+clie.getCodigo()+", "+cancelado+")");
		int res= con.insertarUpdate(stb.toString());
		con.cerrarConexion();
		return res;
	}
}

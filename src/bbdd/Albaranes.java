package bbdd;
import java.sql.*;

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
				//al.setCliente(res.getInt("cliente"));
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
	
	public void crearAlbaran(int cod, double preTota, Date fech, Usuario clie, boolean canc){
		StringBuilder stb = new StringBuilder("INSERT INTO albaranes(codigo, precioTotal, fecha, cliente, cancelado)" +
				"VALUES (cod, preTota, fech, clie, canc)");
		try{
			con.consulta(stb.toString());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			con.cerrarConexion();
		}		
	}
}

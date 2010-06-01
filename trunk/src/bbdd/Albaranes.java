package bbdd;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import usuario.Usuario;
import facturas.*;

public class Albaranes {
	
	public int insertarAlbaran(Albaran al){
		Conexion con = new Conexion();
		String cancelado = "0";
		if(al.isCancelado()){
			cancelado = "1";
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int res = con.insertarUpdate("INSERT INTO albaranes(codigo, precioTotal, fecha, cliente, cancelado)" +
				"VALUES ("+al.getCodigo()+","+al.getPrecioTotal()+",'"+df.format(al.getFecha())+"',"+al.getCliente().getCodigo()+","+cancelado+")");
		
		con.cerrarConexion();
		return res;
	}
	
	public Albaran buscarAlbaranDatos(int codigo){
		Albaran al = null;
		Conexion con = new Conexion();
		ResultSet res = con.consulta("SELECT codigo, precioTotal, fecha, cliente, cancelado " +
				"FROM albaranes WHERE codigo = " + codigo);

			
		try{
			if(res.next()){
				al = new Albaran();
				al.setCodigo(res.getInt("codigo"));
				al.setPrecioTotal(res.getDouble("precioTotal"));
				al.setFecha(res.getDate("fecha"));
				
				Usuario us = new Usuario();
				us.setCodigo(res.getInt("cliente"));
				al.setCliente(us);
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
	
	public List buscarAlbaranMes(String cad,String cad2){
		Albaran al = null;
		List<Albaran> listaAlbaran = new ArrayList();
		Conexion con = new Conexion();
		String sql="SELECT codigo, precioTotal, fecha, cliente, cancelado " +
				"FROM albaranes WHERE fecha > '" +cad+"' && fecha < '"+cad2+"' " +
				" ORDER BY fecha";
		ResultSet res = con.consulta(sql);
		
		try{
			while(res.next()){
				al = new Albaran();
				al.setCodigo(res.getInt("codigo"));
				al.setPrecioTotal(res.getDouble("precioTotal"));
				al.setFecha(res.getDate("fecha"));

				Usuario us = new Usuario();
				us.setCodigo(res.getInt("cliente"));
				al.setCliente(us);
				al.setCancelado(res.getBoolean("cancelado"));
				listaAlbaran.add(al);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			con.cerrarConexion();
		}
		
		return listaAlbaran;
	}
	
	public int cancelacionAlbaran(int cod){
		Conexion con = new Conexion();
		int res = con.insertarUpdate("UPDATE albaranes SET cancelado = 1 WHERE " +
				"codigo = "+cod);
		con.cerrarConexion();
		return res;
	}
	
	public int consultaUltimoCodigo(){
		Conexion con = new Conexion();
		int i=0;
		ResultSet rs = con.consulta("select max(codigo) codigo from albaranes");
		try{
			if(rs.next()){
				i= rs.getInt("codigo");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}finally{
			con.cerrarConexion();
		}
		return i;
	}
}

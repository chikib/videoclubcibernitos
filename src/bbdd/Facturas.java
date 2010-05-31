package bbdd;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import facturas.*;
import usuario.*;

public class Facturas {
	Conexion con = new Conexion();
	
	public Factura buscarFactura(int codigo){
		Factura fc = null;
		StringBuilder stb = new StringBuilder("SELECT codigo, precioTotal, fecha, cliente " +
				"FROM facturas WHERE codigo = " + codigo);
		ResultSet res = con.consulta(stb.toString());
		try{
			if(res.next()){
				fc = new Factura();
				fc.setCodigo(res.getInt("codigo"));
				fc.setPrecioTotal(res.getDouble("precioTotal"));
				fc.setFecha(res.getDate("fecha"));

				Usuario us = new Usuario();
				us.setCodigo(res.getInt("cliente"));
				fc.setCliente(us);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			con.cerrarConexion();
		}
		
		return fc;
	}
	
	public Factura buscarFacturaFechas(int codigo){
		Factura fc = null;
		StringBuilder stb = new StringBuilder("SELECT codigo, precioTotal, fecha, cliente " +
				"FROM facturas WHERE codigo = " + codigo + "fecha>=");
		
		try{
			ResultSet res = con.consulta(stb.toString());
			if(res.next()){
				fc = new Factura();
				fc.setCodigo(res.getInt("codigo"));
				fc.setPrecioTotal(res.getDouble("precioTotal"));
				fc.setFecha(res.getDate("fecha"));

				Usuario us = new Usuario();
				us.setCodigo(res.getInt("cliente"));
				fc.setCliente(us);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println(e.getMessage());
		}
		finally{
			con.cerrarConexion();
		}
		
		return fc;
	}
	
	public int insertarFactura(Factura fac){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int res = con.insertarUpdate("INSERT INTO facturas(codigo, precioTotal, fecha, cliente)" +
				"VALUES ("+fac.getCodigo()+","+fac.getPrecioTotal()+",'"+df.format(fac.getFecha())+"',"+fac.getCliente()+")");
	
		con.cerrarConexion();
		return res;
			
		}		
}

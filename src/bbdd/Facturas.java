package bbdd;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import facturas.*;
import usuario.*;

public class Facturas {
	Conexion con = new Conexion();
	Usuario miUsuario = new Usuario();
	
	public Factura buscarFactura(int codigo){
		Factura fc = null;
		StringBuilder stb = new StringBuilder("SELECT codigo, precioTotal, fecha, cliente " +
				"FROM facturas WHERE codigo = " + codigo);
		
		try{
			ResultSet res = con.consulta(stb.toString());
			if(res.next()){
				fc = new Factura();
				fc.setCodigo(res.getInt("codigo"));
				fc.setPrecioTotal(res.getDouble("precioTotal"));
				fc.setFecha(res.getDate("fecha"));
				Usuario usu = new Usuario();
				usu.setCodigo(res.getInt("cliente"));
				fc.setCliente(usu);
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
				//fc.setCliente(res.getInt("cliente"));
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
	
	public int crearFactura(int cod, double preTota, Date fech, Usuario clie){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String mensaje = "";
		StringBuilder stb = new StringBuilder("INSERT INTO facturas(codigo, precioTotal, fecha, cliente)" +
				"VALUES ("+cod+", "+preTota+", '"+df.format(fech)+"',"+ clie.getCodigo()+")");
		int res = con.insertarUpdate(stb.toString());	
		con.cerrarConexion();
			
		return res;
	}
}

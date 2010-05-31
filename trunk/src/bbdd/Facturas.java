package bbdd;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import facturas.*;
import usuario.*;

public class Facturas {
	Conexion con = new Conexion();
	
	public int insertarFactura(Factura fac){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int res = con.insertarUpdate("INSERT INTO facturas(codigo, precioTotal, fecha, cliente)" +
				"VALUES ("+fac.getCodigo()+","+fac.getPrecioTotal()+",'"+df.format(fac.getFecha())+"',"+fac.getCliente()+")");
	
		con.cerrarConexion();
		return res;
			
	}	
	
	public Factura buscarFacturaDatos(int codigo){
		Factura fc = null;
		ResultSet res = con.consulta("SELECT codigo, precioTotal, fecha, cliente " +
				"FROM facturas WHERE codigo = " + codigo);

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
	
	public List buscarFacturaFechas(int mes,int año,int rango){
		Factura fc = null;
		List<Factura> listaFactura = new ArrayList();
		
		GregorianCalendar aux_gc1=new GregorianCalendar(año,mes-1,1);
		//Esto lo utilizamos para que no me cambie el valor inicial de gc1
		GregorianCalendar gc1=aux_gc1;
		gc1.add(Calendar.MONTH,rango);
		
		ResultSet res = con.consulta("SELECT codigo, precioTotal, fecha, cliente " +
				"FROM facturas WHERE fecha>="+gc1+" && fecha<="+gc1);
		
		try{
			while(res.next()){
				fc = new Factura();
				fc.setCodigo(res.getInt("codigo"));
				fc.setPrecioTotal(res.getDouble("precioTotal"));
				fc.setFecha(res.getDate("fecha"));

				Usuario us = new Usuario();
				us.setCodigo(res.getInt("cliente"));
				fc.setCliente(us);
				
				listaFactura.add(fc);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		finally{
			con.cerrarConexion();
		}
		
		return listaFactura;
	}
	
	
}

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
	
	public int insertarFactura(Factura fac){
		Conexion con = new Conexion();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		int res = con.insertarUpdate("INSERT INTO facturas(codigo, precioTotal, fecha, cliente)" +
				"VALUES ("+fac.getCodigo()+","+fac.getPrecioTotal()+",'"+df.format(fac.getFecha())+"',"+fac.getCliente().getCodigo()+")");
	
		con.cerrarConexion();
		return res;
			
	}	
	
	public Factura buscarFacturaDatos(int codigo){
		Factura fc = null;
		Conexion con = new Conexion();
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
	
	public List buscarFacturaFechas(String cad, String cad2){
		Factura fc = null;
		List<Factura> listaFactura = new ArrayList();
		
		String sql="SELECT codigo, precioTotal, fecha, cliente " +
		"FROM facturas WHERE fecha > '" +cad+"' && fecha < '"+cad2+"' " +
		" ORDER BY fecha";
		Conexion con = new Conexion();
		ResultSet res = con.consulta(sql);
		
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
	
	public int consultaUltimoCodigo(){
		Conexion con = new Conexion();
		int i=0;
		ResultSet rs = con.consulta("select max(codigo) codigo from facturas");
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

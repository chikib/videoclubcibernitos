package bbdd;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import usuario.Usuario;
import facturas.*;

public class Albaranes {
	Conexion con = new Conexion();
	
	
	public Albaran buscarAlbaran(int codigo){
		Albaran al = null;
			
		StringBuilder stb = new StringBuilder("SELECT codigo, precioTotal, fecha, cliente, cancelado " +
				"FROM albaranes WHERE codigo = " + codigo);
		ResultSet res = con.consulta(stb.toString());
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
	
	public Factura buscarAlbaranFechas(String f1 ,String f2){
		Factura fc = new Factura();
		long fecha1=fc.convertirFecha(f1);
		long fecha2=fc.convertirFecha(f2);
		
		
		return fc;
	}
	
	public int insertarAlbaran(Albaran al){
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
	
	public int cancelacionAlbaran(Albaran a){
		int res = con.insertarUpdate("UPDATE albaranes SET cancelado = '1' WHERE " +
				"codigo = "+a.getCodigo());
		con.cerrarConexion();
		return res;
	}
}

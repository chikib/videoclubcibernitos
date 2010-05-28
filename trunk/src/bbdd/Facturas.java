package bbdd;
import java.sql.*;
import facturas.*;
import usuario.*;

public class Facturas {
	Conexion con = new Conexion();
	Usuario miUsuario = new Usuario();
	
	public Factura buscarFactura(int codigo, Date fecha, Date fecha2){
		Factura fc = null;
		StringBuilder stb = new StringBuilder("SELECT codigo, preTot, fech, cliente " +
				"FROM facturas WHERE cod = " + codigo);
		
		try{
			ResultSet res = con.consulta(stb.toString());
			if(res.next()){
				fc = new Factura();
				fc.setCodigo(res.getInt("codigo"));
				fc.setPrecioTotal(res.getDouble("preTot"));
				fc.setFecha(res.getDate("fech"));
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
	
	public void crearFactura(int cod, double preTota, Date fech, Usuario clie){
		StringBuilder stb = new StringBuilder("INSERT INTO facturas(codigo, preTot, fech, cliente)" +
				"VALUES (cod, preTota, fech, clie)");
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

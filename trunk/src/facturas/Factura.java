package facturas;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import bbdd.Albaranes;
import bbdd.Facturas;
import bbdd.Usuarios;

import usuario.Usuario;

public class Factura extends Caja{
	Date fech=new Date();	
	public Factura(){
		
	}
	
	public Factura(int cod, double pretot, Date fech, Usuario cliente){
		super (cod,pretot,fech,cliente);
	}
	
	public String crearFactura(){
		String mensaje="";
		Facturas miFactura = new Facturas();
		int res=miFactura.insertarFactura(this);
		
		if (res==0){
			mensaje="No se ha podido crear la factura";
		}
		else{
			System.out.println("\n******** Factura creada *********\n");
			
		}
		return mensaje;
		
	}
	
	public String  fcPantalla ()
	{		
		String cadena="";
		Usuario usu = Usuario.buscaUscod(getCliente().getCodigo());
		if (usu.getNombre()!=null && usu.getApellidos()!=null){
			cadena = ("Código         : " + getCodigo() + "\n" +
					"Precio total    : " + getPrecioTotal() + "\n" +
					"Fecha        : " + getFecha() + "\n" +
					"Cliente      : " + usu.getNombre() + " " + usu.getApellidos())+ "\n";
		}
		else{
			cadena = "El usuario no existe";
		}
		return cadena;
	}
	
	public Factura buscarFactura(int codFa){
		return new Facturas().buscarFacturaDatos(codFa);
	}
	
	public List buscarFacturaFechas(int mes,int ano,int rango){
		List<Factura> listaFactura = new ArrayList();
		new Facturas().buscarFacturaFechas(mes,ano,rango);
		return listaFactura;
	}

}
	

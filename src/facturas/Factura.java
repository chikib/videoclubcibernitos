package facturas;
import java.util.*;
import bbdd.Facturas;

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
	
	public void buscarFactura(int codFa){
		Facturas bddFa = new Facturas();
		bddFa.buscarFactura(codFa);
	}
	
	//Consulta las facturas en un mes concreto
	public List consultar(int mes){
		/*for (Factura o : listaFacturas){
			if (o.consultaMes()==mes){
					miLista.add(o);
				}
		}
		return miLista;*/
		return new ArrayList();
	}

	//Consulta las facturas entre dos fechas
	public List consultaFechas(String fecha1, String fecha2){
		long f1=convertirFecha(fecha1);
		long f2=convertirFecha(fecha2);
		/*for (Factura o : listaFacturas){
			long ffactura=o.getFecha().getTime();
			if (ffactura>=f1 && ffactura<=f2)
			{
				miLista.add(o);
			}
		}
		return miLista;*/
		return new ArrayList();
	}
}
	

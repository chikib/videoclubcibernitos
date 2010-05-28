package facturas;

import java.text.*;
import java.util.*;

import usuario.Usuario;

public class Factura extends Caja{
	//Me creo un ArrayList de tipo albaran
	public static List<Factura> listaFacturas = new ArrayList();
	Date fech=new Date();
	List miLista = new ArrayList();
	
	
	//Me creo un Iterator para poder recorrer mis colecciones de tipo factura
	
	public Factura(){
		
	}
	
	public Factura(int cod, double pretot, Date fech, Usuario cliente){
		super (cod,pretot,fech,cliente);
	}
	
	public void crearFactura(int cod, int pretot, Usuario cliente){
		Factura miFactura = new Factura(cod, pretot, fech, cliente);
		miLista.add(miFactura);
		
	}
	
	//Consulta las facturas en un mes concreto
	public List consultar(int mes){
		for (Factura o : listaFacturas){
			if (o.consultaMes()==mes){
					miLista.add(o);
				}
		}
		return miLista;
	}

	//Consulta las facturas entre dos fechas
	public List consultaFechas(String fecha1, String fecha2){
		long f1=convertirFecha(fecha1);
		long f2=convertirFecha(fecha2);
		for (Factura o : listaFacturas){
			long ffactura=o.getFecha().getTime();
			if (ffactura>=f1 && ffactura<=f2)
			{
				miLista.add(o);
			}
		}
		return miLista;
	}
}
	

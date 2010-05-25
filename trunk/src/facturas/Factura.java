package facturas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import usuario.Usuario;

public class Factura extends Caja{
	//Me creo un ArrayList de tipo albaran
	public static List<Factura> listaFacturas = new ArrayList();
	Date fech=new Date();
	List miLista = new ArrayList();
	
	//Me creo un Iterator para poder recorrer mis colecciones de tipo factura
	
	
	public Factura(int cod, double pretot, Date fech, Usuario miUsu){
		super (cod,pretot,fech,miUsu);
	}
	
	public void crearFactura(int cod, int pretot, Usuario miUsu){
		Factura miFactura = new Factura(cod, pretot, fech, miUsu);
		miLista.add(miFactura);
		
	}
	
	//Consultar mes 
	public int consultaMes(){
		GregorianCalendar fecha1=new GregorianCalendar();
		fecha1.setTime(getFecha());
		int d1=fecha1.get(Calendar.MONTH)+1;
		return d1;
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
	public void consultaFechas(String fecha1, String fecha2){}
}
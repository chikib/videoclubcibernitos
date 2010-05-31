package facturas;

import java.text.*;
import java.util.*;

import usuario.Usuario;

public abstract class Caja {
	
	
	private int codigo=1;
	private double precioTotal=123;
	private final double IVA=0.16;
	private Usuario cliente;
	private Date fecha;
	
	
	//Contructor 
	public Caja(int cod, double preTot, Date fech, Usuario cliente){
		this.cliente=cliente;
		codigo=cod;
		precioTotal=preTot;
		fecha=fech;
	}
	
	//Contructor vacio
	public Caja(){
		
	}
		
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int cod) {
		this.codigo = cod;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(double preTot) {
		this.precioTotal = preTot;
	}
	
	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fech) {
		this.fecha = fech;
	}
	
	public double getIVA() {
		return IVA;
	}
	
	//Consulta en un mes concreto.
	//abstract public List consultar(int mes);
	
	//Consulta entre dos fechas.
	//abstract public List consultaFechas(String fecha1, String fecha2);
	
	//Consultar mes 
	public int consultaMes(){
		GregorianCalendar fecha1=new GregorianCalendar();
		fecha1.setTime(getFecha());
		int d1=fecha1.get(Calendar.MONTH)+1;
		return d1;
	}
	
	//Este metodo me convierte las 2 fechas introducidas por teclados que son de 
	//tipo String a un long, para poder comparar con cada una de la fecha de las facturas
	//y albaranes
	
	public long convertirFecha(String fecha){
		DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
		long lAhora=0;
		
		try {
			Date d = dfm.parse(fecha);
			lAhora = d.getTime();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return lAhora;
	}
}

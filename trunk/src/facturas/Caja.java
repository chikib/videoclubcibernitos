package facturas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import usuario.Usuario;

public abstract class Caja {
	
	private int codigo;
	private double precioTotal;
	private final double IVA=0.16;
	private Usuario miUsuario;
	private Date fecha;
	
	
	//Contructor 
	public Caja(int cod, double preTot, Date fech, Usuario miUsu){
		this.miUsuario=miUsu;
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
	
	public void setPrecioTotal(int preTot) {
		this.precioTotal = preTot;
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
	abstract public List consultar(int mes);
	
	//Consulta entre dos fechas.
	abstract public void consultaFechas(String fecha1, String fecha2);
}

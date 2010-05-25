package facturas;

import java.util.Date;

abstract public class Caja {
	
	private int codigo;
	private double precioTotal;
	private final double IVA=0.16;
	//Usuario miUsuario=new Usuario();
	private Date fecha;
	
	
	//Contructor 
	public Caja(int c, double pt, Date f){
		codigo=c;
		precioTotal=pt;
		fecha=f;
	}
	
	//Contructor vacio
	public Caja(){
		
	}
		
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public double getIVA() {
		return IVA;
	}
	
	//Consulta en un mes concreto.
	abstract public void consultaMes(String mes);
	
	//Consulta entre dos fechas.
	abstract public void consultaFechas();
}

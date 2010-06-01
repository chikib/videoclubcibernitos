package facturas;

import java.text.*;
import java.util.*;

import usuario.Usuario;

public abstract class Caja {
	
	
	private int codigo;
	private double precioTotal;
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
}

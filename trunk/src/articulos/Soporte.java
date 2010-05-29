package articulos;

import java.util.List;

import bbdd.Proveedores;
import bbdd.Soportes;

public class Soporte {
	private int codigo;
	private String tipo;
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	
	public void imprimirSoportes(){
		Soportes soporteBbdd = new Soportes();
		List<Soporte> lista = soporteBbdd.getSoportes();
		for(Soporte soporte: lista){
			System.out.println("     ("+soporte.getCodigo()+") "+soporte.getTipo());
		}
	}

}

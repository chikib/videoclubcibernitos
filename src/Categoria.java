import java.io.*;

/* Inicio del programa: 25-mayo-2010
 * Ultima actualizacion: 
 * Nombre de los programadores: Azucena - nombre1 - Miguel - Sergio
 * Objetivo del programada: Crear una clase de metodos para la gestion de categorias
 *                          del videoclud cibernitos
 */


public class Categoria {
	
	private int codigo;
	private String tematica;
	private int recargobase;
	private int recargonovedad;
	private int tiempoalquiler;
	private int tiemponovedad;
	
	
	// Aqui creamos un constructor
	
	public Categoria (int codigonuevo, String tematicanuevo, int recargobasenuevo, int recargonovedadnuevo, int tiempoalqnuevo, int tiemponovnuevo)
	{
			this.codigo = codigonuevo;
			this.tematica = tematicanuevo;
			this.recargobase = recargobasenuevo;
			this.recargonovedad = recargonovedadnuevo;
			this.tiempoalquiler = tiempoalqnuevo;
			this.tiemponovedad = tiemponovnuevo;
	}
	
	// Creamos los get-set
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getTematica() {
		return tematica;
	}
	public void setRecargobase(int recargobase) {
		this.recargobase = recargobase;
	}
	public int getRecargobase() {
		return recargobase;
	}
	public void setRecargonovedad(int recargonovedad) {
		this.recargonovedad = recargonovedad;
	}
	public int getRecargonovedad() {
		return recargonovedad;
	}
	public void setTiempoalquiler(int tiempoalquiler) {
		this.tiempoalquiler = tiempoalquiler;
	}
	public int getTiempoalquiler() {
		return tiempoalquiler;
	}
	public void setTiemponovedad(int tiemponovedad) {
		this.tiemponovedad = tiemponovedad;
	}
	public int getTiemponovedad() {
		return tiemponovedad;
	}
	

}

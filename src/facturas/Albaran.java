package facturas;
import java.util.*;
import bbdd.Albaranes;
import usuario.Usuario;

public class Albaran extends Caja {
	private boolean cancelado;
	Albaranes miAlbaran = new Albaranes();
	
	public Albaran(int cod, double preTot, Date fech, Usuario cliente, boolean cancel){
		super (cod, preTot, fech, cliente);
		setCancelado(cancel);
	}
	
	public Albaran(){
		
	}
	
	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancel) {
		this.cancelado = cancel;
	}

	public String crearAlbaran(){
		String mensaje="";
		int res=miAlbaran.insertarAlbaran(this);
		
		if (res==0){
			mensaje="No se ha podido crear la factura";
		}
		else{
			System.out.println("\n******** Factura creada *********\n");
			
		}
		return mensaje;
		
	}
	
	public String  alPantalla ()
	{		
		Usuario usu = Usuario.buscaUscod(getCliente().getCodigo());
		return ("Código:     " + getCodigo() + " " +
		"Precio total:    " + getPrecioTotal() + " " +
		"Fecha:      " + getFecha() + " " +
		"Cliente:     " + usu.getNombre() + " " + usu.getApellidos()+ " " +
		"Cancelado:   " + isCancelado()+ "\n"); 
				
	}
	
	public Albaran buscarAlbaran(int codAl){
		return new Albaranes().buscarAlbaranDatos(codAl);
	}
	
	public List buscarAlbaranFechas(String cad, String cad2){
		List<Albaran> listaAlbaran = new ArrayList();
		listaAlbaran= new Albaranes().buscarAlbaranMes(cad,cad2);
		return listaAlbaran;
	}
	
	public String cancelarAlbaran(int cod)
	{
		String mensaje="";
		int res=miAlbaran.cancelacionAlbaran(cod);
		
		if (res==0){
			mensaje="No se ha podido cancelar el albaran";
		}
		else{
			System.out.println("\n******** Albarán cancelado *********\n");
			
		}
		return mensaje;
		
	}





}

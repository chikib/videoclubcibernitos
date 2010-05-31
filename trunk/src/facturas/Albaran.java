package facturas;
import java.util.*;

import bbdd.Albaranes;
import bbdd.Facturas;

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
	
	public void buscarAlbaran(int codAl){
		Albaranes bddAl = new Albaranes();
		bddAl.buscarAlbaran(codAl);
	}
	
	//Consulta los albaranes en un mes concreto
	public List consultar(int mes){
		List miLista = new ArrayList();
		/*for (Albaran o : listaAlbaranes){
			if (o.consultaMes()==mes){
					miLista.add(o);
				}
		}*/
		return miLista;
	}

	
	//Consulta los albaranes entre dos fechas
	public List consultaFechas(String fecha1, String fecha2){
		miAlbaran.buscarAlbaranFechas(fecha1,fecha2);
		
		
		
		/*for (Albaran o : listaAlbaranes){
			long ffactura=o.getFecha().getTime();
			if (ffactura>=f1 && ffactura<=f2)
			{
				miLista.add(o);
			}
		}
		return miLista;*/
	
		
		return new ArrayList();
	}
	
	public String cancelarAlbaran()
	{
		String mensaje="";
		int res=miAlbaran.cancelacionAlbaran(this);
		
		if (res==0){
			mensaje="No se ha podido cancelar el albaran";
		}
		else{
			System.out.println("\n******** Albarán cancelado *********\n");
			
		}
		return mensaje;
		
	}





}

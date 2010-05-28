package facturas;

import java.text.*;
import java.util.*;

import usuario.Usuario;

public class Albaran extends Caja {
	private boolean cancelado;
	
	//Me creo un ArrayList de tipo factura
	public static List<Albaran> listaAlbaranes = new ArrayList();
	List miLista = new ArrayList();
	
	public Albaran(int cod, double preTot, Date fech, boolean cancel, Usuario cliente){
		super (cod, preTot, fech, cliente);
		setCancelado(cancel);
	}
	
	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancel) {
		this.cancelado = cancel;
	}

	
	//Consulta los albaranes en un mes concreto
	public List consultar(int mes){
		List miLista = new ArrayList();
		for (Albaran o : listaAlbaranes){
			if (o.consultaMes()==mes){
					miLista.add(o);
				}
		}
		return miLista;
	}

	
	//Consulta los albaranes entre dos fechas
	public List consultaFechas(String fecha1, String fecha2){
		long f1=convertirFecha(fecha1);
		long f2=convertirFecha(fecha2);
		for (Albaran o : listaAlbaranes){
			long ffactura=o.getFecha().getTime();
			if (ffactura>=f1 && ffactura<=f2)
			{
				miLista.add(o);
			}
		}
		return miLista;
	}





}

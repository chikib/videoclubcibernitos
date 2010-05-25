package facturas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import usuario.Usuario;

public class Albaran extends Caja {
	private boolean cancelado;
	
	//Me creo un ArrayList de tipo factura
	public static List<Albaran> listaAlbaranes = new ArrayList();
	
	public Albaran(int cod, double preTot, Date fech, boolean cancel, Usuario miUsu){
		super (cod, preTot, fech, miUsu);
		setCancelado(cancel);
	}
	
	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancel) {
		this.cancelado = cancel;
	}

	//Consultar mes 
	public int consultaMes(){
		GregorianCalendar fecha1=new GregorianCalendar();
		fecha1.setTime(getFecha());
		int d1=fecha1.get(Calendar.MONTH)+1;
		return d1;
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
	public void consultaFechas(String fecha1, String fecha2){}





}

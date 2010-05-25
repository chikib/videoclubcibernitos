package facturas;

import java.util.Date;

public class Albaran extends Caja {
	private boolean cancelado;

	public Albaran(int c, double pt, Date f, boolean can){
		super (c,pt,f);
		setCancelado(can);
	}
	
	
	
	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	//Consulta los albaranes en un mes concreto
	public void consultaMes(String mes){
		
		
		
	}

	//Consulta los albaranes entre dos fechas
	public void consultaFechas(){
		
		
		
	}





}

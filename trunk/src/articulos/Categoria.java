package articulos;

public class Categoria {
	private int codigo;
	private String tematica;
	private int recargoBase;
	private int recargoNovedad;
	private int tiempoAlquiler;
	private int tiempoAlquilerNovedad;

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

	public void setRecargoBase(int recargoBase) {
		this.recargoBase = recargoBase;
	}

	public int getRecargoBase() {
		return recargoBase;
	}

	public void setRecargoNovedad(int recargoNovedad) {
		this.recargoNovedad = recargoNovedad;
	}

	public int getRecargoNovedad() {
		return recargoNovedad;
	}

	public void setTiempoAlquiler(int tiempoAlquiler) {
		this.tiempoAlquiler = tiempoAlquiler;
	}

	public int getTiempoAlquiler() {
		return tiempoAlquiler;
	}

	public void setTiempoAlquilerNovedad(int tiempoAlquilerNovedad) {
		this.tiempoAlquilerNovedad = tiempoAlquilerNovedad;
	}

	public int getTiempoAlquilerNovedad() {
		return tiempoAlquilerNovedad;
	}

	/* ********************************************************************************************** */
	/*  realizamos un alta de una categoria si no existe */
	
	public void altaCategoria(String tema, int codi, int recarba, int recarno, int tiempoal, int tiempono)
	{
		if (tema.length()>0 && existeCategoria(tema)==false)
		{
			codigo = codi;
			tematica = tema;
			recargoBase = recarba;
			recargoNovedad = recarno;
			tiempoAlquiler = tiempoal;
			tiempoAlquilerNovedad = tiempono;
		}
		else
		{
			System.out.println("No me ha introducido la categoria nueva o la categoria ya existe");
		}	
	}
	
	
	/* *********************************************************************************************** */
	/* Comprobamos que existe o no la categoria */
	
	public boolean existeCategoria (String tema)
	{
		boolean versiexiste = false;
		
		return versiexiste;
	}

}

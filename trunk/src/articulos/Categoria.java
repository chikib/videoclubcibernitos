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
	

	
}

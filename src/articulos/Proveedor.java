package articulos;

public class Proveedor {
	private int codigo;
	private String nombre;
	private String cif;
	private String telefono;
	private String direccion;
	private String web;
	private String fax;
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getCif() {
		return cif;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getWeb() {
		return web;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getFax() {
		return fax;
	}
}

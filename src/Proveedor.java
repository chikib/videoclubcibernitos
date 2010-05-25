import java.io.*;

/* Inicio del programa: 24-mayo-2010
 * Ultima actualizacion: 
 * Nombre de los programadores: Azucena - nombre1 - Miguel - Sergio
 * Objetivo del programada: Crear una clase de metodos para la gestion proveedores
 *                          del videoclud cibernitos
 */

public class Proveedor {
	
	// Atributos
	private int codigo;
	private String nombre;
	private String cif;
	private String telefono;
	private String direccion;
	private String web;
	private String fax;
	
	
// Aqui creamos un constructor
	
public Proveedor(int codigonuevo, String nombrenuevo, String cifnuevo, String telefononuevo, String direccnuevo, String webnuevo, String faxnuevo)
{
    /* Para dar de alta un objeto "proveedor" necesitamos como mínimo su cif,
	               su nombre fiscal y su direccion, sino no se cursa el alta.
	
	*/
	
	if ((cifnuevo.length()>0) && (direccnuevo.length()>0) && (nombrenuevo.length()>0)) 
	{
		this.codigo = codigonuevo;
		this.nombre = nombrenuevo;
		this.cif = cifnuevo;
		this.telefono = telefononuevo;
		this.direccion = direccnuevo;
		this.web = webnuevo;
		this.fax = faxnuevo;
	}	
	else
	{	
		System.out.println ("No se ha cursado el alta del proveedor, faltan datos. Se debe inroducir como minimo el nombre, el cif y la direccion");
	}	
}

	// Preparamos los get-set de los atributos privados
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTelefono() {
		return telefono;
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
		
	// Este metodo devuelve los datos que tenemos del proveedor.
	
	public void obtenerDatos()
	{
		System.out.println ("Nombre del proveedor: "+ nombre + ". Codigo del proveedor: "+codigo);
		System.out.println ("Direccion : "+direccion);
		System.out.println ("Cif del proveedor :" + cif);
		System.out.println ("Telefono de contacto :" + telefono + ". Fax :" + fax);
		System.out.println ("Pagina Web del proveedor :"+web);
		return;
	}
}


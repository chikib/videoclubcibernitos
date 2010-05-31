package articulos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import bbdd.Proveedores;

import varios.InputStreamVideoclub;
import varios.VideoException;

/* Inicio del programa: 24-mayo-2010
 * Ultima actualizacion: 
 * Nombre de los programadores: Azucena - Juanma - Miguel - Sergio
 * Objetivo del programada: Crear una clase de metodos para la gestion
 *                          del videoclud cibernitos
 */

public class Proveedor {

	// Atributos
	public static List<Proveedor> listaProveedores;
	private int codigo;
	private String nombre;
	private String cif;
	private String telefono;
	private String direccion;
	private String web;
	private String fax;

	static {
		listaProveedores = new ArrayList<Proveedor>();
	}

	// Aqui creamos un constructor
	public Proveedor(){
		
	}
	
	public Proveedor(int codentrada, String nomentrada, String cifentrada,
			String telentrada, String direntrada, String webentrada,
			String faxentrada) {

		// Para dar de alta un objeto "proveedor" necesitamos como mínimo su
		// cif, su nombre fiscal y su direccion, sino no se cursa el alta.
		try {
			if ((cifentrada.length() > 0) && (direntrada.length() > 0)
					&& (nomentrada.length() > 0)) {
				this.codigo = codentrada;
				this.nombre = nomentrada;
				this.cif = cifentrada;
				this.telefono = telentrada;
				this.direccion = direntrada;
				this.web = webentrada;
				this.fax = faxentrada;
			} else {
				throw new VideoException(
						"No se ha cursado el alta del proveedor, faltan datos. Se debe introducir como minimo el nombre, el cif y la direccion");
			}
		} catch (VideoException e) {
			System.out.println(e.toString());
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

	// Creamos un metodo para dar de alta un objeto
	public String crearProveedor() {
		String mensaje = "";
		int res = new Proveedores().crearProveedor(this);
		if(res==0){
			mensaje = "Ha ocurrido un error al insertar en base de datos";
		}
		return mensaje;
	}
	
	public String editarProveedor() {
		String mensaje = "";
		int res = new Proveedores().modificarProveedor(this);
		if(res==0){
			mensaje = "Ha ocurrido un error al modificar en base de datos";
		}
		return mensaje;
	}

	// Este metodo devuelve los datos que tenemos del proveedor.
	public void obtenerDatos() {
		System.out.println("(1) Nombre del proveedor: " + nombre);
		System.out.println("(2) Direccion : " + (direccion==null?"eoeo":direccion));
		System.out.println("(3) Cif del proveedor :" + cif);
		System.out.println("(4) Telefono de contacto :" + (telefono==null?"":telefono));
		System.out.println("(5) Fax :" + (fax==null?"eoeo":fax));
		System.out.println("(6) Pagina Web del proveedor :" + (web==null?"eoeo":web));
		return;
	}
	
	public Proveedor consultarProveedor(String cif){
		return new Proveedores().buscarProveedorCif(cif);
	}
	
	public void imprimirProveedores(){
		Proveedores provBbdd = new Proveedores();
		List<Proveedor> lista = provBbdd.getProveedores();
		for(Proveedor prov: lista){
			System.out.println("     ("+prov.getCodigo()+") "+prov.getNombre());
		}
		
	}

}

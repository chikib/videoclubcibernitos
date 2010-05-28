package articulos;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import varios.VideoException;

/* Inicio del programa: 24-mayo-2010
 * Ultima actualizacion: 
 * Nombre de los programadores: Azucena - Juanma - Miguel - Sergio
 * Objetivo del programada: Crear una clase de metodos para la gestion
 *                          del videoclud cibernitos
 */

public class Proveedor {

	// Atributos
	public static List listaProveedores;
	private int codigo;
	private String nombre;
	private String cif;
	private String telefono;
	private String direccion;
	private String web;
	private String fax;

	static {
		listaProveedores = new ArrayList();
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
						"No se ha cursado el alta del proveedor, faltan datos. Se debe inroducir como minimo el nombre, el cif y la direccion");
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

	public void crearAlta(int cod1, String nom1, String ci1, String telefono1,
			String dir1, String web1, String fa1) {
		// Para dar de alta un objeto "proveedor" necesitamos como mínimo su
		// cif, su nombre fiscal y su direccion, sino no se cursa el alta.

		if ((ci1.length() > 0) && (dir1.length() > 0) && (nom1.length() > 0)) {
			codigo = cod1;
			nombre = nom1;
			cif = ci1;
			telefono = telefono1;
			direccion = dir1;
			web = web1;
			fax = fa1;
		} else {
			System.out
					.println("No se ha cursado el alta del proveedor, faltan datos. Se debe inroducir como minimo el nombre, el cif y la direccion");
		}
	}

	// Este metodo devuelve los datos que tenemos del proveedor.

	public void ObtenerDatos() {
		System.out.println("Nombre del proveedor: " + nombre
				+ "Codigo del proveedor: " + codigo);
		System.out.println("Direccion : " + direccion);
		System.out.println("Cif del proveedor :" + cif);
		System.out.println("Telefono de contacto :" + telefono + "Fax :" + fax);
		System.out.println("Pagina Web del proveedor :" + web);
		return;
	}

	public void AltaProveedor(String cifentrada) {
		// Solicitamos SOLO el cif para ver si existe o no, este proveedor.

		if (cifentrada.length() > 0) {
			Iterator it = listaProveedores.iterator();
			boolean enc = false;
			Proveedor prov = null;
			while (it.hasNext() && !enc)// (obtenerDatos(it) !=cifentrada)
			{
				prov = (Proveedor) it.next();
				if (prov.cif == cifentrada) {
					enc = true;
				}
			}
			try {
				if (enc) {
					throw new VideoException("Este proveedor ya existe");
				} else {
					// falta hacer el alta del proveedor.
				}
			} catch (VideoException e) {

			}
		}
	}

}

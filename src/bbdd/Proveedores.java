package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import articulos.Articulo;
import articulos.Categoria;
import articulos.Proveedor;
import articulos.Soporte;

public class Proveedores {
	
	public List getProveedores(){
		Proveedor proveedor = null;
		List listaProveedores = new ArrayList();
		Conexion con = new Conexion();
		StringBuilder stb = new StringBuilder("select codigo,nombre,cif,telefono,direccion,web,fax from proveedores order by nombre");
		try{
			ResultSet res = con.consulta(stb.toString());
			while(res.next()){
				proveedor = new Proveedor();
				proveedor.setCodigo(res.getInt("codigo"));
				proveedor.setNombre(res.getString("nombre"));
				proveedor.setCif(res.getString("cif"));
				proveedor.setTelefono(res.getString("telefono"));
				proveedor.setDireccion(res.getString("direccion"));
				proveedor.setWeb(res.getString("web"));
				proveedor.setFax(res.getString("fax"));
				listaProveedores.add(proveedor);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		catch(NumberFormatException e){
			System.out.println(e.getMessage());
		}
		finally{
			con.cerrarConexion();
		}
		return listaProveedores;
	}
	
	
}

package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import articulos.Proveedor;
public class Proveedores {
	
	public List<Proveedor> getProveedores(){
		Proveedor proveedor = null;
		List<Proveedor> listaProveedores = new ArrayList<Proveedor>();
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
	
	public Proveedor buscarProveedor(int codigo){
		Conexion con = new Conexion();
		Proveedor prov = null;
		try{
			ResultSet res = con.consulta("select codigo,nombre,cif,telefono,direccion,web,fax from proveedores " +
					"where codigo = "+codigo);
			if(res.next()){
				prov = new Proveedor();
				prov.setCodigo(res.getInt("codigo"));
				prov.setNombre(res.getString("nombre"));
				prov.setCif(res.getString("cif"));
				prov.setTelefono(res.getString("telefono"));
				prov.setDireccion(res.getString("direccion"));
				prov.setWeb(res.getString("web"));
				prov.setFax(res.getString("fax"));
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return prov;
	}
	
	public Proveedor buscarProveedorCif(String cif){
		Conexion con = new Conexion();
		Proveedor prov = null;
		try{
			ResultSet res = con.consulta("select codigo,nombre,cif,telefono,direccion,web,fax from proveedores " +
					"where cif = '"+cif+"'");
			if(res.next()){
				prov = new Proveedor();
				prov.setCodigo(res.getInt("codigo"));
				prov.setNombre(res.getString("nombre"));
				prov.setCif(res.getString("cif"));
				prov.setTelefono(res.getString("telefono"));
				prov.setDireccion(res.getString("direccion"));
				prov.setWeb(res.getString("web"));
				prov.setFax(res.getString("fax"));
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return prov;
	}
	
	public int crearProveedor(Proveedor prov){
		int res = 0;
		Conexion con = new Conexion();
		res = con.insertarUpdate("insert into proveedores(nombre,cif,telefono,direccion,web,fax)" +
				"values('"+prov.getNombre()+"','"+prov.getCif()+"'," +
				"'"+prov.getTelefono()+"','"+prov.getDireccion()+"','"+prov.getWeb()+"','"+prov.getFax()+"')");
		con.cerrarConexion();
		return res;
	}
	
	public int modificarProveedor(Proveedor prov){
		int res = 0;
		Conexion con = new Conexion();
		res = con.insertarUpdate("update proveedores set nombre='"+prov.getNombre()+"',cif='"+prov.getCif()+"'" +
				", telefono='"+prov.getTelefono()+"', direccion='"+prov.getDireccion()+"',web='"+prov.getWeb()+"'" +
				", fax='"+prov.getFax()+"' where codigo = "+prov.getCodigo());
		con.cerrarConexion();
		return res;
	}
	
	public int eliminarProveedor(Proveedor prov){
		int res = 0;
		Conexion con = new Conexion();
		res = con.insertarUpdate("delete from proveedores where codigo = "+prov.getCodigo());
		con.cerrarConexion();
		return res;
	}
	
	
}

package varios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import articulos.Articulo;


public class Conexion {
	private Connection con;
	
	public Conexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.setCon(DriverManager.getConnection(
			"jdbc:mysql://localhost/videoclub","root","admin"));
		}catch(ClassNotFoundException e){
			e.getMessage();
		}catch(IllegalAccessException e){
			e.getMessage();
		}catch(InstantiationException e){
			e.getMessage();
		}catch(SQLException e){
			e.getMessage();
		}
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Connection getCon() {
		return con;
	}
	
	public List consulta(String consulta){
		List resultados = new ArrayList();
		try{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(consulta);
			while(rs.next()){
				Articulo art = new Articulo();
				art.setTitulo(rs.getString(1));
				art.setCodigoBarras(rs.getInt(2));
				art.setPrecioAlquiler(rs.getInt("precio"));
				resultados.add(art);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return resultados;
	}
	
	public int insertarUpdate(String consulta){
		int res = 0;
		try{
			Statement st=con.createStatement();
			res = st.executeUpdate(consulta);
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return res;
	}

	public void cerrarConexion()
	{
		try{
			con.close();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
}

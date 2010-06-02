package bbdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	private Connection con;
	
	public Conexion(){
		crearConexion();
	}
	
	public void setCon(Connection con) {
		this.con = con;
	}

	public Connection getCon() {
		return con;
	}
	
	public void crearConexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.setCon(DriverManager.getConnection(
			"jdbc:mysql://clapinsa.com/clama23_video_grupo01","grupo01","123456"));
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}catch(IllegalAccessException e){
			System.out.println(e.getMessage());
		}catch(InstantiationException e){
			System.out.println(e.getMessage());
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public ResultSet consulta(String consulta){
		ResultSet resultados = null;
		try{
			Statement st=con.createStatement();
			resultados=st.executeQuery(consulta);	
		}
		catch (SQLException e){
			//e.printStackTrace();
			System.out.println(e.getMessage());
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

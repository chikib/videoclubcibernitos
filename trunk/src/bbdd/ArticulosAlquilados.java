package bbdd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import usuario.Usuario;

import articulos.Articulo;
import articulos.ArticuloAlquilado;
public class ArticulosAlquilados {
	
		public int insertar(ArticuloAlquilado artAlq){
			Conexion con = new Conexion();
			DateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
			int res = con.insertarUpdate("insert into articulosAlquilados(articulo,fechaAlquiler,cliente,observaciones,recargo,precio,tiempo)" +
					"values ("+artAlq.getArticulo().getCodigo()+",'"+sdf.format(artAlq.getFechaAlquiler())+"',"+artAlq.getCliente().getCodigo() +
							",'"+artAlq.getObservaciones()+"', "+artAlq.getRecargo()+","+artAlq.getPrecio()+","+artAlq.getTiempo()+")");
			con.cerrarConexion();
			return res;
		}
		
		public int actualizarFechaDevolucion(ArticuloAlquilado artAlq){
			Conexion con = new Conexion();
			DateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
			int res = con.insertarUpdate("update articulosAlquilados set fechaEntrega = '"+sdf.format(artAlq.getFechaDevolucion())+"' where " +
					"codigo = "+artAlq.getCodigo());
			con.cerrarConexion();
			return res;
		}
		
		public ArticuloAlquilado consultaArtAlqCodigo(int codUsu, int codArt){
			ArticuloAlquilado artAlq = null;
			Conexion con = new Conexion();
			try{
				ResultSet rs = con.consulta("select codigo,articulo,fechaAlquiler,cliente,observaciones,recargo,tiempo,precio" +
						" from articulosAlquilados where cliente = "+codUsu+" and articulo = "+codArt+" and " +
						" fechaEntrega is null");
				if(rs.next()){
					artAlq = new ArticuloAlquilado();
					artAlq.setArticulo(new Articulo());
					artAlq.setCliente(new Usuario());
					artAlq.setCodigo(rs.getInt("codigo"));
					Articulo art = new Articulo();
					art.setCodigo(rs.getInt("codigo"));
					artAlq.setArticulo(art);
					artAlq.setFechaAlquiler(rs.getDate("fechaAlquiler"));
					artAlq.setObservaciones(rs.getString("observaciones"));
					Usuario usu = new Usuario();
					usu.setCodigo(rs.getInt("cliente"));
					artAlq.setCliente(usu);
					artAlq.setRecargo(rs.getInt("recargo"));
					artAlq.setTiempo(rs.getInt("tiempo"));
					artAlq.setPrecio(rs.getDouble("precio"));
				}
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return artAlq;
		}	
		
		public int consultaUltimoCodigo(){
			Conexion con = new Conexion();
			int i=0;
			ResultSet rs = con.consulta("select max(codigo) codigo from articulosAlquilados");
			try{
				if(rs.next()){
					i= rs.getInt("codigo");
				}
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}finally{
				con.cerrarConexion();
			}
			return i;
		}
	}

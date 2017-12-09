package ModeloDao;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import Modelo.ejecutivo;

public class EjecutivoDao {
		
		private static final String SQL_INGRESAR=
		"call banco.sp_ingresar_ejecutivo(?, ?, ?, ?, ?);";
		
		private static final String SQL_ACTUALIZAR=
		"call banco.sp_actualizar_ejecutivo(?, ?, ?, ?, ?, ?, ?);";
		
		private static final String SQL_LISTAR=
		"SELECT * FROM banco.vw_listar_ejecutivos;";
		
	private static final Conexion cnn=Conexion.saberEstado();
		
		public boolean ingresar(ejecutivo x) {
	        CallableStatement ps;
	        ResultSet rs;
	        int bandera = 0;
	        try {
	            ps= cnn.getCnn().prepareCall(SQL_INGRESAR);
	            ps.setString(1, x.getPerRut());
	            ps.setString(2, x.getPerNombre());
	            ps.setString(3, x.getPerApePaterno());
	            ps.setString(4, x.getPerApeMaterno());
	            ps.setString(5, x.getPerNacionalidad());
	            ps.setString(6, x.getPerFecNacimiento());
	            ps.setString(7, x.getEjeFecContrato());
	            rs = ps.executeQuery();
	            while(rs.next()) {
	            	bandera = rs.getInt("_RESULTADO");
	            	System.out.println(bandera);
	            }
	            if(bandera > 0) {
	            	return true;
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }finally{
	            cnn.cerrarConexion();
	        }
	        return false;
	    }
		public boolean actualizar(ejecutivo x) {
	        CallableStatement ps;
	        ResultSet rs;
	        int bandera = 0;
	        try {
	            ps= cnn.getCnn().prepareCall(SQL_INGRESAR);
	            ps.setString(1, x.getPerRut());
	            ps.setString(2, x.getPerNombre());
	            ps.setString(3, x.getPerApePaterno());
	            ps.setString(4, x.getPerApeMaterno());
	            ps.setString(5, x.getPerNacionalidad());
	            ps.setString(6, x.getPerFecNacimiento());
	            ps.setString(7, x.getEjeFecContrato());
	            rs = ps.executeQuery();
	            while(rs.next()) {
	            	bandera = rs.getInt("_RESULTADO");
	            	System.out.println(bandera);
	            }
	            if(bandera > 0) {
	            	return true;
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }finally{
	            cnn.cerrarConexion();
	        }
	        return false;
	    }
		public ArrayList<ejecutivo> listar() {
		    
	        PreparedStatement ps;
	        ResultSet rs;
	        ArrayList<ejecutivo> ejecutivos= new ArrayList();
	        try {
	            ps=cnn.getCnn().prepareStatement(SQL_LISTAR);
	            rs=ps.executeQuery();
	            while(rs.next()){
	                ejecutivos.add(
	                        new ejecutivo(rs.getString("RUT"),
	                                rs.getString("NOMBRE"),
	                                rs.getString("PATERNO"),
	                                rs.getString("MATERNO"),
	                                rs.getString("NACIONALIDAD"),
	                                rs.getString("NACIMIENTO"),
	                                rs.getString("FECHA_CONTRATO")));
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.toString());
	        }finally {
				cnn.cerrarConexion();
			}
	        return ejecutivos;
	    }
}

package ModeloDao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import Modelo.Ejecutivo;
import Modelo.Natural;

public class NaturalDao {
		private static final String SQL_INGRESAR = 
				"call banco.sp_ingresar_natural(?, ?, ?, ?, ?, ?);";
		private static final String SQL_BUSCAR=
	            "SELECT * FROM vw_listar_cliente_naturales WHERE RUT LIKE ?";
		
		
		private static final String SQL_LISTAR=
		        "SELECT * FROM vw_listar_cliente_naturales";
		
		private static final Conexion cnn = Conexion.saberEstado();
		
		public boolean ingresar(Natural n){
			CallableStatement cs;
			ResultSet rs;
			int bandera=0;
		        try {
		        	cs = cnn.getCnn().prepareCall(SQL_INGRESAR);
		        	cs.setString(1, n.getPerRut());
		            cs.setString(2, n.getPerNombre());
		            cs.setString(3, n.getPerApePaterno());
		            cs.setString(4, n.getPerApeMaterno());
		            cs.setString(5, n.getCliCategoria());
		            cs.setInt(6, n.getNatPatrimonio());
		            rs = cs.executeQuery();
		            while(rs.next()){
		            	bandera = rs.getInt("_resultado");
		            }
		            if(bandera > 0) {
		            	return true;
		            }
		        } catch (SQLException ex) {
		        	 System.out.println("Error al Ingresar Clientes Naturales " + ex.toString());
		        }finally{
		            cnn.cerrarConexion();
		        }
			return false;
		}
		
		public Natural buscar(Natural n) {
	        PreparedStatement ps;
	        ResultSet rs;
	        try {
	            ps = cnn.getCnn().prepareStatement(SQL_BUSCAR);
	            ps.setString(1, n.getPerRut());
	            rs = ps.executeQuery();
	            while(rs.next()){
	            	n.setPerRut(rs.getString("RUT"));
	            	n.setPerNombre(rs.getString("NOMBRE"));
	            	n.setPerApePaterno(rs.getString("PATERNO"));
	            	n.setPerApeMaterno(rs.getString("MATERNO"));
	            	n.setPerNacionalidad(rs.getString("NACIONALIDAD"));
	            	n.setPerFecNacimiento(rs.getString("NACIMIENTO"));
	            	n.setCliCategoria(rs.getString("CATEGORIA"));
	            	Ejecutivo e = new Ejecutivo();
	   	            e.setPerRut(rs.getString("EJECUTIVO"));
	   	            n.setEje(e);
	            	n.setNatPatrimonio(rs.getInt("PATRIMONIO"));
	            }
	        } catch (SQLException ex) {
	            	System.out.println("Error al Depositar en Cuenta " + ex.toString());     
	       }finally{
	           cnn.cerrarConexion();
	       }
	       return n;
	   }
		
		
		public ArrayList<Natural> listar() {		    
			PreparedStatement ps;
			ResultSet rs;
	        ArrayList<Natural> naturales= new ArrayList<>(); 
		    try {
		    	ps = cnn.getCnn().prepareStatement(SQL_LISTAR);
		        rs = ps.executeQuery();
		        while(rs.next()){
		            Natural n = new Natural();
		            n.setPerRut(rs.getString("RUT"));
		            n.setPerNombre(rs.getString("NOMBRE"));
		            n.setPerApePaterno(rs.getString("PATERNO"));
		            n.setPerApeMaterno(rs.getString("MATERNO"));
		            n.setPerNacionalidad(rs.getString("NACIONALIDAD"));
		            n.setPerFecNacimiento(rs.getString("NACIMIENTO"));
		            n.setCliCategoria(rs.getString("CATEGORIA"));
		            Ejecutivo e = new Ejecutivo();
		            e.setPerRut(rs.getString("EJECUTIVO"));
		            n.setEje(e);
		            n.setNatPatrimonio(rs.getInt("PATRIMONIO"));
		            naturales.add(n);
	            }
	        } catch (SQLException ex) {
	            System.out.println("Error al listar Clientes Naturales "+ ex.toString());
	        } finally {
				cnn.cerrarConexion();
			}
	        return naturales;
		}
	
}


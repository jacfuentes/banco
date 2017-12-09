package ModeloDao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import Modelo.cliente;
import Modelo.cuenta;
import Modelo.ejecutivo;


public class CuentaDao {
	private static final String SQL_INGRESAR = 
			"call banco.sp_ingresar_cuenta(?, ?, ?);";
	private static final String SQL_ACTUALIZAR_SALDO=
			"UPDATE cuenta SET cueSaldo = ? WHERE cueId= ?;";
	private static final String SQL_BUSCAR=
			"SELECT cueId, cueSaldo, cueFecApertura, cueEstado, cueSobregiro, cliente_persona_perRut FROM banco.cuenta WHERE cueId = ?";
	private static final String SQL_BLOQUEAR = 
			"call banco.sp_bloquear_cuenta(?);";
	private static final String SQL_ELIMINAR = 
			"call banco.sp_eliminar_cuenta(?);";
	
	private static final String SQL_LISTAR = 
			"SELECT * FROM banco.vw_listar_cuentas;";
	
	private static final Conexion cnn = Conexion.saberEstado();
	
	
	public boolean ingresar(cuenta c){
		CallableStatement cs;
		ResultSet rs;
		int bandera=0;
	        try {
	        	cs = cnn.getCnn().prepareCall(SQL_INGRESAR);
	        	cs.setString(1, c.getCliente().getPerRut());
	            cs.setInt(2, c.getCueSaldo());
	            cs.setInt(3, c.getCueSobreGiro());
	            rs = cs.executeQuery();
	            while(rs.next()){
	            	bandera = rs.getInt("_resultado");
	            }
	            if(bandera > 0) {
	            	return true;
	            }
	        } catch (SQLException ex) {
	        	 System.out.println("Error al Ingresar Cuenta " + ex.toString());
	        }finally{
	            cnn.cerrarConexion();
	        }
		return false;
	}
	
	public boolean actualizarSaldo(cuenta c) {
        PreparedStatement ps;
        int bandera;
        try {
            ps=cnn.getCnn().prepareStatement(SQL_ACTUALIZAR_SALDO);
            ps.setInt(1,c.getCueSaldo());
            ps.setInt(2,c.getCueId());
            bandera=ps.executeUpdate();
            if(bandera>0){
                return true;
            }
        } catch (SQLException ex) {
        	System.out.println("Error al Depositar en Cuenta " + ex.toString());	   
    	}finally{
                cnn.cerrarConexion();
          }
        return false;
   }
	
	public cuenta buscar(cuenta c) {
		PreparedStatement ps;
        ResultSet rs;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_BUSCAR);
            ps.setInt(1, c.getCueId());
            rs = ps.executeQuery();
            c.setCueId(0);
            while(rs.next()){
            	c.setCueId(rs.getInt("cueId"));
            	c.setCueSaldo(rs.getInt("cueSaldo"));
            	c.setCueFecApertura(rs.getString("cueFecApertura"));
            	c.setCueEstado(rs.getString("cueEstado"));
            	c.setCueSobreGiro(rs.getInt("cueSobregiro"));
            	cliente cli = new cliente();
   	            cli.setPerRut(rs.getString("cliente_persona_perRut"));
   	            c.setCliente(cli);
            }
        } catch (SQLException ex) {
            	System.out.println("Error al Depositar en Cuenta " + ex.toString());     
        } finally {
            cnn.cerrarConexion();
        }
        return c;
   }
	   
	  
	public boolean bloquear(cuenta c){
		CallableStatement cs;
		ResultSet rs;
		int bandera=0;
	        try {
	        	cs = cnn.getCnn().prepareCall(SQL_BLOQUEAR);
	        	cs.setInt(1, c.getCueId());
	            rs = cs.executeQuery();
	            while(rs.next()){
	            	bandera = rs.getInt("_resultado");
	            }
	            if(bandera > 0) {
	            	return true;
	            }
	        } catch (SQLException ex) {
	        	 System.out.println("Error al Bloquear Cuenta " + ex.toString());
	        }finally{
	            cnn.cerrarConexion();
	        }
		return false;
	}
	
	public boolean eliminar(cuenta c){
		CallableStatement cs;
		ResultSet rs;
		int bandera=0;
	        try {
	        	cs = cnn.getCnn().prepareCall(SQL_ELIMINAR);
	        	cs.setInt(1, c.getCueId());
	            rs = cs.executeQuery();
	            while(rs.next()){
	            	bandera = rs.getInt("_resultado");
	            }
	            if(bandera > 0) {
	            	return true;
	            }
	        } catch (SQLException ex) {
	        	 System.out.println("Error al Eliminar Cuenta " + ex.toString());
	        }finally{
	            cnn.cerrarConexion();
	        }
		return false;
	}
	
	public ArrayList<cuenta> listar() {		    
		PreparedStatement ps;
		ResultSet rs;
        ArrayList<cuenta> cuentas= new ArrayList<>(); 
	    try {
	    	ps = cnn.getCnn().prepareStatement(SQL_LISTAR);
	        rs = ps.executeQuery();
	        while(rs.next()){
	        	cliente c=new cliente();
	        	c.setPerRut(rs.getString("RUT"));
	        	c.setPerNombre(rs.getString("NOMBRE"));
	            c.setPerApePaterno(rs.getString("PATERNO"));
	            c.setPerApeMaterno(rs.getString("MATERNO"));
	            c.setPerNacionalidad(rs.getString("NACIONALIDAD"));
	            c.setPerFecNacimiento(rs.getString("NACIMIENTO"));
	            c.setCliCategoria(rs.getString("CATEGORIA"));
	            ejecutivo e = new ejecutivo();
	            e.setPerRut(rs.getString("EJECUTIVO"));
	            c.setEje(e);
	            cuenta cu = new cuenta();
	            cu.setCueId(rs.getInt("NUMERO_CUENTA"));
	            cu.setCueSaldo(rs.getInt("SALDO"));
	            cu.setCueEstado(rs.getString("ESTADO"));
	            cu.setCueSobreGiro(rs.getInt("SOBREGIRO"));
	            cuentas.add(cu);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar Clientes Naturales "+ ex.toString());
        } finally {
			cnn.cerrarConexion();
		}
        return cuentas;
	}

	public void buscar_cuentas(cuenta cu) {
		// TODO Auto-generated method stub
		
	}

	public void listarnaturales() {
		// TODO Auto-generated method stub
		
	}

	public void listarjuridicos() {
		// TODO Auto-generated method stub
		
	}

	public void transaccion(cuenta cu) {
		// TODO Auto-generated method stub
		
	}

	
	
}
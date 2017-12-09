package ModeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import Modelo.cliente;
import Modelo.ejecutivo;
import Modelo.juridico;
import Modelo.natural;

public class ClienteDao {
	private static final String SQL_BUSCAR=
			"SELECT * FROM banco.vw_listar_clientes WHERE RUT LIKE ?";
	private static final String SQL_LISTAR = 
			"SELECT * FROM banco.vw_listar_clientes;";
	
	private static final String SQL_BUSCAR_TIPO=
			"call banco.sp_buscar_cliente(?)";
	
	private static final Conexion cnn = Conexion.saberEstado();	
	
	
    public cliente buscar(cliente c) {
        PreparedStatement ps;
        ResultSet rs;
        ejecutivo e;
        try {
            ps = cnn.getCnn().prepareStatement(SQL_BUSCAR);
            ps.setString(1, c.getPerRut());
            rs = ps.executeQuery();
            c.setPerRut("");
            while(rs.next()){
            	e = new ejecutivo();
                c.setPerRut(rs.getString("RUT"));
                c.setPerNombre(rs.getString("NOMBRE"));
                c.setPerApePaterno(rs.getString("PATERNO"));
                c.setPerApeMaterno(rs.getString("MATERNO"));
                c.setPerNacionalidad(rs.getString("NACIONALIDAD"));
                c.setPerFecNacimiento(rs.getString("NACIMIENTO"));
                c.setCliCategoria(rs.getString("CATEGORIA"));
                e.setPerRut(rs.getString("EJECUTIVO"));
                c.setEje(e);
            }
        } catch (SQLException ex) {
        	System.out.println("Error al buscar Clientes "+ ex.toString());
        }finally{
            cnn.cerrarConexion();
        }
        return c;
    }
	
	public cliente buscar_tipo(cliente c) {
		PreparedStatement ps;
        ResultSet rs;
        natural n;
        juridico j;
        try {
        	ps = cnn.getCnn().prepareStatement(SQL_BUSCAR_TIPO);
        	ps.setString(1, c.getPerRut());
            rs = ps.executeQuery();
            while(rs.next()){
            	String tipo = rs.getString("TIPO");
            	switch (tipo) {
				case "NATURAL":
					n = new natural();
					n.setPerRut(rs.getString("RUT"));
		            n.setPerNombre(rs.getString("NOMBRE"));
		            n.setPerApePaterno(rs.getString("PATERNO"));
		            n.setPerApeMaterno(rs.getString("MATERNO"));
		            n.setPerNacionalidad(rs.getString("NACIONALIDAD"));
		            n.setPerFecNacimiento(rs.getString("NACIMIENTO"));
		            n.setCliCategoria(rs.getString("CATEGORIA"));
		            ejecutivo ej = new ejecutivo();
		            ej.setPerRut(rs.getString("EJECUTIVO"));
		            n.setEje(ej);
		            n.setNatPatrimonio(rs.getInt("PATRIMONIO"));
		            return n;
				case "JURIDICO":
					j = new juridico();
					j.setPerRut(rs.getString("RUT"));
		            j.setPerNombre(rs.getString("NOMBRE"));
		            j.setPerApePaterno(rs.getString("PATERNO"));
		            j.setPerApeMaterno(rs.getString("MATERNO"));
		            j.setPerNacionalidad(rs.getString("NACIONALIDAD"));
		            j.setPerFecNacimiento(rs.getString("NACIMIENTO"));
		            j.setCliCategoria(rs.getString("CATEGORIA"));
		            ejecutivo eje = new ejecutivo();
		            eje.setPerRut(rs.getString("EJECUTIVO"));
		            j.setEje(eje);
		            j.setJurRazSocial(rs.getString("RAZON_SOCIAL"));
					return j;
            	}
            }
        } catch (SQLException ex) {
            System.out.println("Error al buscar Clientes "+ ex.toString());
        }finally{
        	cnn.cerrarConexion();
        }
        return null;
    }
	
	public ArrayList<cliente> listar() {		    
		PreparedStatement ps;
		ResultSet rs;
        ArrayList<cliente> clientes= new ArrayList<>(); 
	    try {
	    	ps = cnn.getCnn().prepareStatement(SQL_LISTAR);
	        rs = ps.executeQuery();
	        while(rs.next()){
	        	cliente c = new cliente(); 
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
	            clientes.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar Clientes Naturales "+ ex.toString());
        } finally {
			cnn.cerrarConexion();
		}
        return clientes;
	}
	
}

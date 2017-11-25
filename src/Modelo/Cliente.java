package Modelo;

public class Cliente extends Persona{
	protected String cliCategoria;
	protected Ejecutivo Eje;
	
	public Cliente() { super();
	}

	public Cliente(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perNacionalidad,
			String perFecNacimiento, String cliCategoria, Ejecutivo eje) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perNacionalidad, perFecNacimiento);
		this.cliCategoria = cliCategoria;
		Eje = eje;
	}

	public String getCliCategoria() {
		return cliCategoria;
	}

	public void setCliCategoria(String cliCategoria) {
		this.cliCategoria = cliCategoria;
	}

	public Ejecutivo getEje() {
		return Eje;
	}

	public void setEje(Ejecutivo eje) {
		Eje = eje;
	}

	@Override
	public String toString() {
		return "Cliente [cliCategoria=" + cliCategoria + ", Eje=" + Eje + "]";
	}
	
	
	
	
	
	


}
package Modelo;

public class cliente extends persona{
	protected String cliCategoria;
	protected ejecutivo eje;
	
	public cliente() { super();
	}

	public cliente(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perNacionalidad,
			String perFecNacimiento, String cliCategoria, ejecutivo eje) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perNacionalidad, perFecNacimiento);
		this.cliCategoria = cliCategoria;
		this.eje = eje;
	}

	public String getCliCategoria() {
		return cliCategoria;
	}

	public void setCliCategoria(String cliCategoria) {
		this.cliCategoria = cliCategoria;
	}

	public ejecutivo getEje() {
		return eje;
	}

	public void setEje(ejecutivo eje) {
		this.eje = eje;
	}

	@Override
	public String toString() {
		return "cliente [cliCategoria=" + cliCategoria + ", eje=" + eje + "]";
	}




}
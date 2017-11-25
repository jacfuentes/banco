package Modelo;

public final class Natural extends Cliente{
	private Integer natPatrimonio;

	public Natural() {
	}

	public Natural(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perNacionalidad,
			String perFecNacimiento, String cliCategoria, Ejecutivo eje, Integer natPatrimonio) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perNacionalidad, perFecNacimiento, cliCategoria, eje);
		this.natPatrimonio = natPatrimonio;
	}

	public Integer getNatPatrimonio() {
		return natPatrimonio;
	}

	public void setNatPatrimonio(Integer natPatrimonio) {
		this.natPatrimonio = natPatrimonio;
	}

	@Override
	public String toString() {
		return "Natural [natPatrimonio=" + natPatrimonio + ", cliCategoria=" + cliCategoria + ", Eje=" + Eje + "]";
	}


	
}
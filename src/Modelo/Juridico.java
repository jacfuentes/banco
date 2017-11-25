package Modelo;

public final class Juridico extends Cliente{
	private String jurRazSocial;

	public Juridico() { super();
	}

	public Juridico(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perNacionalidad,
			String perFecNacimiento, String cliCategoria, Ejecutivo eje, String jurRazSocial) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perNacionalidad, perFecNacimiento, cliCategoria, eje);
		this.jurRazSocial = jurRazSocial;
	}

	public String getJurRazSocial() {
		return jurRazSocial;
	}

	public void setJurRazSocial(String jurRazSocial) {
		this.jurRazSocial = jurRazSocial;
	}

	@Override
	public String toString() {
		return "Juridico [jurRazSocial=" + jurRazSocial + ", cliCategoria=" + cliCategoria + ", Eje=" + Eje + "]";
	}



}
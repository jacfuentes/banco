package Modelo;

public final class juridico extends cliente{
	private String jurRazSocial;

	public juridico() { super();
	}

	public juridico(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perNacionalidad,
			String perFecNacimiento, String cliCategoria, ejecutivo eje, String jurRazSocial) {
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
		return "juridico [jurRazSocial=" + jurRazSocial + ", cliCategoria=" + cliCategoria + ", eje=" + eje + "]";
	}



}
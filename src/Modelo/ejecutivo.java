package Modelo;

public final class ejecutivo extends persona{
	private String ejeFecContrato;

	public ejecutivo() {
		super();
	}

	public ejecutivo(String perRut, String perNombre, String perApePaterno, String perApeMaterno,
			String perNacionalidad, String perFecNacimiento, String ejeFecContrato) {
		super(perRut, perNombre, perApePaterno, perApeMaterno, perNacionalidad, perFecNacimiento);
		this.ejeFecContrato = ejeFecContrato;
	}

	public String getEjeFecContrato() {
		return ejeFecContrato;
	}

	public void setEjeFecContrato(String ejeFecContrato) {
		this.ejeFecContrato = ejeFecContrato;
	}

	@Override
	public String toString() {
		return "ejecutivo [ejeFecContrato=" + ejeFecContrato + "]";
	}



}
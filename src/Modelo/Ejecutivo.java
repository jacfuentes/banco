package Modelo;

public final class Ejecutivo extends Persona{
	private String ejeFecContrato;

	public Ejecutivo() { super();
	}

	public Ejecutivo(String perRut, String perNombre, String perApePaterno, String perApeMaterno,
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
		return "Ejecutivo [ejeFecContrato=" + ejeFecContrato + "]";
	}
	

}
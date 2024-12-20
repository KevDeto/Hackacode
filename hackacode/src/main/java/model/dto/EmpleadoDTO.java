package model.dto;

import java.util.Date;

public class EmpleadoDTO extends PersonaDTO {
	private String cargo;
	private double sueldo;

	public EmpleadoDTO(String nombre, String apellido, String direccion, String dni, Date fecha_nac,
			String nacionalidad, String celular, String email, String cargo, double sueldo) {
		super(nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);
		this.cargo = cargo;
		this.sueldo = sueldo;
	}
	
	public EmpleadoDTO() {
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

}

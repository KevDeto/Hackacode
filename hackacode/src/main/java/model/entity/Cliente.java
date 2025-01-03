package model.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Persona{
	private static final long serialVersionUID = 1L;

	public Cliente(String nombre, String apellido, String direccion, String dni, Date fecha_nac, String nacionalidad,
			String celular, String email) {
		super(nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email);
	}

	public Cliente() {
	}
}

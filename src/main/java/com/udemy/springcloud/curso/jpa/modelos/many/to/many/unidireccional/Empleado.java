package com.udemy.springcloud.curso.jpa.modelos.many.to.many.unidireccional;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_id_empleado")
	private Integer id;

	@Column(name = "c_nombre")
	private String nombre;

	@Column(name = "c_apellidos")
	private String apellidos;

	/**
	 * Distintos empleados pueden participar en la misma patente
	 * En el mapeo de la relación se crea una tabla join llamada EMPLEADO_PATENTE 
	 * con las dos claves ajenas hacia EMPLEADO y PATENTE.
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Patente> proyectos = new HashSet<>();
	
	

}

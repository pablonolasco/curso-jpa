package com.udemy.springcloud.curso.jpa.modelos.many.to.many.bidireccional;

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

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Proyecto> proyectos;
	
	/*
	 * En el caso de ya existir la tabla join, o de necesitar un nombre específico para sus elementos, 
	 * podríamos utilizar la anotación @JoinTable de la siguiente forma:
	 * @ManyToMany
	 * 
	 * @ManyToMany
	 * 
	 * @JoinTable( name = "EMPLEADO_PROYECTO", joinColumns = {@JoinColumn(name =
	 * "EMPLEADO_NOMBRE")}, inverseJoinColumns = {@JoinColumn(name =
	 * "PROYECTO_CODIGO")} )
	 * 
	 * La anotación joinColumns hace referencia a la columna de la tabla join que contiene el identificador 
	 * (o identificadores, en el caso de una clave compuesta) a la propia entidad 
	 * (Empleado en este caso). La anotación inverseJoinColumns identifica la columna que hace referencia 
	 * a la otra entidad (Proyecto).
	 */

}

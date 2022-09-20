package com.udemy.springcloud.curso.jpa.modelos.one.many.one.bidireccional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	//Muchos Empleados pertenece a un único Departamento
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "despacho_id_i", referencedColumnName = "i_id_despacho")
	private Despacho despacho;
	
}

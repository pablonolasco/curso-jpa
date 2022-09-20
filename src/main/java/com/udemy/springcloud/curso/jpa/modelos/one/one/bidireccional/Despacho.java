package com.udemy.springcloud.curso.jpa.modelos.one.one.bidireccional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "despachos")
public class Despacho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_id_despacho")
	private Integer id;
	
	@Column(name = "c_nombre")
	private String nombre;
	
	// De esta forma estamos indicando que la entidad Empleado 
	// es la propietaria de la relación y que contiene la clave ajena en el atributo despacho.
	@OneToOne(mappedBy = "despacho",fetch = FetchType.LAZY)
	private Empleado empleado;
	

}

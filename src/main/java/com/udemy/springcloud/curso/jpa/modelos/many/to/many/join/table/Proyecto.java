package com.udemy.springcloud.curso.jpa.modelos.many.to.many.join.table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "proyecto")
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_id_proyecto")
	private Integer id;
	
	@Column(name = "c_nombre")
	private String nombre;
	
	
	@ManyToMany(mappedBy = "proyectos",fetch = FetchType.LAZY)
	private Set<Empleado> empleado = new HashSet<>();
	

}

package com.udemy.springcloud.curso.jpa.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "autores")
@AllArgsConstructor
@Data
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AutorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_id_autor")
	private Integer id;
	
	@Basic(optional = false)
	@Column(name = "c_nombre", length = 50, nullable = false)
	private String nombre;
	
	@Basic(optional = true)
	@Column(name = "c_correo", length = 50, nullable = false, unique = true)
	private String correo;
	
	// un autor tiene muchos mensajes
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<MensajeEntity>mensajes= new ArrayList<>();
	
	
	

}

package com.udemy.springcloud.curso.jpa.modelos;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "mensajes")
@AllArgsConstructor
@Data
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MensajeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "i_id_mensajes")
	private Integer id;
	
	@Basic(optional = false)
	@Column(name = "c_texto", length = 255, nullable = false)
	private String texto;
	@Basic(optional = true)
	
	@Column(name = "d_fecha_alta", length = 255, nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha; 
	
	// muchos mensajes pueden tener el mismo autor
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "autor_i_id", referencedColumnName ="i_id_autor")
	@JsonBackReference
	private AutorEntity autor;

}

package com.udemy.springcloud.curso.jpa.modelos.many.to.many.join.table;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "proyecto_empleado")
public class ProyectoEmpleado {
	 @Embeddable
	    public static class Id implements Serializable {
	 
	        @Column(name = "PROYECTO_ID")
	        private int proyectoId;
	 
	        @Column(name = "EMPLEADO_ID")
	        private int empleadoId;
	 
	        public Id() {}
	 
	        public Id(int proyectoId, int empleadoId) {
	            this.proyectoId = proyectoId;
	            this.empleadoId = empleadoId;
	        }
	        public boolean equals(Object o) {
	            if (o != null && o instanceof Id) {
	                Id that = (Id) o;
	                return this.proyectoId.equals(that.proyectoId) &&
	                       this.empleadoId.equals(that.empleadoId);
	            } else {
	                return false;
	            }
	        }
	 
	        public int hashCode() {
	            return proyectoId.hashCode() + empleadoId.hashCode();
	        }
	    }
	 
	    @EmbeddedId
	    private Id id = new Id();
	 
	    @Column(name = "FECHA")
	    private Date fecha = new Date();
	 
	    @Column(name = "CARGO")
	    private String cargo;
	 
	    @ManyToOne
	    @JoinColumn(name="PROYECTO_ID",
	                insertable = false,
	                updatable = false)
	    private Proyecto proyecto;
	 
	    @ManyToOne
	    @JoinColumn(name="EMPLEADO_ID",
	                insertable = false,
	                updatable = false)
	    private Empleado empleado;
	 
	    public ProyectoEmpleado() {}
	 
	    public ProyectoEmpleado(Proyecto proyecto,
	                            Empleado emplado,
	                            String cargo) {
	        // Set fields
	        this.proyecto = proyecto;
	        this.empleado = empleado;
	        this cargo = cargo;
	 
	        // Set identifier values
	        this.id.proyectoId = proyecto.getId();
	        this.id.empleadoId = empleado.getId();
	 
	        // Guarantee referential integrity in memory
	        proyecto.getEmpleado().add(this);
	        empleado.getProyectos().add(this);
	    }
}

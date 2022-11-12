package com.springboot.app.gestionsalones.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tipo_inventario")
public class TipoInventario implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_inventario;
	private String nombre;
	
	public TipoInventario() {}
	
	public TipoInventario(String nombre) {
		this.nombre = nombre;
	}

	private static final long serialVersionUID = 1L;
}
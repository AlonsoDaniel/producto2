package com.backend.producto2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menus")
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_menu;
		
	@Column
	private Integer precio;
	
	public Integer getId_menu() {
		return id_menu;
	}
	public void setId_menu(Integer id_menu) {
		this.id_menu = id_menu;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

}

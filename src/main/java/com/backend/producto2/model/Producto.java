package com.backend.producto2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_producto;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;		
	
	@Column
	private int kcal;		
	
	@ManyToOne
    @JoinColumn(name = "tipo", nullable = false)
    private Tipo tipo;
	
	//@ManyToOne
    //@JoinColumn(name = "menu", nullable = false)
    //private Menu menu;
	
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	//public Menu getMenu() {
		//return menu;
	//}
	//public void setMenu(Menu menu) {
		//this.menu = menu;
	//}		
}

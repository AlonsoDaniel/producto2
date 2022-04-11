package com.backend.producto2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.backend.producto2.model.Producto;
import com.backend.producto2.model.Tipo;
//import com.backend.producto2.model.Menu;
import com.backend.producto2.repo.IProductoRepo;
import com.backend.producto2.repo.ITipoRepo;
//import com.backend.producto2.repo.IMenuRepo;

	
@Controller
public class ProductosController {
	
	@Autowired
	private IProductoRepo producto_repo;
	
	@Autowired
	private ITipoRepo tipo_repo;
	
	//@Autowired
	//private IMenuRepo menu_repo;
	
	@GetMapping("/productos/listar")
	public String listarProductos(Model model) 
	{		
		//Listamos todos los productos
		List<Producto> producto = producto_repo.findAll();
		
		//Le pasamos la lista de objetos a la vista
		model.addAttribute("producto", producto);
				
		return "/productos/listar";		
	}
	
	
	@GetMapping("/productos/registrar")
    public String registrarProducto(Model model) 
	{	
		//Definimos lista de objetos a pasar a la vista		
		List<Tipo> tipo = tipo_repo.findAll();	
		
		//Le pasamos la lista de objetos a la vista
        model.addAttribute("tipo", tipo);
        
      //Definimos lista de objetos a pasar a la vista		
      		//List<Menu> menu = menu_repo.findAll();	
      		
      	//Le pasamos la lista de objetos a la vista
              //model.addAttribute("menu", menu);
        
        //Creamos objeto producto 
		Producto producto = new Producto();
		
		//Le pasamos el objeto a la vista 
        model.addAttribute("producto", producto);
         
        return "/productos/registrar";        
    }
	
	
	@PostMapping("/productos/registrar")
	public String submitForm(@ModelAttribute("producto") Producto producto) 
	{	
	    
		producto_repo.save(producto);

	    return "redirect:/productos/listar";
	}
	
	
    @GetMapping("/productos/actualizar/{id}")
    public String actualizarProducto(@PathVariable(value = "id") int id, Model model) 
	{		
		//Definimos lista de objetos a pasar a la vista		
		List<Tipo> tipo = tipo_repo.findAll();		
		
		//Le pasamos la lista de objetos a la vista
        model.addAttribute("tipo", tipo);
        
      //Definimos lista de objetos a pasar a la vista		
  		//List<Menu> menu = menu_repo.findAll();	
  		
  		//Le pasamos la lista de objetos a la vista
        //model.addAttribute("menu", menu);
        
        //Creamos objeto producto
        Producto producto = producto_repo.getById(id);
        
		//Le pasamos el objeto a la vista 
        model.addAttribute("producto", producto);
         
        return "/productos/actualizar";        
    }
	
        
	@PostMapping("/productos/actualizar")
	public String actualizarProd(@ModelAttribute("producto") Producto producto)    
	{	    			
		Producto productoDb = producto_repo.getById(producto.getId_producto()) ;
		productoDb.setNombre(producto.getNombre());
		productoDb.setDescripcion(producto.getDescripcion());
		productoDb.setTipo(producto.getTipo());
		productoDb.setKcal(producto.getKcal());
		//productoDb.setMenu(producto.getMenu());
			
		
		producto_repo.save(productoDb);
																	
    return "redirect:/productos/listar";
	}
	
	@GetMapping("/productos/confirmar/{id}")
    public String ConfirmarPorId(@PathVariable(value = "id") int id, Model model) 
	{
		Producto producto = producto_repo.getById(id) ;
		model.addAttribute("producto", producto );		        
        
        return "/productos/confirmar";
	}
	
	
	@GetMapping("/productos/borrar/{id}")
    public String borrarPorId(@PathVariable(value = "id") int id) 
	{
        producto_repo.deleteById(id);
        return "redirect:/productos/listar";
       
	}
	

}




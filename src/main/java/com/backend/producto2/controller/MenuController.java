package com.backend.producto2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.backend.producto2.model.Menu;
import com.backend.producto2.repo.IMenuRepo;



@Controller
public class MenuController {
						
	
	@Autowired
	private IMenuRepo menu_repo;
	
	@GetMapping("/menus/listar")
	public String listarMenu(Model model) 
	{		
		//Listamos todos los productos
		List<Menu> menu = menu_repo.findAll();		
		
		//Le pasamos la lista de objetos a la vista
		model.addAttribute("menu", menu);
				
		return "/menus/listar";		
	}
	
	
		@GetMapping("/menus/registrar")
	    public String solicitarForm(Model model) 
		{	
			//Instanciamos el objeto
			Menu menu = new Menu();
			
			//Le pasamos el objeto a la vista 
	        model.addAttribute("menu", menu);
	        
	        return "/menus/registrar";        
	    }
		
		
		@PostMapping("/menus/registrar")
		public String enviarForm(@ModelAttribute("menu") Menu menu) 
		{	
			//Registramos los cambios en la BBDD
			menu_repo.save(menu);
			
		    return "redirect:/menus/listar";
		}
		
						
	    @GetMapping("/menus/actualizar/{id}")
	    public String actualizarProducto(@PathVariable(value = "id") int id, Model model) 
		{		
					
	        //Hacemos select del objeto que queremos actualizar
	    	Menu menu = menu_repo.getById(id);
	    	System.out.println("El ID a actualizar es " + menu.getId_menu());
	        
			//Le pasamos el objeto a la vista 
	        model.addAttribute("menu", menu);
	         
	        return "/menus/actualizar";        
	    }
		
	        
		@PostMapping("/menus/actualizar")
		public String actualizarMenu(@ModelAttribute("menu") Menu menu)
	    
		{	    	
			
			Menu menuDb = menu_repo.getById(menu.getId_menu()) ;
			menuDb.setPrecio(menu.getPrecio());
			menu_repo.save(menuDb);
																			
			return "redirect:/menus/listar";
		}
		
		
		@GetMapping("/menus/confirmar/{id}")
	    public String ConfirmarPorId(@PathVariable(value = "id") int id, Model model) 
		{
			Menu menuDb = menu_repo.getById(id) ;
			model.addAttribute("menu", menuDb );
			
//	        tipo_repo.deleteById(id);
	        
	        return "/menus/confirmar";
	        //return "redirect:/";

		}
		
		@GetMapping("/menus/borrar/{id}")
	    public String borrarPorId(@PathVariable(value = "id") int id) 
		{
			
	        menu_repo.deleteById(id);
	        
	        //return " /tipos/listar";
	        return "redirect:/menus/listar";

		}

		

	}

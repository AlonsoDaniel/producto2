package com.backend.producto2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.backend.producto2.model.Tipo;
import com.backend.producto2.repo.ITipoRepo;



@Controller
public class TiposController {
						
	
	@Autowired
	private ITipoRepo tipo_repo;
	
	@GetMapping("/tipos/listar")
	public String listarTipos(Model model) 
	{		
		//Listamos todos los productos
		List<Tipo> tipo = tipo_repo.findAll();		
		
		//Le pasamos la lista de objetos a la vista
		model.addAttribute("tipo", tipo);
				
		return "/tipos/listar";		
	}
	
	
		@GetMapping("/tipos/registrar")
	    public String solicitarForm(Model model) 
		{	
			//Instanciamos el objeto
			Tipo tipo = new Tipo();
			
			//Le pasamos el objeto a la vista 
	        model.addAttribute("tipo", tipo);
	        
	        return "/tipos/registrar";        
	    }
		
		
		@PostMapping("/tipos/registrar")
		public String enviarForm(@ModelAttribute("tipo") Tipo tipo) 
		{	
			//Registramos los cambios en la BBDD
			tipo_repo.save(tipo);
			
		    return "redirect:/tipos/listar";
		}
		
						
	    @GetMapping("/tipos/actualizar/{id}")
	    public String actualizarProducto(@PathVariable(value = "id") int id, Model model) 
		{		
					
	        //Hacemos select del objeto que queremos actualizar
	        Tipo tipo = tipo_repo.getById(id);
	    	System.out.println("El ID a actualizar es " + tipo.getId_tipo());
	        
			//Le pasamos el objeto a la vista 
	        model.addAttribute("tipo", tipo);
	         
	        return "/tipos/actualizar";        
	    }
		
	        
		@PostMapping("/tipos/actualizar")
		public String actualizarTipo(@ModelAttribute("tipo") Tipo tipo)
	    
		{	    	
			
			Tipo tipoDb = tipo_repo.getById(tipo.getId_tipo()) ;
			tipoDb.setCategoria(tipo.getCategoria());
			tipo_repo.save(tipoDb);
																			
			return "redirect:/tipos/listar";
		}
		
		
		@GetMapping("/tipos/confirmar/{id}")
	    public String ConfirmarPorId(@PathVariable(value = "id") int id, Model model) 
		{
			Tipo tipoDb = tipo_repo.getById(id) ;
			model.addAttribute("tipo", tipoDb );
			
//	        tipo_repo.deleteById(id);
	        
	        return "/tipos/confirmar";
	        //return "redirect:/";

		}
		
		@GetMapping("/tipos/borrar/{id}")
	    public String borrarPorId(@PathVariable(value = "id") int id) 
		{
			
	        tipo_repo.deleteById(id);
	        
	        //return " /tipos/listar";
	        return "redirect:/tipos/listar";

		}

		

	}







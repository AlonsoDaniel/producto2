package com.backend.producto2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.producto2.model.Tipo;

@Repository ("ITipoRepo")
public interface ITipoRepo extends JpaRepository<Tipo, Integer>{
	
			

	

}

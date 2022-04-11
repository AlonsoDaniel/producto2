package com.backend.producto2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.producto2.model.Producto;

@Repository
public interface IProductoRepo extends JpaRepository<Producto, Integer>{
	
	

}


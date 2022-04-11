package com.backend.producto2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.producto2.model.Menu;

@Repository
public interface IMenuRepo extends JpaRepository<Menu, Integer>{

}

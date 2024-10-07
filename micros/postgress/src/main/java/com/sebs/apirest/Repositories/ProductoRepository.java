package com.sebs.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebs.apirest.Entities.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long> {

}

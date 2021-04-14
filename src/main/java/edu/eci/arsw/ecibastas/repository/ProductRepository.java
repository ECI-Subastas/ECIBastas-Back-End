package edu.eci.arsw.ecibastas.repository;

import edu.eci.arsw.ecibastas.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

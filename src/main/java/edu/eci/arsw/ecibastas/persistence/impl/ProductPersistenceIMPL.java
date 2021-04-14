package edu.eci.arsw.ecibastas.persistence.impl;

import edu.eci.arsw.ecibastas.model.Product;
import edu.eci.arsw.ecibastas.model.User;
import edu.eci.arsw.ecibastas.persistence.ProductPersistence;
import edu.eci.arsw.ecibastas.persistence.exceptions.ProductPersistenceException;
import edu.eci.arsw.ecibastas.persistence.exceptions.UserPersistenceException;
import edu.eci.arsw.ecibastas.repository.ProductRepository;
import edu.eci.arsw.ecibastas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ProductPersistenceIMPL implements ProductPersistence {
    @Autowired
    ProductRepository productRepository;

    @PersistenceContext
    EntityManager entityManager;

    public ProductPersistenceIMPL() {

    }


    @Override
    public void createNewProduct(Product product) throws ProductPersistenceException {
        try {
            productRepository.save(product);
        } catch (Exception e) {
            throw new ProductPersistenceException(e.getMessage().toString());
        }
    }
}

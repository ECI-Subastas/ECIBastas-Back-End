package edu.eci.arsw.ecibastas.services.impl;

import edu.eci.arsw.ecibastas.model.Product;
import edu.eci.arsw.ecibastas.persistence.ProductPersistence;
import edu.eci.arsw.ecibastas.persistence.exceptions.ProductPersistenceException;
import edu.eci.arsw.ecibastas.persistence.exceptions.UserPersistenceException;
import edu.eci.arsw.ecibastas.services.ProductService;
import edu.eci.arsw.ecibastas.services.exceptions.ProductServiceExceptions;
import edu.eci.arsw.ecibastas.services.exceptions.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceIMPL implements ProductService {
    @Autowired
    ProductPersistence productPersistence;

    public ProductServiceIMPL() {

    }

    @Override
    public void createNewProduct(Product product) throws ProductServiceExceptions {
        try {
            productPersistence.createNewProduct(product);
        } catch (ProductPersistenceException e) {
            throw new ProductServiceExceptions(e.getMessage());
        }
    }
}

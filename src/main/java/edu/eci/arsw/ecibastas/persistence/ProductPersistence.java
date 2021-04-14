package edu.eci.arsw.ecibastas.persistence;

import edu.eci.arsw.ecibastas.model.Product;
import edu.eci.arsw.ecibastas.model.User;
import edu.eci.arsw.ecibastas.persistence.exceptions.ProductPersistenceException;
import edu.eci.arsw.ecibastas.persistence.exceptions.UserPersistenceException;

public interface ProductPersistence {
    void createNewProduct(Product product) throws ProductPersistenceException;
}

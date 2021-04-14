package edu.eci.arsw.ecibastas.services;

import edu.eci.arsw.ecibastas.model.Product;
import edu.eci.arsw.ecibastas.persistence.exceptions.ProductPersistenceException;
import edu.eci.arsw.ecibastas.services.exceptions.ProductServiceExceptions;
import edu.eci.arsw.ecibastas.services.exceptions.UserServiceException;


public interface ProductService {
     void createNewProduct(Product product) throws ProductServiceExceptions;
     void changePriceInitial(String product, int price) throws UserServiceException, ProductPersistenceException, ProductServiceExceptions;
     Product getSubastaByProduct(String product) throws ProductServiceExceptions;
}

package edu.eci.arsw.ecibastas.services;

import edu.eci.arsw.ecibastas.model.Product;
import edu.eci.arsw.ecibastas.services.exceptions.ProductServiceExceptions;


public interface ProductService {
     void createNewProduct(Product product) throws ProductServiceExceptions;
}

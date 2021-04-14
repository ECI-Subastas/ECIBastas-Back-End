package edu.eci.arsw.ecibastas.persistence;

import edu.eci.arsw.ecibastas.model.Product;
import edu.eci.arsw.ecibastas.persistence.exceptions.ProductPersistenceException;

import java.util.List;

public interface ProductPersistence {
    void createNewProduct(Product product) throws ProductPersistenceException;

    Product getSubastaByProduct(String product) throws ProductPersistenceException;

    void changePriceInitial(String product, int price) throws ProductPersistenceException;

    List<Product> getProductsBySubasta(int subastaid) throws ProductPersistenceException;
}

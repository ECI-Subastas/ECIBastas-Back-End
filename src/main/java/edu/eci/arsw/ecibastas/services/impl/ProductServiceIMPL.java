package edu.eci.arsw.ecibastas.services.impl;

import edu.eci.arsw.ecibastas.model.Product;
import edu.eci.arsw.ecibastas.persistence.ProductPersistence;
import edu.eci.arsw.ecibastas.persistence.exceptions.ProductPersistenceException;
import edu.eci.arsw.ecibastas.services.ProductService;
import edu.eci.arsw.ecibastas.services.UserService;
import edu.eci.arsw.ecibastas.services.exceptions.ProductServiceExceptions;

import java.util.List;

import edu.eci.arsw.ecibastas.services.exceptions.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceIMPL implements ProductService {

    @Autowired
    ProductPersistence productPersistence;

    @Autowired
    UserService userService;

    public ProductServiceIMPL() {

    }

    @Override
    public Product getProductById(int productid) throws ProductServiceExceptions {
        try {
            return productPersistence.getProductById(productid);
        } catch (ProductPersistenceException e) {
            throw new ProductServiceExceptions(e.getMessage());
        }
    }

    @Override
    public void createNewProduct(Product product) throws ProductServiceExceptions {
        try {
            productPersistence.createNewProduct(product);
        } catch (ProductPersistenceException e) {
            throw new ProductServiceExceptions(e.getMessage());
        }
    }

    @Override
    public void changePriceInitial(String product, int price) throws ProductPersistenceException {
        try {
            productPersistence.changePriceInitial(product, price);
        } catch (ProductPersistenceException e) {
            throw new ProductPersistenceException(e.getMessage());
        }
    }

    @Override
    public Product getSubastaByProduct(String product) throws ProductServiceExceptions {
        try {
            return productPersistence.getSubastaByProduct(product);
        } catch (ProductPersistenceException e) {
            throw new ProductServiceExceptions(e.getMessage());
        }
    }

    @Override
    public List<Product> getProductsBySubasta(int subastaid) throws ProductServiceExceptions {
        try {
            return productPersistence.getProductsBySubasta(subastaid);
        } catch (ProductPersistenceException e) {
            throw new ProductServiceExceptions(e.getMessage());
        }
    }

    @Override
    public void productOwner(int productid, String nickname) throws ProductServiceExceptions {
        try {
            productPersistence.productOwner(productid,nickname);
        } catch (ProductPersistenceException e) {
            throw new ProductServiceExceptions(e.getMessage());
        }
    }

    @Override
    public void pujar(int productid, int credits, int userid) throws ProductServiceExceptions {
        try {
            Product product = getProductById(productid);
            if(product.getOwner_user() != null){
                userService.sumCredits(product.getOwner_user(),product.getActualprice());
            }

            productPersistence.pujarPersonalize(productid,credits,userid);

            userService.sumCredits(userid,credits*-1);

        } catch (ProductPersistenceException | UserServiceException e) {
            throw new ProductServiceExceptions(e.getMessage());
        }
    }


}

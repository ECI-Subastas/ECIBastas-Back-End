package edu.eci.arsw.ecibastas.persistence.impl;

import edu.eci.arsw.ecibastas.model.Product;
import edu.eci.arsw.ecibastas.model.User;
import edu.eci.arsw.ecibastas.persistence.ProductPersistence;
import edu.eci.arsw.ecibastas.persistence.exceptions.ProductPersistenceException;
import edu.eci.arsw.ecibastas.repository.ProductRepository;
import edu.eci.arsw.ecibastas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Service
public class ProductPersistenceIMPL implements ProductPersistence {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserService userService;

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

    @Override
    public Product getSubastaByProduct(String name) throws ProductPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from product where name=?", User.class);

            query.setParameter(1, name);

            if (query.getResultList().size() == 0) {
                throw new ProductPersistenceException(ProductPersistenceException.ERROR_USER_NOT_FOUND);
            }

            return (Product) query.getSingleResult();
        } catch (Exception e) {
            throw new ProductPersistenceException(ProductPersistenceException.ERROR_SEARCHING_USER);
        }
    }

    @Override
    public void changePriceInitial(String product, int price) throws ProductPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("update product set initialprice=? where product=? ",
                    Product.class);

            query.setParameter(1, price);
            query.setParameter(2, product);

            query.executeUpdate();
        } catch (Exception e) {
            throw new ProductPersistenceException(ProductPersistenceException.ERROR_CHANGING_USER_ROLE);
        }
    }

    @Override
    public List<Product> getProductsBySubasta(int subastaid) throws ProductPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from product where subasta=? order by product_id", Product.class);

            query.setParameter(1, subastaid);

            List<Product> resultado = query.getResultList();
            return resultado;
        } catch (Exception e) {
            throw new ProductPersistenceException(ProductPersistenceException.ERROR_CHANGING_USER_ROLE);
        }
    }

    @Override
    public void productOwner(int productid, String nickname) throws ProductPersistenceException{
        try {
            Query query = entityManager.createNativeQuery(
                    "update product set name=nickame  where product_id=?", Product.class);

            query.setParameter(1, productid);

            query.executeUpdate();
        } catch (Exception e) {
            throw new ProductPersistenceException(ProductPersistenceException.ERROR_USER_NOT_FOUND);
        }
    }


    @Override
    @Transactional
    public void pujarPersonalize(int productid, int credits, int userid) throws ProductPersistenceException {
        try {
            Query query = entityManager.createNativeQuery(
                    "update product set actualprice=actualprice+?, owner_user=? where product_id=?", Product.class);

            query.setParameter(1, credits);
            query.setParameter(2, userid);
            query.setParameter(3, productid);
            query.executeUpdate();
        } catch (Exception e) {
            throw new ProductPersistenceException(ProductPersistenceException.ERROR_USER_NOT_FOUND);
        }
    }

    @Override
    public Product getProductById(int productid) throws ProductPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from product where product_id=?", Product.class);
            query.setParameter(1, productid);
            return (Product) query.getSingleResult();
        } catch (Exception e) {
            throw new ProductPersistenceException(ProductPersistenceException.ERROR_CHANGING_USER_ROLE);
        }
    }
}

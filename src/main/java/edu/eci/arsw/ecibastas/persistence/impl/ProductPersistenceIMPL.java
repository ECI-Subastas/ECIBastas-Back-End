package edu.eci.arsw.ecibastas.persistence.impl;

import edu.eci.arsw.ecibastas.model.Product;
import edu.eci.arsw.ecibastas.model.User;
import edu.eci.arsw.ecibastas.persistence.ProductPersistence;
import edu.eci.arsw.ecibastas.persistence.exceptions.ProductPersistenceException;
import edu.eci.arsw.ecibastas.persistence.exceptions.UserPersistenceException;
import edu.eci.arsw.ecibastas.repository.ProductRepository;
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
    public Product getSubastaByProduct(String name) throws  ProductPersistenceException{
        try {
            Query query = entityManager.createNativeQuery("select * from product where name=?", User.class);

            query.setParameter(1, name);

            if (query.getResultList().size()==0) {
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
            Query query = entityManager.createNativeQuery("update product set initialprice=? where product=? ", Product.class);

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
            Query query = entityManager.createNativeQuery("select * from product where subasta=? ", Product.class);

            query.setParameter(1, subastaid);

            List<Product> resultado = query.getResultList();
            return resultado;
        } catch (Exception e) {
            throw new ProductPersistenceException(ProductPersistenceException.ERROR_CHANGING_USER_ROLE);
        }
    }

    @Override
    @Transactional
    public void pujarDefault(int idproduct) throws ProductPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("update product set actualprice=actualprice + 5 where product_id=?", Product.class);

            query.setParameter(1, idproduct);

            query.executeUpdate();
        } catch (Exception e) {
            throw new ProductPersistenceException(ProductPersistenceException.ERROR_USER_NOT_FOUND);
        }
    }
}

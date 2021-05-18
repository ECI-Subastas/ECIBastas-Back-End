package edu.eci.arsw.ecibastas.controllers;

import edu.eci.arsw.ecibastas.model.Product;
import edu.eci.arsw.ecibastas.persistence.exceptions.ProductPersistenceException;
import edu.eci.arsw.ecibastas.services.ProductService;
import edu.eci.arsw.ecibastas.services.exceptions.ProductServiceExceptions;
import edu.eci.arsw.ecibastas.services.exceptions.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ProductAPIController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product/ProductsBySubasta", method = RequestMethod.GET)
    public ResponseEntity<?> productsBySubasta(@RequestParam(name = "subastaid") Integer subastaid) {
        try {
            return new ResponseEntity<>(productService.getProductsBySubasta(subastaid), HttpStatus.ACCEPTED);
        } catch (ProductServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/product/createNewProduct", method = RequestMethod.POST)
    public ResponseEntity<?> createNewProduct(@RequestBody Product product) {
        try {
            productService.createNewProduct(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ProductServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/product/changePriceInitial", method = RequestMethod.POST)
    public ResponseEntity<?> changePriceInitial(@RequestParam(name = "product") String product,  @RequestParam(name = "price") int price) {
        try {
            productService.changePriceInitial(product,price);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (ProductServiceExceptions | UserServiceException | ProductPersistenceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "/product/subasta", method = RequestMethod.GET)
    public ResponseEntity<?> getSubastaByProduct(@RequestParam(name = "value") String nickname) {
        try {
            return new ResponseEntity<>(productService.getSubastaByProduct(nickname), HttpStatus.FOUND);
        } catch (ProductServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/product/pujarDefault", method = RequestMethod.PUT)
    public ResponseEntity<?> pujarDefault(@RequestParam(name = "productid") int productid) {
        try {
            productService.pujarDefault(productid);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (ProductServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "/product/pujarPersonalize", method = RequestMethod.PUT)
    public ResponseEntity<?> pujarPersonalize(@RequestParam(name = "productid") int productid, @RequestParam(name = "credits") int credits) {
        try {
            productService.pujarPersonalize(productid,credits);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (ProductServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "/product/productOwner", method = RequestMethod.PUT)
    public ResponseEntity<?> productOwner(@RequestParam(name = "productid") int productid,  @RequestParam(name = "nickname") String nickname) {
        try {
            //productService.pujarDefault(productid);
            productService.productOwner(productid,nickname);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (ProductServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }
}

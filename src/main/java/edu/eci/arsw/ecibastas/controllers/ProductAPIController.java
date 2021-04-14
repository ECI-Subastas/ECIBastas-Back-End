package edu.eci.arsw.ecibastas.controllers;

import edu.eci.arsw.ecibastas.model.Product;
import edu.eci.arsw.ecibastas.model.User;
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

    @RequestMapping(value = "/product/createNewProduct", method = RequestMethod.POST)
    public ResponseEntity<?> createNewProduct(@RequestBody Product product) {
        try {
            productService.createNewProduct(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ProductServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

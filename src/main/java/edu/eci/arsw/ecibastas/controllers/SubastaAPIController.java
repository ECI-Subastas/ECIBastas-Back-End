package edu.eci.arsw.ecibastas.controllers;

import edu.eci.arsw.ecibastas.model.Subasta;
import edu.eci.arsw.ecibastas.services.SubastaService;
import edu.eci.arsw.ecibastas.services.exceptions.ProductServiceExceptions;
import edu.eci.arsw.ecibastas.services.exceptions.SubastaServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SubastaAPIController {

    @Autowired
    SubastaService subastaService;

    @RequestMapping(value = "/subasta/createNewSubasta", method = RequestMethod.POST)
    public ResponseEntity<?> createNewSubasta(@RequestBody Subasta subasta) {
        try {
            subastaService.createNewSubasta(subasta);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SubastaServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/subasta/subastaName", method = RequestMethod.GET)
    public ResponseEntity<?> getSubastaByName(@RequestParam(name = "value") String name) {
        try {
            return new ResponseEntity<>(subastaService.getSubastaByName(name), HttpStatus.FOUND);
        } catch (SubastaServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/subasta/subastas", method = RequestMethod.GET)
    public ResponseEntity<?> getSubastas() {
        try {
            return new ResponseEntity<>(subastaService.getAllSubasta(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/auction/userAuctions", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUserAuctions(@RequestParam(name = "userId") int userId) {
        try {
            return new ResponseEntity<>(subastaService.getAllUserAuctions(userId), HttpStatus.FOUND);
        } catch (SubastaServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/subasta/setActive", method = RequestMethod.PUT)
    public ResponseEntity<?> setActive(@RequestParam(name = "active") Boolean active,@RequestParam(name = "subastaid") int subastaid) {
        try {
            subastaService.setActive(active,subastaid);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        } catch (SubastaServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }

    @RequestMapping(value = "/subasta/isActive", method = RequestMethod.GET)
    public ResponseEntity<?> isActive(@RequestParam(name = "subastaid") int subastaid) {
        try {
            return new ResponseEntity<>(subastaService.isActive(subastaid), HttpStatus.ACCEPTED);
        } catch (SubastaServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
        }
    }
}

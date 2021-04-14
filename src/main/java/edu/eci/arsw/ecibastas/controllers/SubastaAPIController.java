package edu.eci.arsw.ecibastas.controllers;

import edu.eci.arsw.ecibastas.model.Subasta;
import edu.eci.arsw.ecibastas.services.SubastaService;
import edu.eci.arsw.ecibastas.services.exceptions.SubastaServiceExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
        } catch (SubastaServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/subasta/subastaName", method = RequestMethod.GET)
    public ResponseEntity<?> getSubastaByName(@RequestParam(name = "value") String name) {
        try {
            return new ResponseEntity<>(subastaService.getSubastaByName(name), HttpStatus.FOUND);
        } catch ( SubastaServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/subasta/subastas", method = RequestMethod.GET)
    public ResponseEntity<?> getSubastas() {
        try {
            return new ResponseEntity<>(subastaService.getAllSubasta(), HttpStatus.ACCEPTED);
        } catch (SubastaServiceExceptions e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

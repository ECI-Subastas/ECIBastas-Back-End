package edu.eci.arsw.ecibastas.services;

import edu.eci.arsw.ecibastas.model.Subasta;
import edu.eci.arsw.ecibastas.services.exceptions.SubastaServiceExceptions;

import java.util.List;

public interface SubastaService {
    void createNewSubasta(Subasta subasta) throws SubastaServiceExceptions;
    List<Subasta> getAllSubasta() throws SubastaServiceExceptions;
    Subasta getSubastaByName(String name) throws SubastaServiceExceptions;

}

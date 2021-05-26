package edu.eci.arsw.ecibastas.services;

import edu.eci.arsw.ecibastas.model.Subasta;
import edu.eci.arsw.ecibastas.services.exceptions.SubastaServiceException;

import java.util.List;

public interface SubastaService {
    void createNewSubasta(Subasta subasta) throws SubastaServiceException;

    List<Subasta> getAllSubasta() throws Exception;

    Subasta getSubastaByName(String name) throws SubastaServiceException;

    List<Subasta> getAllUserAuctions(int userId) throws SubastaServiceException;

    void setActive(Boolean state, int subastaid) throws SubastaServiceException;

    boolean isActive(int auctionId) throws SubastaServiceException;
}

package edu.eci.arsw.ecibastas.persistence;

import edu.eci.arsw.ecibastas.model.Subasta;
import edu.eci.arsw.ecibastas.persistence.exceptions.SubastaPersistenceException;

import java.util.List;

public interface SubastaPersistence {
    void createNewSubasta(Subasta subasta) throws SubastaPersistenceException;

    List<Subasta> getAllSubasta() throws SubastaPersistenceException;

    Subasta getSubastaByName(String name) throws SubastaPersistenceException;

    List<Subasta> getAllUserAuctions(int userId) throws SubastaPersistenceException;

    void setActive(Boolean state, int subastaid) throws SubastaPersistenceException;

    boolean isActive(int auctionId) throws SubastaPersistenceException;
}

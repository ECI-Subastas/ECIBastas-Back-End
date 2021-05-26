package edu.eci.arsw.ecibastas.persistence.cache;

import java.util.List;

import edu.eci.arsw.ecibastas.model.Subasta;

public interface ECIBastasCache {
    List<Subasta> getAllAuctions() throws Exception;
    void deleteAuction(int auctionId) throws Exception;
    void putAuction(Subasta auction) throws Exception;
}

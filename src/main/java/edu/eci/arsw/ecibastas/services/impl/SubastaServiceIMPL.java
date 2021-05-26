package edu.eci.arsw.ecibastas.services.impl;

import edu.eci.arsw.ecibastas.model.Subasta;
import edu.eci.arsw.ecibastas.persistence.SubastaPersistence;
import edu.eci.arsw.ecibastas.persistence.exceptions.SubastaPersistenceException;
import edu.eci.arsw.ecibastas.services.SubastaService;
import edu.eci.arsw.ecibastas.services.exceptions.SubastaServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubastaServiceIMPL implements SubastaService {
    @Autowired
    SubastaPersistence subastaPersistence;

    public SubastaServiceIMPL() {

    }

    @Override
    public void createNewSubasta(Subasta subasta) throws SubastaServiceException {
        try {
            subastaPersistence.createNewSubasta(subasta);
        } catch (SubastaPersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Subasta> getAllSubasta() throws SubastaServiceException {
        try {
            return subastaPersistence.getAllSubasta();
        } catch (SubastaPersistenceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Subasta getSubastaByName(String name) throws SubastaServiceException {
        try {
            return subastaPersistence.getSubastaByName(name);
        } catch (SubastaPersistenceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Subasta> getAllUserAuctions(int userId) throws SubastaServiceException {
        try {
            return subastaPersistence.getAllUserAuctions(userId);
        } catch (SubastaPersistenceException e) {
            throw new SubastaServiceException(e.getMessage());
        }
    }

    @Override
    public void setActive(Boolean state, int subastaid) throws SubastaServiceException {
        try {
            subastaPersistence.setActive(state, subastaid);
        } catch (SubastaPersistenceException e) {
            throw new SubastaServiceException(e.getMessage());
        }
    }

    @Override
    public boolean isActive(int auctionId) throws SubastaServiceException {
        try {
            return subastaPersistence.isActive(auctionId);
        } catch (SubastaPersistenceException e) {
            throw new SubastaServiceException(e.getMessage());
        }
    }
}

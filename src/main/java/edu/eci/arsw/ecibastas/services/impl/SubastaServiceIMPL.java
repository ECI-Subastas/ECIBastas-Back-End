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
    SubastaPersistence SubastaPersistence;

    public SubastaServiceIMPL() {

    }

    @Override
    public void createNewSubasta(Subasta subasta) throws SubastaServiceException {
        try {
            SubastaPersistence.createNewSubasta(subasta);
        } catch (SubastaPersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Subasta> getAllSubasta() throws SubastaServiceException {
        try {
            return SubastaPersistence.getAllSubasta();
        } catch (SubastaPersistenceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Subasta getSubastaByName(String name) throws SubastaServiceException {
        try {
            return SubastaPersistence.getSubastaByName(name);
        } catch (SubastaPersistenceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Subasta> getAllUserAuctions(int userId) throws SubastaServiceException {
        try {
            return SubastaPersistence.getAllUserAuctions(userId);
        } catch (SubastaPersistenceException e) {
            throw new SubastaServiceException(e.getMessage());
        }
    }

    @Override
    public void setActive(Boolean state, int subastaid) throws SubastaServiceException {
        try {
            SubastaPersistence.setActive(state, subastaid);
        } catch (SubastaPersistenceException e) {
            throw new SubastaServiceException(e.getMessage());
        }
    }
}

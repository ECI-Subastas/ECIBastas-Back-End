package edu.eci.arsw.ecibastas.services.impl;

import edu.eci.arsw.ecibastas.model.Subasta;
import edu.eci.arsw.ecibastas.persistence.SubastaPersistence;
import edu.eci.arsw.ecibastas.persistence.cache.ECIBastasCache;
import edu.eci.arsw.ecibastas.persistence.exceptions.SubastaPersistenceException;
import edu.eci.arsw.ecibastas.services.SubastaService;
import edu.eci.arsw.ecibastas.services.exceptions.SubastaServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubastaServiceIMPL implements SubastaService {

    @Autowired
    SubastaPersistence subastaPersistence;

    @Autowired
    ECIBastasCache eciBastasCache;

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
    public List<Subasta> getAllSubasta() throws Exception {
        try {
            return eciBastasCache.getAllAuctions();
        } catch (SubastaPersistenceException e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Subasta getSubastaByName(String name) throws SubastaServiceException {
        try {
            return subastaPersistence.getSubastaByName(name);
        } catch (SubastaPersistenceException e) {
            throw new SubastaServiceException(e.getMessage());
        }
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

    @Scheduled(fixedDelay = 30000)
    public void resetHashOperation() throws Exception {
        List<Subasta> oldAuctions = eciBastasCache.getAllAuctions();

        for(int i = 0; i < oldAuctions.size(); i++){
            eciBastasCache.deleteAuction(oldAuctions.get(i).getSubastaId());
        }
        
        List<Subasta> newAuctions = subastaPersistence.getAllSubasta();
        
        for(int i = 0; i<newAuctions.size(); i++){
            eciBastasCache.putAuction(newAuctions.get(i));
        }
    }
}

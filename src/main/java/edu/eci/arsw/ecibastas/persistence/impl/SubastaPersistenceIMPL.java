package edu.eci.arsw.ecibastas.persistence.impl;

import edu.eci.arsw.ecibastas.model.Subasta;
import edu.eci.arsw.ecibastas.persistence.SubastaPersistence;
import edu.eci.arsw.ecibastas.persistence.exceptions.SubastaPersistenceException;
import edu.eci.arsw.ecibastas.repository.SubastaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class SubastaPersistenceIMPL implements SubastaPersistence {

    @Autowired
    SubastaRepository subastaRepository;

    @PersistenceContext
    EntityManager entityManager;

    public SubastaPersistenceIMPL() {
    }

    @Override
    public void createNewSubasta(Subasta subasta) throws SubastaPersistenceException {
        try {
            subastaRepository.save(subasta);
        } catch (Exception e) {
            throw new SubastaPersistenceException(SubastaPersistenceException.ERROR_CREATING_NEW_SUBASTA);
        }
    }

    @Override
    public List<Subasta> getAllSubasta() throws SubastaPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from subasta order by subasta_id", Subasta.class);
            List<Subasta> resultado = query.getResultList();
            return resultado;
        } catch (Exception e) {
            throw new SubastaPersistenceException(SubastaPersistenceException.ERROR_SEARCHING_SUBASTA);
        }
    }

    @Override
    public Subasta getSubastaByName(String name) throws SubastaPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from subasta where name=?", Subasta.class);
            query.setParameter(1, name);

            if (query.getResultList().size() == 0) {
                throw new SubastaPersistenceException(SubastaPersistenceException.ERROR_SEARCHING_SUBASTA);
            }

            return (Subasta) query.getSingleResult();
        } catch (Exception e) {
            throw new SubastaPersistenceException(SubastaPersistenceException.ERROR_SEARCHING_SUBASTA);
        }
    }
}

package edu.eci.arsw.ecibastas.repository;

import edu.eci.arsw.ecibastas.model.Subasta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubastaRepository extends JpaRepository<Subasta, Integer> {
    
}

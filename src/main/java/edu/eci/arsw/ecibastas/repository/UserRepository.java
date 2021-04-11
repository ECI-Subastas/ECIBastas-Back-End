package edu.eci.arsw.ecibastas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eci.arsw.ecibastas.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}

package edu.eci.arsw.ecibastas.persistence.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.ecibastas.model.User;
import edu.eci.arsw.ecibastas.persistence.UserPersistence;
import edu.eci.arsw.ecibastas.persistence.exceptions.UserPersistenceException;
import edu.eci.arsw.ecibastas.repository.UserRepository;

@Service
public class UserPersistenceIMPL implements UserPersistence {
    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    public UserPersistenceIMPL() {
        
    }

    @Override
    public void createNewUser(User user) throws UserPersistenceException {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new UserPersistenceException(e.getMessage().toString());
        }
    }

    @Override
    public void changeUserRole(String nickname, String email, String role) throws UserPersistenceException {
        try {
            Query query = entityManager.createQuery("update users set role=? where nickname=? and email=?", User.class);

            query.setParameter(1, role);
            query.setParameter(2, nickname);
            query.setParameter(3, email);
            
            query.executeUpdate();
        } catch (Exception e) {
            throw new UserPersistenceException(UserPersistenceException.ERROR_CHANGING_USER_ROLE);
        }
    }

    @Override
    public User getUserByNickname(String nickname) throws UserPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from users where nickname=?", User.class);

            query.setParameter(1, nickname);

            if (query.getResultList().size()==0) {
                throw new UserPersistenceException(UserPersistenceException.ERROR_USER_NOT_FOUND);
            }

            return (User) query.getSingleResult();
        } catch (Exception e) {
            throw new UserPersistenceException(UserPersistenceException.ERROR_SEARCHING_USER);
        }
    }

    @Override
    public User getUserByEmail(String email) throws UserPersistenceException {
        try {
            Query query = entityManager.createNativeQuery("select * from users where email=?", User.class);

            query.setParameter(1, email);

            if (query.getResultList().size()==0) {
                throw new UserPersistenceException(UserPersistenceException.ERROR_USER_NOT_FOUND);
            }

            return (User) query.getSingleResult();
        } catch (Exception e) {
            throw new UserPersistenceException(UserPersistenceException.ERROR_SEARCHING_USER);
        }
    }
    
}

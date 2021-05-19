package edu.eci.arsw.ecibastas.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.ecibastas.model.User;
import edu.eci.arsw.ecibastas.persistence.UserPersistence;
import edu.eci.arsw.ecibastas.persistence.exceptions.UserPersistenceException;
import edu.eci.arsw.ecibastas.services.UserService;
import edu.eci.arsw.ecibastas.services.exceptions.UserServiceException;

@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    UserPersistence userPersistence;

    public UserServiceIMPL() {

    }

    @Override
    public void createNewUser(User user) throws UserServiceException {
        try {
            userPersistence.createNewUser(user);
        } catch (UserPersistenceException e) {
            throw new UserServiceException(e.getMessage());
        }
    }

    @Override
    public void changeUserRole(String nickname, String email, String role) throws UserServiceException {
        try {
            userPersistence.changeUserRole(nickname, email, role);
        } catch (UserPersistenceException e) {
            throw new UserServiceException(e.getMessage());
        }
    }

    @Override
    public User getUserByNickname(String nickname) throws UserServiceException {
        try {
            return userPersistence.getUserByNickname(nickname);
        } catch (UserPersistenceException e) {
            throw new UserServiceException(e.getMessage());
        }
    }

    @Override
    public User getUserByEmail(String email) throws UserServiceException {
        try {
            return userPersistence.getUserByEmail(email);
        } catch (UserPersistenceException e) {
            throw new UserServiceException(e.getMessage());
        }
    }

    @Override
    public String getUserNicknameById(int userId) throws UserServiceException {
        try {
            return userPersistence.getUserNicknameById(userId);
        } catch (UserPersistenceException e) {
            throw new UserServiceException(e.getMessage());
        }
    }

    @Override
    public int getUserIdByEmail(String email) throws UserServiceException {
        try {
            return userPersistence.getUserIdByEmail(email);
        } catch (UserPersistenceException e) {
            throw new UserServiceException(e.getMessage());
        }
    }

    @Override
    public int getCreditByUserId(int id) throws UserServiceException {
        try {
            return userPersistence.getCreditByUserId(id);
        } catch (UserPersistenceException e) {
            throw new UserServiceException(e.getMessage());
        }
    }

    @Override
    public void sumCredits(int id, int credits) throws UserServiceException {
        try {
            userPersistence.sumCredits(id, credits);
        } catch (UserPersistenceException e) {
            throw new UserServiceException(e.getMessage());
        }
    }
}

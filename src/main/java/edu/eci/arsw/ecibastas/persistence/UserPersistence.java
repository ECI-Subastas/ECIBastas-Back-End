package edu.eci.arsw.ecibastas.persistence;

import edu.eci.arsw.ecibastas.model.User;
import edu.eci.arsw.ecibastas.persistence.exceptions.UserPersistenceException;

public interface UserPersistence {
    void createNewUser(User user) throws UserPersistenceException;

    void changeUserRole(String nickname, String email, String role) throws UserPersistenceException;

    User getUserByNickname(String nickname) throws UserPersistenceException;

    User getUserByEmail(String email) throws UserPersistenceException;

    String getUserNicknameById(int userId) throws UserPersistenceException;

    int getUserIdByEmail(String email) throws UserPersistenceException;

    int getCreditByUserId(int id) throws UserPersistenceException;

    void buyCredits(int id, int credits) throws UserPersistenceException;
}

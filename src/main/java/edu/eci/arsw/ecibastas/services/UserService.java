package edu.eci.arsw.ecibastas.services;

import edu.eci.arsw.ecibastas.model.User;
import edu.eci.arsw.ecibastas.services.exceptions.UserServiceException;

public interface UserService {
    void createNewUser(User user) throws UserServiceException;

    void changeUserRole(String nickname, String email, String role) throws UserServiceException;

    User getUserByNickname(String nickname) throws UserServiceException;

    User getUserByEmail(String email) throws UserServiceException;

    String getUserNicknameById(int userId) throws UserServiceException;
}

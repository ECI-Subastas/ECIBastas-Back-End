package edu.eci.arsw.ecibastas.persistence.exceptions;

public class UserPersistenceException extends Exception {
    private static final long serialVersionUID = 6411078068744429965L;

    public static final String ERROR_CREATING_NEW_USER = "Error during user creation.";
    public static final String ERROR_USER_NOT_FOUND = "The user specified was not found.";
    public static final String ERROR_SEARCHING_USER = "Error looking for the specified user.";
    public static final String ERROR_CHANGING_USER_ROLE = "Error during user changing role.";

    public UserPersistenceException(String message) {
        super(message);
    }
}

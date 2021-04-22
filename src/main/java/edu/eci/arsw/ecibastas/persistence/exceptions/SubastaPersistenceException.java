package edu.eci.arsw.ecibastas.persistence.exceptions;

public class SubastaPersistenceException extends Exception {
    private static final long serialVersionUID = 6411078068744429965L;

    public static final String ERROR_CREATING_NEW_SUBASTA = "Error during subasta creation.";
    public static final String ERROR_SUBASTA_NOT_FOUND = "The subasta specified was not found.";
    public static final String ERROR_SEARCHING_SUBASTA = "Error looking for the specified subasta.";

    public SubastaPersistenceException(String message) {
        super(message);
    }
}

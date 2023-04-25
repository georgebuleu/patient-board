package exception;

public class NotFindPatientsBySpecialty extends RuntimeException{
    public NotFindPatientsBySpecialty(String message) {
        super(message);
    }
}

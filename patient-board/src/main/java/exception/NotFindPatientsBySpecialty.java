package exception;

public class NotFindPatientsBySpecialty extends Exception{
    public NotFindPatientsBySpecialty() {
        super("There are no patients for this specialization");
    }
}

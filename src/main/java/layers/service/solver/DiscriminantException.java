package layers.service.solver;

public class DiscriminantException extends Exception{

    public DiscriminantException(String discriminant) {
        super("Discriminant: \'" + discriminant + "\' less than zero.");
    }
}

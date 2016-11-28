import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entity {

    private float paramA;
    private float paramB;
    private float paramC;

    private float x1;
    private float x2;

    private boolean has_natural_solution;

    public Entity() {
    }

    public Entity(float paramA, float paramB, float paramC) {
        this.paramA = paramA;
        this.paramB = paramB;
        this.paramC = paramC;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "paramA=" + paramA +
                ", paramB=" + paramB +
                ", paramC=" + paramC +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", has_natural_solution=" + has_natural_solution +
                '}';
    }
}

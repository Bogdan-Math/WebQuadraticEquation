package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "equation")
public class BaseEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "global_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Integer id;

    @Column(name = "param_a")
    private float paramA;

    @Column(name = "param_b")
    private float paramB;

    @Column(name = "param_c")
    private float paramC;

    @Column(name = "x_1")
    private Float x1;

    @Column(name = "x_2")
    private Float x2;

    @Column(name = "has_natural_solution")
    private Boolean has_natural_solution;

    public BaseEntity() {
    }

    public BaseEntity(float paramA, float paramB, float paramC) {
        this.paramA = paramA;
        this.paramB = paramB;
        this.paramC = paramC;
    }

    @Override
    public String toString() {
        return "model.BaseEntity{" +
                "paramA=" + paramA +
                ", paramB=" + paramB +
                ", paramC=" + paramC +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", has_natural_solution=" + has_natural_solution +
                '}';
    }
}

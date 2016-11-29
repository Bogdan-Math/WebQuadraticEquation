package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "equation")
public class Equation extends BaseEntity {

    @Column(name = "param_a")
    private double paramA;

    @Column(name = "param_b")
    private double paramB;

    @Column(name = "param_c")
    private double paramC;

    @Column(name = "x_1")
    private Double x1;

    @Column(name = "x_2")
    private Double x2;

    @Column(name = "has_natural_solution")
    private Boolean has_natural_solution;

    public Equation() {
    }

    public Equation(double paramA, double paramB, double paramC) {
        this.paramA = paramA;
        this.paramB = paramB;
        this.paramC = paramC;
    }

    @Override
    public String toString() {
        return "Equation{" +
                "paramA=" + paramA +
                ", paramB=" + paramB +
                ", paramC=" + paramC +
                ", x1=" + x1 +
                ", x2=" + x2 +
                ", has_natural_solution=" + has_natural_solution +
                '}';
    }
}

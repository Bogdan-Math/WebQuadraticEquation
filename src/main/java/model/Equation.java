package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "equation")
public class Equation extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "solution_id")
    @JsonIgnore
    private Solution solution;

    @Column(name = "param_a")
    private double paramA;

    @Column(name = "param_b")
    private double paramB;

    @Column(name = "param_c")
    private double paramC;

    public Equation() {
    }

    public Equation(double paramA, double paramB, double paramC) {
        this.paramA = paramA;
        this.paramB = paramB;
        this.paramC = paramC;
    }
}

package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "equation")
public class Equation extends BaseEntity {

    @ManyToMany
    @JoinTable(name = "equation_solution",
               joinColumns = {@JoinColumn(name = "equation_id")},
               inverseJoinColumns = {@JoinColumn(name = "solution_id")})
    @JsonIgnore
    private Set<Solution> solutions;

    @Getter
    @Setter
    @Column(name = "param_a")
    private double paramA;

    @Getter
    @Setter
    @Column(name = "param_b")
    private double paramB;

    @Getter
    @Setter
    @Column(name = "param_c")
    private double paramC;

    public Set<Solution> solutions() {
        if (solutions == null) solutions = new HashSet<>();
        return solutions;
    }

    public void addSolutions(Double... newSolutions) {
        for (Double x : newSolutions) {
            solutions().add(new Solution(x));
        }
    }
}

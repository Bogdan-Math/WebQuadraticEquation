package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "solution")
public class Solution extends BaseEntity{

    @Column(name = "x_1")
    private Double x1;

    @Column(name = "x_2")
    private Double x2;

    public Solution() {
    }

    public Solution(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public String toString() {
        return "Solution{" + "x1=" + x1 + ", x2=" + x2 + '}';
    }

}

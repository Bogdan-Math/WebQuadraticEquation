package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
}

package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution = (Solution) o;

        return  (x1 != null ? x1.equals(solution.x1) : solution.x1 == null) &&
                (x2 != null ? x2.equals(solution.x2) : solution.x2 == null);

    }

    @Override
    public int hashCode() {
        int result = x1 != null ? x1.hashCode() : 0;
        result = 31 * result + (x2 != null ? x2.hashCode() : 0);
        return result;
    }
}

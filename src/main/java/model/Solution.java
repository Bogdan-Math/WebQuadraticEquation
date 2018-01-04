package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "solution")
public class Solution extends BaseEntity {

/*
    @ManyToMany(mappedBy = "solutions")
    private Set<Equation> equations;
*/

    @Getter
    @Setter
    @Column(name = "x")
    private Double x;

    Solution(Double x) {
        this.x = x;
    }
}

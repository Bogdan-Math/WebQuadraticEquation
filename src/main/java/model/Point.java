package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Point extends BaseEntity {
    private double x;
    private double y;
}
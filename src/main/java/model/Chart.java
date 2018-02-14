package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
public class Chart extends BaseEntity {

    private Point[] points;

    private double suggestedMinX;
    private double suggestedMaxX;
    private double suggestedMinY;
    private double suggestedMaxY;
}

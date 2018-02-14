package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Chart extends BaseEntity {

    private Point[] points;

    private int suggestedMinX;
    private int suggestedMaxX;
    private int suggestedMinY;
    private int suggestedMaxY;
}

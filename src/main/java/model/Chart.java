package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chart {

    private Point[] points;

    private int suggestedMinX;
    private int suggestedMaxX;
    private int suggestedMinY;
    private int suggestedMaxY;
}

package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Point extends BaseEntity {
    private int x;
    private int y;
}
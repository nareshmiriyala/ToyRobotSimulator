package com.rea.trs.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum for Directions the toy moves.
 */
public enum  Direction {
    NORTH(0), EAST(1), SOUTH(2), WEST(3);


    private final int direction;

    Direction(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
}

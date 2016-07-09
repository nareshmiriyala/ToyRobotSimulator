package com.rea.trs.model;

/**
 * Created by nmiriyal on 8/07/2016.
 */
public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position() {
    }

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void changeValue(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    @Override
    public String toString() {
        return "" + x +
                "," + y +
                "" + direction;
    }
}

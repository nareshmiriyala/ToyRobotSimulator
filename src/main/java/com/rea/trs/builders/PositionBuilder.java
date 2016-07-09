package com.rea.trs.builders;

import com.rea.trs.model.Direction;
import com.rea.trs.model.Position;

/**
 * Created by nmiriyal on 9/07/2016.
 */
public final class PositionBuilder {
    private int x;
    private int y;
    private Direction direction;

    private PositionBuilder() {
    }

    public static PositionBuilder aPosition() {
        return new PositionBuilder();
    }

    public PositionBuilder withX(int x) {
        this.x = x;
        return this;
    }

    public PositionBuilder withY(int y) {
        this.y = y;
        return this;
    }

    public PositionBuilder withDirection(Direction direction) {
        this.direction = direction;
        return this;
    }

    public Position build() {
        Position position = new Position();
        position.setX(x);
        position.setY(y);
        position.setDirection(direction);
        return position;
    }
}

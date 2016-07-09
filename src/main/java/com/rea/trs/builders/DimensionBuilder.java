package com.rea.trs.builders;


import com.rea.trs.model.Dimension;

/**
 * Created by nmiriyal on 8/07/2016.
 */
public final class DimensionBuilder {
    private int x;
    private int y;

    private DimensionBuilder() {
    }

    public static DimensionBuilder aDimension() {
        return new DimensionBuilder();
    }

    public DimensionBuilder withX(int x) {
        this.x = x;
        return this;
    }

    public DimensionBuilder withY(int y) {
        this.y = y;
        return this;
    }

    public Dimension build() {
        return new Dimension(x, y);
    }
}

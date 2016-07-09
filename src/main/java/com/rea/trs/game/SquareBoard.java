package com.rea.trs.game;

import com.rea.trs.model.Dimension;
import com.rea.trs.model.Position;
import org.springframework.stereotype.Component;

/**
 * A square board which has equal dimensions.
 */
@Component
public class SquareBoard implements Board {
    private Dimension dimension;
    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public boolean isValidPosition(Position position) {
        return isValid(position);
    }

    private boolean isValid(Position position) {
        return !(
                position.getX() > this.getDimension().getX() || position.getX() < 0 ||
                        position.getY() > this.getDimension().getY() || position.getY() < 0
        );
    }
}

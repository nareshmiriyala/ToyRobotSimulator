package com.rea.trs.game;

import com.rea.trs.model.Dimension;
import org.springframework.stereotype.Component;

/**
 * A square board which has equal dimensions.
 */
@Component
public class SquareBoard implements Board {
    @Override
    public Dimension getDimension() {
        return null;
    }

    @Override
    public void setDimension(Dimension dimension) {

    }
}

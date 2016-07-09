package com.rea.trs.game;

import com.rea.trs.model.Dimension;

/**
 * Represents a game Board.
 */
public interface Board {

    Dimension getDimension();

    void setDimension(Dimension dimension);

}

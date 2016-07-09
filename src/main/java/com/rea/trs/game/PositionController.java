package com.rea.trs.game;

import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Position;

/**
 * Controller to move the toy position
 */
public interface PositionController {
    public void nextPosition(Position position) throws ToySimulatorException;
}

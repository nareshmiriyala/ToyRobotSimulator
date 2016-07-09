package com.rea.trs.game;

import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Position;

/**
 * Controller to movePosition the toy position
 */
public interface PositionController {
    void nextPosition(Position position) throws ToySimulatorException;
}

package com.rea.trs.game;

import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Position;

/**
 * Created by nmiriyal on 9/07/2016.
 */
public interface ToyController {
    void movePosition(Position position) throws ToySimulatorException;

    void rotateLeft(Position position) throws ToySimulatorException;

    void rotateRight(Position position) throws ToySimulatorException;
}

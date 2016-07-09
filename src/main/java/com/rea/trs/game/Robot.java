package com.rea.trs.game;

import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Position;

/**
 * Represents a Robot.
 */
interface Robot {

    void movePosition(Position position) throws ToySimulatorException;

    void rotateLeft(Position position) throws ToySimulatorException;

    void rotateRight(Position position) throws ToySimulatorException;
}

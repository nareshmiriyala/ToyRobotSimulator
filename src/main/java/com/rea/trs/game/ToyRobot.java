package com.rea.trs.game;

import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

/**
 * Toy Robot used for playing this game.
 */
@Component
public class ToyRobot implements Robot {

    @Autowired
    private DirectionController directionController;
    @Autowired
    private PositionController positionController;


    @Override
    public void movePosition(Position position) throws ToySimulatorException {
        validatePosition(position);
        positionController.nextPosition(position);
    }

    private void validatePosition(Position position) throws ToySimulatorException {
        if (isNull(position)) {
            throw new ToySimulatorException("Position can't be null");
        }
    }

    @Override
    public void rotateLeft(Position position) throws ToySimulatorException {
        validatePosition(position);
        position.setDirection(directionController.leftDirection(position.getDirection()));
    }

    @Override
    public void rotateRight(Position position) throws ToySimulatorException {
        validatePosition(position);
        position.setDirection(directionController.rightDirection(position.getDirection()));
    }

}

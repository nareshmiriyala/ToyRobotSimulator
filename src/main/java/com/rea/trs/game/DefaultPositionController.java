package com.rea.trs.game;

import com.rea.trs.builders.PositionBuilder;
import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Direction;
import com.rea.trs.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class DefaultPositionController implements PositionController {
    @Autowired
    private Board squareBoard;
    @Override
    public void nextPosition(Position position) throws ToySimulatorException {
        if(isNull(position)){
            throw new ToySimulatorException("Invalid position");
        }
        Direction currentDirection = position.getDirection();
        if (isNull(currentDirection)) {
            throw new ToySimulatorException("Invalid Direction");
        }
        Position newPosition = newPosition(position, currentDirection);
        if (squareBoard.isValidPosition(newPosition)) {
            position.setX(newPosition.getX());
            position.setY(newPosition.getY());
        }

    }

    private Position newPosition(Position position, Direction currentDirection) {
        Position newPosition = PositionBuilder.aPosition().withDirection(position.getDirection()).withX(position.getX()).withY(position.getY()).build();

        switch (currentDirection) {
            case NORTH:
                newPosition.changeValue(0, 1);
                break;
            case EAST:
                newPosition.changeValue(1, 0);
                break;
            case SOUTH:
                newPosition.changeValue(0, -1);
                break;
            case WEST:
                newPosition.changeValue(-1, 0);
                break;
        }
        return newPosition;
    }
}

package com.rea.trs.game;

import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Direction;
import com.rea.trs.model.Position;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class DefaultPositionController implements PositionController {
    @Override
    public void nextPosition(Position position) throws ToySimulatorException {
        if(isNull(position)){
            throw new ToySimulatorException("Invalid position");
        }
        Direction currentDirection = position.getDirection();
        if (isNull(currentDirection)) {
            throw new ToySimulatorException("Invalid Direction");
        }
        switch (currentDirection) {
            case NORTH:
                position.changeValue(0, 1);
                break;
            case EAST:
                position.changeValue(1, 0);
                break;
            case SOUTH:
                position.changeValue(0, -1);
                break;
            case WEST:
                position.changeValue(-1, 0);
                break;
        }
    }
}

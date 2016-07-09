package com.rea.trs.game;

import com.rea.trs.model.Direction;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller to move left and right direction from current direction.
 */
@Component
public class DefaultDirectionController implements DirectionController {
    private static final Map<Integer, Direction> directionsMap = new HashMap<>();

    @PostConstruct
    public void init() {
        for (Direction direction : Direction.values()) {
            directionsMap.put(direction.getDirection(), direction);
        }
    }

    private Direction valueOf(int direction) {
        return directionsMap.get(direction);
    }

    @Override
    public Direction leftDirection(Direction direction) {
        return rotate(direction, -1);
    }

    @Override
    public Direction rightDirection(Direction direction) {
        return rotate(direction, 1);
    }

    private Direction rotate(Direction direction, int step) {

        return valueOf(getAnInt(direction, step));
    }

    private int getAnInt(Direction direction, int step) {
        return (direction.getDirection() + step) < 0 ?
                directionsMap.size() - 1 :
                (direction.getDirection() + step) % directionsMap.size();
    }
}

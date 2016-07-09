package com.rea.trs.game;

import com.rea.trs.model.Direction;

/**
 * A controller to movePosition left and right direction
 */
public interface DirectionController {

    Direction leftDirection(Direction direction);

    Direction rightDirection(Direction direction);
}

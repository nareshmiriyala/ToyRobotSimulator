package com.rea.trs.game;

import com.rea.trs.model.Position;
import org.springframework.stereotype.Component;

/**
 * Toy Robot used for playing this game.
 */
@Component
public class ToyRobot implements Robot {

    private Position position;

    public ToyRobot() {
    }

    public ToyRobot(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

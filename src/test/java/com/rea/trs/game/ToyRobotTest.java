package com.rea.trs.game;

import com.rea.trs.builders.PositionBuilder;
import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Direction;
import com.rea.trs.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@SpringApplicationConfiguration(classes = {ToyRobot.class, DefaultDirectionController.class, DefaultPositionController.class})
public class ToyRobotTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private Robot toyRobot;

    private Position position;

    @BeforeMethod
    public void setUp() throws Exception {
        position = PositionBuilder.aPosition().withDirection(Direction.NORTH).withX(0).withY(0).build();

    }

    @Test
    public void testNextPosition() throws ToySimulatorException {

        toyRobot.movePosition(position);
        assertEquals(position.getX(), 0);
        assertEquals(position.getY(), 1);
    }

    @Test
    public void shouldMoveRight() throws Exception {
        toyRobot.rotateRight(position);
        assertEquals(position.getDirection(), Direction.EAST);
    }

    @Test
    public void shouldMoveLeft() throws Exception {
        toyRobot.rotateLeft(position);
        assertEquals(position.getDirection(), Direction.WEST);
    }
}
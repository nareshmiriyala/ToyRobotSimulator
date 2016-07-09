package com.rea.trs.game;

import com.rea.trs.AbstractTest;
import com.rea.trs.builders.DimensionBuilder;
import com.rea.trs.builders.PositionBuilder;
import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Direction;
import com.rea.trs.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DefaultToyControllerTest extends AbstractTest {
    @Autowired
    private DefaultToyController toyController;

    private Position position;

    @Autowired
    private SquareBoard squareBoard;

    @BeforeMethod
    public void setUp() throws Exception {
        squareBoard.setDimension(DimensionBuilder.aDimension().withX(4).withY(4).build());
        position = PositionBuilder.aPosition().withDirection(Direction.NORTH).withX(0).withY(0).build();

    }

    @Test
    public void testNextPosition() throws ToySimulatorException {

        toyController.movePosition(position);
        assertEquals(position.getX(), 0);
        assertEquals(position.getY(), 1);
    }

    @Test
    public void shouldMoveRight() throws Exception {
        toyController.rotateRight(position);
        assertEquals(position.getDirection(), Direction.EAST);
    }

    @Test
    public void shouldMoveLeft() throws Exception {
        toyController.rotateLeft(position);
        assertEquals(position.getDirection(), Direction.WEST);
    }
}
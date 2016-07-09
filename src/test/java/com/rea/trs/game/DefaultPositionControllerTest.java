package com.rea.trs.game;

import com.rea.trs.AbstractTest;
import com.rea.trs.builders.DimensionBuilder;
import com.rea.trs.builders.PositionBuilder;
import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Direction;
import com.rea.trs.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.rea.trs.model.Direction.*;
import static org.testng.Assert.assertEquals;

public class DefaultPositionControllerTest extends AbstractTest {
    private static final String NEXT_POSITIONS = "nextPositions";
    @Autowired
    private PositionController positionController;
    @Autowired
    private SquareBoard squareBoard;

    @BeforeMethod
    public void setUp() throws Exception {
        squareBoard.setDimension(DimensionBuilder.aDimension().withX(4).withY(4).build());

    }

    @Test(dataProvider = NEXT_POSITIONS)
    public void validNextPosition(Direction direction, int expX, int expY) throws ToySimulatorException {
        Position position = PositionBuilder.aPosition().withDirection(direction).withX(2).withY(2).build();
        positionController.nextPosition(position);
        assertEquals(position.getX(), expX);
        assertEquals(position.getY(), expY);
    }

    @Test(expectedExceptions = ToySimulatorException.class)
    public void throwToySimulatorExceptionInvalidPosition() throws Exception {
        positionController.nextPosition(null);
    }

    @Test(expectedExceptions = ToySimulatorException.class)
    public void throwToySimulatorExceptionInvalidDirection() throws Exception {
        positionController.nextPosition(PositionBuilder.aPosition().withX(0).withY(0).build());
    }

    @DataProvider(name = NEXT_POSITIONS)
    private Object[][] nextPositions() {
        return new Object[][]{
                {NORTH, 2, 3},
                {EAST, 3, 2},
                {SOUTH, 2, 1},
                {WEST, 1, 2}
        };
    }
}
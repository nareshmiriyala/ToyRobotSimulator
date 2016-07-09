package com.rea.trs.game;

import com.rea.trs.builders.PositionBuilder;
import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Direction;
import com.rea.trs.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.rea.trs.model.Direction.*;
import static org.testng.Assert.assertEquals;

@SpringApplicationConfiguration(DefaultPositionController.class)
public class DefaultPositionControllerTest extends AbstractTestNGSpringContextTests {
    private static final String NEXT_POSITIONS = "nextPositions";
    @Autowired
    private PositionController positionController;

    @Test(dataProvider = NEXT_POSITIONS)
    public void validNextPosition(Direction direction, int expX, int expY) throws ToySimulatorException {
        Position position = PositionBuilder.aPosition().withDirection(direction).withX(0).withY(0).build();
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
                {NORTH, 0, 1},
                {EAST, 1, 0},
                {SOUTH, 0, -1},
                {WEST, -1, 0}
        };
    }
}
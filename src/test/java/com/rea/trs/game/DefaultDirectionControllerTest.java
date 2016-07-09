package com.rea.trs.game;

import com.rea.trs.ToyRobotApplication;
import com.rea.trs.model.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.googlecode.totallylazy.matchers.Matchers.is;
import static com.rea.trs.model.Direction.*;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringApplicationConfiguration(ToyRobotApplication.class)
public class DefaultDirectionControllerTest extends AbstractTestNGSpringContextTests {
    private static final String LEFT_DIRECTIONS = "leftDirections";
    private static final String RIGHT_DIRECTIONS = "rightDirections";
    @Autowired
    private DirectionController directionsController;

    @Test(dataProvider = RIGHT_DIRECTIONS)
    public void shouldRotateRight(Direction input, Direction expected) {
        assertThat(directionsController.rightDirection(input), is(expected));
    }

    @Test(dataProvider = LEFT_DIRECTIONS)
    public void shouldRotateLeft(Direction input, Direction expected) {
        assertThat(directionsController.leftDirection(input), is(expected));
    }

    @DataProvider(name = LEFT_DIRECTIONS)
    private Object[][] leftDirections() {
        return new Object[][]{
                {NORTH, WEST},
                {WEST, SOUTH},
                {SOUTH, EAST},
                {EAST, NORTH}
        };
    }

    @DataProvider(name = RIGHT_DIRECTIONS)
    private Object[][] rightDirections() {
        return new Object[][]{
                {WEST, NORTH},
                {NORTH, EAST},
                {EAST, SOUTH},
                {SOUTH, WEST}
        };
    }

}
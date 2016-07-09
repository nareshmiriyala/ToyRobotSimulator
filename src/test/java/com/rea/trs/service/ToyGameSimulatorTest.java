package com.rea.trs.service;

import com.rea.trs.AbstractTest;
import com.rea.trs.builders.DimensionBuilder;
import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.game.SquareBoard;
import com.rea.trs.model.InputStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ToyGameSimulatorTest extends AbstractTest {
    @Autowired
    private SquareBoard squareBoard;
    @Autowired
    private Simulator toySimulator;
    @Autowired
    private InputStore store;

    @BeforeMethod
    public void setUp() throws Exception {
        squareBoard.setDimension(DimensionBuilder.aDimension().withX(4).withY(4).build());

    }

    @AfterMethod
    public void tearDown() throws Exception {
        store.setReportValue(null);
    }

    @Test
    public void scenarioOne() throws ToySimulatorException, InvalidCommandException {
        toySimulator.execute("PLACE 0,0,NORTH");
        toySimulator.execute("MOVE");
        toySimulator.execute("REPORT");
        assertEquals(store.getReportValue(), "0,1,NORTH");

    }

    @Test
    public void scenarioTwo() throws ToySimulatorException, InvalidCommandException {
        toySimulator.execute("PLACE 0,0,NORTH");
        toySimulator.execute("LEFT");
        toySimulator.execute("REPORT");
        assertEquals(store.getReportValue(), "0,0,WEST");

    }

    @Test
    public void scenarioThree() throws ToySimulatorException, InvalidCommandException {
        toySimulator.execute("PLACE 1,2,EAST");
        toySimulator.execute("MOVE");
        toySimulator.execute("MOVE");
        toySimulator.execute("LEFT");
        toySimulator.execute("MOVE");
        toySimulator.execute("REPORT");
        assertEquals(store.getReportValue(), "3,3,NORTH");

    }
}
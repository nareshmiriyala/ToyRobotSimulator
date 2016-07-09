package com.rea.trs.service;

import com.rea.trs.AbstractTest;
import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.model.InputStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CommandValidatorTest extends AbstractTest {
    @Autowired
    private Validator commandValidator;
    @Autowired
    private InputStore store;

    @BeforeMethod
    public void setUp() throws Exception {
        store.getCommands().add("PLACE 0,0,NORTH");

    }

    @AfterMethod
    public void tearDown() throws Exception {
        store.getCommands().clear();

    }

    @Test(expectedExceptions = InvalidCommandException.class)
    public void invalidInput() throws InvalidCommandException {
        commandValidator.validate(null);
    }

    @Test
    public void storeAllCommands() throws Exception {
        commandValidator.validate("PLACE 0,0,NORTH");
        commandValidator.validate("MOVE");
        commandValidator.validate("MOVE");
        commandValidator.validate("LEFT");
        assertEquals(store.getCommands().size(), 4);

    }

    @Test
    public void ignoreInvalidPlace() throws Exception {
        commandValidator.validate("PLACE 0,0,NORTH");
        long count = store.getCommands().stream().filter(s -> s.contains("PLACE 0,0,NORTH")).count();
        assertEquals(count, 1);
    }
}
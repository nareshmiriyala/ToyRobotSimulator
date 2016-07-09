package com.rea.trs.service;

import com.rea.trs.AbstractTest;
import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.model.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ConsoleReaderTest extends AbstractTest {

    private static final String COMMANDS_INPUT = "commands";

    @Autowired
    private Reader consoleReader;

    @DataProvider(name = COMMANDS_INPUT)
    private Object[][] commands() {
        return new Object[][]{
                {"PLACE 1,2,EAST", "PLACE"},
                {"MOVE", "MOVE"},
                {"LEFT", "LEFT"},
                {"RIGHT", "RIGHT"},
                {"REPORT", "REPORT"}

        };
    }

    @Test(dataProvider = COMMANDS_INPUT)
    public void testCommands(String input, String exp) throws InvalidCommandException {
        assertEquals(consoleReader.readCommand(input), Command.valueOf(exp));
    }
}
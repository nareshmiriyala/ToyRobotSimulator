package com.rea.trs.service;

import com.rea.trs.ToyRobotApplication;
import com.rea.trs.exceptions.InvalidCommandException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@SpringApplicationConfiguration(ToyRobotApplication.class)
public class CommandValidatorTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private Validator commandValidator;
    @Test
    public void testCommand() throws InvalidCommandException {
        commandValidator.validate("MOVE");
    }
}
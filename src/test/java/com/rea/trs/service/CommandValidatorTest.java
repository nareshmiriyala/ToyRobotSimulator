package com.rea.trs.service;

import com.rea.trs.ToyRobotApplication;
import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.test.AbstractTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CommandValidatorTest extends AbstractTest {
    @Autowired
    private Validator commandValidator;
    @Test
    public void testCommand() throws InvalidCommandException {
        commandValidator.validate("MOVE");
    }
}
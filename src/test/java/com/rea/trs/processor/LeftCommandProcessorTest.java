package com.rea.trs.processor;

import com.rea.trs.game.ToyController;
import com.rea.trs.game.ToyRobot;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by nmiriyal on 10/07/2016.
 */
public class LeftCommandProcessorTest {
    @InjectMocks
    private LeftCommandProcessor leftCommandProcessor;
    @Mock
    private ToyController toyController;
    @Mock
    private ToyRobot toyRobot;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void verifyToyControllerIsCalled() throws Exception {
        leftCommandProcessor.process();
        verify(toyRobot, times(1)).getPosition();
        verify(toyController, times(1)).rotateLeft(toyRobot.getPosition());
    }
}
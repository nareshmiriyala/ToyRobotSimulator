package com.rea.trs.processor;

import com.rea.trs.game.ToyController;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by nmiriyal on 10/07/2016.
 */
public class LeftCommandProcessorTest extends AbstractProcessorTest {

    @InjectMocks
    private LeftCommandProcessor leftCommandProcessor;
    @Mock
    private ToyController toyController;
    @Test
    public void verifyToyControllerIsCalled() throws Exception {
        leftCommandProcessor.process();
        verify(toyRobot, times(1)).getPosition();
        verify(toyController, times(1)).rotateLeft(toyRobot.getPosition());
    }
}
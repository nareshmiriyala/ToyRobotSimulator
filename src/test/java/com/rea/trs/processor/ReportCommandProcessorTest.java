package com.rea.trs.processor;

import com.rea.trs.model.Position;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by nmiriyal on 10/07/2016.
 */
public class ReportCommandProcessorTest extends AbstractProcessorTest {
    @InjectMocks
    private ReportCommandProcessor reportCommandProcessor;
    @Mock
    private Position mockPosition;

    @Test
    public void shouldShowReport() throws Exception {
        when(mockPosition.toString()).thenReturn("1,1,NORTH");
        when(toyRobot.getPosition()).thenReturn(mockPosition);

        reportCommandProcessor.process();

        verify(toyRobot, times(1)).getPosition();
    }

}
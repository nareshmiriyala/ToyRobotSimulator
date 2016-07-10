package com.rea.trs.processor;

import com.rea.trs.game.ToyRobot;
import com.rea.trs.model.InputStore;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;

/**
 * Created by nmiriyal on 10/07/2016.
 */
public class AbstractProcessorTest {
    @Mock
    protected InputStore store;
    @Mock
    protected ToyRobot toyRobot;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }
}

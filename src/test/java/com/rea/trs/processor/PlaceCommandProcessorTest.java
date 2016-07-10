package com.rea.trs.processor;

import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.game.SquareBoard;
import com.rea.trs.model.InputStore;
import com.rea.trs.model.Position;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class PlaceCommandProcessorTest {

    @InjectMocks
    private PlaceCommandProcessor placeCommandProcessor;

    @Mock
    private InputStore store;
    @Mock
    private SquareBoard board;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test(expectedExceptions = InvalidCommandException.class)
    public void processInvalidInput() throws Exception {
        when(store.getInput()).thenReturn("X,Y,NORTH");
        placeCommandProcessor.process();
    }
    @Test
    public void processValidInput() throws Exception {
        when(store.getInput()).thenReturn("1,1,NORTH");
        placeCommandProcessor.process();
        verify(board,times(1)).isValidPosition(any(Position.class));
    }
}
package com.rea.trs.processor;

import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.game.ToyController;
import com.rea.trs.game.ToyRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nmiriyal on 8/07/2016.
 */
@Component(value = MoveCommandProcessor.MOVE_COMMAND_PROCESSOR)
public class MoveCommandProcessor implements Processor {
    public static final String MOVE_COMMAND_PROCESSOR = "MoveCommandProcessor";
    @Autowired
    private ToyController toyController;
    @Autowired
    private ToyRobot toyRobot;

    @Override
    public void process() throws ToySimulatorException {
        toyController.movePosition(toyRobot.getPosition());
    }
}

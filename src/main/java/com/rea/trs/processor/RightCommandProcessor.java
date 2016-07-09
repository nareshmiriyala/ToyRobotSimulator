package com.rea.trs.processor;

import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.game.ToyController;
import com.rea.trs.game.ToyRobot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Right processor which moves the toy right.
 */
@Component(value = RightCommandProcessor.RIGHT_COMMAND_PROCESSOR)
public class RightCommandProcessor implements Processor {
    public static final String RIGHT_COMMAND_PROCESSOR = "RightCommandProcessor";
    @Autowired
    private ToyController toyController;
    @Autowired
    private ToyRobot toyRobot;

    @Override
    public void process() throws ToySimulatorException {
        toyController.rotateRight(toyRobot.getPosition());
    }
}

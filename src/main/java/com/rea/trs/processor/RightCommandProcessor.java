package com.rea.trs.processor;

import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.game.ToyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Right processor which moves the toy right.
 */
@Component(value = RightCommandProcessor.RIGHT_COMMAND_PROCESSOR)
public class RightCommandProcessor extends AbstractProcessor {
    public static final String RIGHT_COMMAND_PROCESSOR = "RightCommandProcessor";
    @Autowired
    private ToyController toyController;

    @Override
    public void process() throws ToySimulatorException {
        toyController.rotateRight(toyRobot.getPosition());
    }
}

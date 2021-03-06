package com.rea.trs.processor;

import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.game.ToyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nmiriyal on 8/07/2016.
 */
@Component(value = LeftCommandProcessor.LEFT_COMMAND_PROCESSOR)
public class LeftCommandProcessor extends AbstractProcessor {
    public static final String LEFT_COMMAND_PROCESSOR = "LeftCommandProcessor";
    @Autowired
    private ToyController toyController;

    @Override
    public void process() throws ToySimulatorException {
        toyController.rotateLeft(toyRobot.getPosition());
    }
}

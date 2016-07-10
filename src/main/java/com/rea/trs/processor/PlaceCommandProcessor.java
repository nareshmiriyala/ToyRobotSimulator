package com.rea.trs.processor;

import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Direction;
import com.rea.trs.model.InputStore;
import com.rea.trs.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nmiriyal on 8/07/2016.
 */
@Component(value = PlaceCommandProcessor.PLACE_COMMAND_PROCESSOR)
public class PlaceCommandProcessor extends AbstractProcessor {

    public static final String PLACE_COMMAND_PROCESSOR = "PlaceCommandProcessor";
    @Autowired
    private InputStore inputStore;
    private int x = 0;
    private int y = 0;
    private Direction commandDirection = null;

    @Override
    public void process() throws InvalidCommandException, ToySimulatorException {
        storeInputValues();
        placeRobot(new Position(x, y, commandDirection));
    }

    private void storeInputValues() throws InvalidCommandException {
        String input = inputStore.getInput();
        String[] params = input.split(",");

        try {
            x = Integer.parseInt(params[0]);
            y = Integer.parseInt(params[1]);
            commandDirection = Direction.valueOf(params[2]);
        } catch (Exception e) {
            throw new InvalidCommandException("Invalid command");
        }
    }

    private void placeRobot(Position position) throws ToySimulatorException {

        if (position.getDirection() == null)
            throw new ToySimulatorException("Invalid direction");

        if (!squareBoard.isValidPosition(position))
            return;

        toyRobot.setPosition(position);
    }
}

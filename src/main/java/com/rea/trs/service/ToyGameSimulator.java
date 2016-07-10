package com.rea.trs.service;

import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.game.SquareBoard;
import com.rea.trs.model.Command;
import com.rea.trs.processor.CommandProcessorFactory;
import com.rea.trs.processor.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

/**
 * Toy Robot Game Simulator.
 */
@Component
public class ToyGameSimulator implements Simulator {
    @Autowired
    private Reader consoleReader;
    @Autowired
    private CommandProcessorFactory processorFactory;
    @Autowired
    private SquareBoard squareBoard;
    @Override
    public void execute(String input) throws InvalidCommandException, ToySimulatorException {
        if(isNull(squareBoard.getDimension())){
            throw  new ToySimulatorException("Please set board dimensions");
        }
        Command command = consoleReader.readCommand(input);
        Processor processor = processorFactory.getProcessor(command);
        processor.process();
    }
}

package com.rea.trs.service;

import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.model.Command;
import com.rea.trs.processor.CommandProcessorFactory;
import com.rea.trs.processor.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Toy Robot Game Simulator.
 */
@Component
public class ToyGameSimulator implements Simulator {
    @Autowired
    private Reader consoleReader;
    @Autowired
    private CommandProcessorFactory processorFactory;

    @Override
    public void execute(String input) throws InvalidCommandException, ToySimulatorException {
        Command command = consoleReader.readCommand(input);
        Processor processor = processorFactory.getProcessor(command);
        processor.process();
    }
}

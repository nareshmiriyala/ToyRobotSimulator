package com.rea.trs.processor;

import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.exceptions.ToySimulatorException;


public interface Processor {
    void process() throws ToySimulatorException,InvalidCommandException;
}

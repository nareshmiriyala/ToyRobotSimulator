package com.rea.trs.service;

import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.exceptions.ToySimulatorException;

/**
 * Simulator of the game.
 */
public interface Simulator {
    void execute(String input) throws InvalidCommandException, ToySimulatorException;
}

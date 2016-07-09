package com.rea.trs.service;

import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.model.Command;
import com.rea.trs.model.InputStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class ConsoleReader implements Reader {
    @Autowired
    private Validator commandValidator;
    @Autowired
    private InputStore inputStore;

    @Override
    public Command readCommand(String input) throws InvalidCommandException {
        commandValidator.validate(input);
        String value = input;
        value = getCommandValue(input, value);
        return Command.valueOf(value);
    }

    private String getCommandValue(String input, String value) {
        if (input.contains(" ")) {
            String[] strings = input.split(" ");
            if (nonNull(strings[1])) {
                inputStore.setInput(strings[1]);
            }
            value = strings[0];
        }
        return value;
    }


}

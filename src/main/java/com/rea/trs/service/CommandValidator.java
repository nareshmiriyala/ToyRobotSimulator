package com.rea.trs.service;

import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.model.Command;
import com.rea.trs.model.InputStore;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

/**
 * Created by nmiriyal on 8/07/2016.
 */
@Component
public class CommandValidator implements Validator {
    private static final String PLACE = Command.PLACE.name();
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(CommandValidator.class);
    @Autowired
    private InputStore store;

    @Override
    public void validate(String cmd) throws InvalidCommandException {
        if (isNullOrEmpty(cmd)) {
            throw new InvalidCommandException(format("Input %s is invalid", cmd));
        }
        Optional<String> place = store.getCommands().stream().filter(s -> s.startsWith(PLACE)).findFirst();
        if (place.isPresent() && cmd.startsWith(PLACE)) {
            logger.info(format("Command %s already exists ignoring command", cmd));
            return;
        }
        if (cmd.equals(Command.REPORT.toString())) {
            logger.info("Clearing the commands cache");
            store.getCommands().clear();
            return;
        }
        store.getCommands().add(cmd);

    }

}

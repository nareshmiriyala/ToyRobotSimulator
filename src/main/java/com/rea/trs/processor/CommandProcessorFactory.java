package com.rea.trs.processor;

import com.googlecode.totallylazy.Function1;
import com.googlecode.totallylazy.Predicate;
import com.googlecode.totallylazy.Rules;
import com.googlecode.totallylazy.predicates.EqualsPredicate;
import com.rea.trs.model.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static com.googlecode.totallylazy.Functions.constant;

/**
 * Created by nmiriyal on 8/07/2016.
 */
@Component
public class CommandProcessorFactory {
    @Autowired
    @Qualifier(value = PlaceCommandProcessor.PLACE_COMMAND_PROCESSOR)
    private Processor placeCommandProcessor;
    @Autowired
    @Qualifier(value = MoveCommandProcessor.MOVE_COMMAND_PROCESSOR)
    private Processor moveCommandProcessor;
    @Autowired
    @Qualifier(value = LeftCommandProcessor.LEFT_COMMAND_PROCESSOR)
    private Processor leftCommandProcessor;
    @Autowired
    @Qualifier(value = RightCommandProcessor.RIGHT_COMMAND_PROCESSOR)
    private Processor rightCommandProcessor;
    @Autowired
    @Qualifier(value = ReportCommandProcessor.REPORT_COMMAND_PROCESSOR)
    private Processor reportCommandProcessor;

    public Processor getProcessor(Command command) {
        return Rules.<Command, Processor>rules().
                addLast(whenCommandIs(Command.PLACE), thenUse(placeCommandProcessor))
                .addLast(whenCommandIs(Command.MOVE), thenUse(moveCommandProcessor))
                .addLast(whenCommandIs(Command.LEFT), thenUse(leftCommandProcessor))
                .addLast(whenCommandIs(Command.RIGHT), thenUse(rightCommandProcessor))
                .addLast(whenCommandIs(Command.REPORT), thenUse(reportCommandProcessor))
                .apply(command);

    }

    private Function1<Command, Processor> thenUse(Processor moveCommandProcessor) {
        return constant(moveCommandProcessor);
    }

    private Predicate<? super Object> whenCommandIs(Command cmd) {
        return EqualsPredicate.equalTo(cmd);
    }
}

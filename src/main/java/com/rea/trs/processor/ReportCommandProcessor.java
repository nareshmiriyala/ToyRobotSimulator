package com.rea.trs.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Processor to Print the report.
 */
@Component(value = ReportCommandProcessor.REPORT_COMMAND_PROCESSOR)
public class ReportCommandProcessor extends AbstractProcessor {
    public static final String REPORT_COMMAND_PROCESSOR = "ReportCommandProcessor";
    private final Logger logger = LoggerFactory.getLogger(ReportCommandProcessor.class);

    @Override
    public void process() {
        logger.info("Report : {}", report());
    }

    private String report() {
        if (toyRobot.getPosition() == null)
            return null;

        return toyRobot.getPosition().toString();
    }

}

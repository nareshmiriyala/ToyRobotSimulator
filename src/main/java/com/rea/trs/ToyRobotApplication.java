package com.rea.trs;

import com.rea.trs.builders.DimensionBuilder;
import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.exceptions.ToySimulatorException;
import com.rea.trs.game.SquareBoard;
import com.rea.trs.service.Simulator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

/**
 * Starting point of the Toy Robot Application
 */


@SpringBootApplication
class ToyRobotApplication {
    private static final Logger logger = LoggerFactory.getLogger(ToyRobotApplication.class);
    @Autowired
    private SquareBoard squareBoard;
    @Autowired
    private Simulator toySimulator;

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources(ToyRobotApplication.class)
                .run(args);

        ToyRobotApplication app = context.getBean(ToyRobotApplication.class);
        app.start();
    }

    private void start() throws Exception {

        Scanner in = new Scanner(System.in);
        squareBoard.setDimension(DimensionBuilder.aDimension().withX(4).withY(4).build());
        logger.info("======================================");
        logger.info("Following are the valid commands: \n");
        logger.info("\'PLACE X,Y,NORTH || SOUTH || EAST || WEST , MOVE  LEFT, RIGHT, REPORT or STOP \n");
        logger.info("Enter a command:");

        boolean running = true;
        while (running) {
            String input = in.nextLine();
            if ("STOP".equals(input)) {
                running = false;
            } else {
                try {
                    toySimulator.execute(input);
                }catch (InvalidCommandException e){
                    logger.error("Invalid command",e);
                }
                catch (ToySimulatorException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }
}

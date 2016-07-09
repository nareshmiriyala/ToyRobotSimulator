package com.rea.trs.processor;

import com.rea.trs.game.Board;
import com.rea.trs.game.ToyRobot;
import org.springframework.beans.factory.annotation.Autowired;


abstract class AbstractProcessor implements Processor {
    @Autowired
    protected Board squareBoard;

    @Autowired
    protected ToyRobot toyRobot;
}

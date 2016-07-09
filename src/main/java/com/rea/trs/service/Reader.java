package com.rea.trs.service;

import com.rea.trs.exceptions.InvalidCommandException;
import com.rea.trs.model.Command;


interface Reader {
    Command readCommand(String input) throws InvalidCommandException;

}

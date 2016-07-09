package com.rea.trs.model;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nmiriyal on 8/07/2016.
 */
@Component
public class InputStore {
    private String input;

    private Set<String> commands = new HashSet<>();

    public Set<String> getCommands() {
        return commands;
    }

    public void setCommands(Set<String> commands) {
        this.commands = commands;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}

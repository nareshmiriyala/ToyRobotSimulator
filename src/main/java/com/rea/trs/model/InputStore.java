package com.rea.trs.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nmiriyal on 8/07/2016.
 */
@Component
public class InputStore {
    private String input;

    private String reportValue;

    private List<String> commands = new ArrayList<>();

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getReportValue() {
        return reportValue;
    }

    public void setReportValue(String reportValue) {
        this.reportValue = reportValue;
    }
}

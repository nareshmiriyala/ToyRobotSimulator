package com.rea.trs.service;

import com.rea.trs.exceptions.InvalidCommandException;

/**
 * Created by nmiriyal on 8/07/2016.
 */
interface Validator {
    void validate(String cmd) throws InvalidCommandException;
}

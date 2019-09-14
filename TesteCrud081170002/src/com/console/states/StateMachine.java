package com.console.states;

import java.io.IOException;

public abstract class StateMachine {
    public abstract boolean execute() throws IOException;
}

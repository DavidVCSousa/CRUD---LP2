package com.console;

import com.commons.Util.Other.Builder;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;

import java.io.IOException;

import static com.dao.UserDAO.loggedUserBase;

public class Main {
    public static StateMachine consoleState;
    public static void main(String[] args) throws IOException {
        Builder.Build();
        consoleState =  EnumConsoleState.WELCOME.getMachineState();
        boolean exit = false;
        while (!exit){
            if(loggedUserBase != null) {
                System.out.println("Logged in as " + loggedUserBase.getName());
            }
            exit = consoleState.execute();
            System.out.println("**************************************");
        }
    }
}

package com.console.states;

import com.console.Main;

import java.util.Scanner;

public class StateWelcome extends StateMachine {
    @Override
    public boolean execute() {
        boolean exit = false;
        System.out.println("Welcome!");
        System.out.println("Enter your option!");
        System.out.println("0 - Exit");
        System.out.println("1 - Login");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch (option) {
            case 0:
                exit = true;
                break;
            case 1:
                Main.consoleState = EnumConsoleState.LOGIN.getMachineState();
                break;
            default:
                System.out.println("Choose a valid option");
        }
        return exit;
    }
}

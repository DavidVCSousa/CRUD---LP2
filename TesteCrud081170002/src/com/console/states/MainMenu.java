package com.console.states;

import com.console.Main;

import java.util.Scanner;

public class MainMenu extends StateMachine {
    @Override
    public boolean execute() {
        System.out.println("*** Main");
        Scanner scan = new Scanner(System.in);
        System.out.println("0 - Exit");
        System.out.println("1 - Create");
        System.out.println("2 - Delete");
        System.out.println("3 - Read");
        System.out.println("4 - Update");
        int option = scan.nextInt();
        switch (option)
        {
            case 0:
                Main.consoleState = EnumConsoleState.WELCOME.getMachineState();
                break;
            case 1:
                    Main.consoleState = EnumConsoleState.CadMENU.getMachineState();

                break;
            case 2:
                Main.consoleState = EnumConsoleState.DelMenu.getMachineState();
                break;
            case 3:
                Main.consoleState = EnumConsoleState.RDMenu.getMachineState();
                break;
            case 4:
                System.out.println("Not Implemented sorry");
                Main.consoleState = EnumConsoleState.MainMenu.getMachineState();
                break;
        }
        return false;


}}

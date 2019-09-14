package com.console.states;

import com.console.Main;

import java.util.Scanner;

public class StateMenu extends StateMachine {
    @Override
    public boolean execute() {
        System.out.println("*** Menu Create");
        Scanner scan = new Scanner(System.in);
        System.out.println("0 - Exit");
        System.out.println("1 - User");
        System.out.println("2 - Product");
        System.out.println("3 - Order");
        System.out.println("4 - Customer");
        int option = scan.nextInt();
        switch (option)
        {
            case 0:
                Main.consoleState = EnumConsoleState.WELCOME.getMachineState();
                break;
            case 1:
                    Main.consoleState = EnumConsoleState.CadUser.getMachineState();
                break;
            case 2:
                Main.consoleState = EnumConsoleState.CadPRODUCT.getMachineState();
                break;
            case 3:
                Main.consoleState = EnumConsoleState.CadORDER.getMachineState();
                break;
            case 4:
                Main.consoleState = EnumConsoleState.CadCUSTOMER.getMachineState();
                break;
        }
        return false;
    }

    }

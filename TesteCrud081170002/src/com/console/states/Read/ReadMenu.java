package com.console.states.Read;

import com.console.Main;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;

import java.util.Scanner;

public class ReadMenu extends StateMachine {
    @Override
    public boolean execute() {
        System.out.println("*** Menu READ");
        Scanner scan = new Scanner(System.in);
        System.out.println("0 - Exit");
        System.out.println("1 - User");
        System.out.println("2 - Product");
        System.out.println("3 - Order");
        System.out.println("4 - Customer");
        int option = scan.nextInt();
        switch (option) {
            case 0:
                Main.consoleState = EnumConsoleState.MainMenu.getMachineState();
                break;
            case 1:
                    Main.consoleState = EnumConsoleState.RDUser.getMachineState();
                break;
            case 2:
                Main.consoleState = EnumConsoleState.RDProduct.getMachineState();
                break;
            case 3:
                Main.consoleState = EnumConsoleState.RDOrder.getMachineState();
                break;
            case 4:
                Main.consoleState = EnumConsoleState.RDCustomer.getMachineState();
                break;
        }
        return false;
    }
}
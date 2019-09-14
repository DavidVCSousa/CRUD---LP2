package com.console.states.DELETE;

import com.console.Main;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;

import java.util.Scanner;

public class DeleteMenu extends StateMachine {
    @Override
    public boolean execute() {
        System.out.println("*** Menu Delete");
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
                    Main.consoleState = EnumConsoleState.DelUser.getMachineState();
                break;
            case 2:
                Main.consoleState = EnumConsoleState.DelProduct.getMachineState();
                break;
            case 3:
                Main.consoleState = EnumConsoleState.DelOrder.getMachineState();
                break;
            case 4:
                Main.consoleState = EnumConsoleState.DelCustomer.getMachineState();
                break;
        }
        return false;
    }
}
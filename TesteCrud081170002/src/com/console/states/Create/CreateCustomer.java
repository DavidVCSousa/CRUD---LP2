package com.console.states.Create;

import com.business.Client;
import com.business.Users.UserBase;
import com.commons.enums.Actions;
import com.console.Main;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;

import java.io.IOException;
import java.util.Scanner;

import static com.dao.UserDAO.loggedUserBase;

public class CreateCustomer extends StateMachine {

    public UserBase registeredUserBase;

    @Override
    public boolean execute() {
        boolean exit = false;
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("**** Customer ****");

            System.out.println("Enter customer cpf");
            String cpf = scan.nextLine();

            System.out.println("Enter customer name");
            String name = scan.nextLine();
            Client client = new Client(cpf, name);
            loggedUserBase.registerObject(client, Actions.Create);
            Main.consoleState = EnumConsoleState.CadMENU.getMachineState();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
        return exit;
    }
}


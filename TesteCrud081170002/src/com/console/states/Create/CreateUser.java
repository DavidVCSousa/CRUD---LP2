package com.console.states.Create;

import com.business.Users.Manager;
import com.business.Users.Salesman;
import com.business.Users.UserBase;
import com.commons.enums.Actions;
import com.console.Main;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;

import java.io.IOException;
import java.util.Scanner;

import static com.dao.UserDAO.loggedUserBase;

public class CreateUser extends StateMachine {

    public UserBase registeredUserBase;
    @Override
    public boolean execute() {
        boolean exit = false;

        Scanner scan = new Scanner(System.in);
        System.out.println("**** user create ****");

        System.out.println("Enter user login name.");
        String userLogin = scan.nextLine();

        System.out.println("Enter user password");
        String userPass = scan.nextLine();

        System.out.println("Enter user name");
        String userName = scan.nextLine();

        System.out.println("Role \n 1 - Manager \n 2 - Salesman");
        int roleOption  = Integer.valueOf(scan.nextLine());
        try {
            switch (roleOption) {
                case 1:
                    registeredUserBase = new Manager(userLogin, userPass, userName);
                    break;
                case 2:
                    registeredUserBase = new Salesman(userLogin, userPass, userName);
                    break;
            }
            loggedUserBase.registerObject(registeredUserBase, Actions.Create);
            Main.consoleState = EnumConsoleState.CadMENU.getMachineState();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
        return exit;
    }
}


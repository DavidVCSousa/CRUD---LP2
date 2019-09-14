package com.console.states;

import com.console.Main;
import com.dao.UserDAO;

import java.util.Scanner;

public class StateLogin extends StateMachine {
    @Override
    public boolean execute() {
        boolean exit = false;

        Scanner scan = new Scanner(System.in);
        System.out.println("**** LOGIN ****");

        System.out.println("Enter your user name");
        String userLogin = scan.nextLine();

        System.out.println("Enter you user password");
        String userPass = scan.nextLine();

        UserDAO access = new UserDAO();
        boolean loggedIn = access.login(userLogin, userPass);
        if (loggedIn)
            Main.consoleState = EnumConsoleState.MainMenu.getMachineState();
        else {
            System.out.println("Credentials does not match!");
        }
        return exit;
    }
    }


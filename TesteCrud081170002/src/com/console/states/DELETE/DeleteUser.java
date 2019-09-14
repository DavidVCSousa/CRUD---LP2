package com.console.states.DELETE;

import com.business.Users.UserBase;
import com.commons.enums.Actions;
import com.console.Main;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;
import com.dao.UserDAO;

import java.io.IOException;
import java.util.Scanner;

public class DeleteUser extends StateMachine {
    @Override
    public boolean execute() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("**** USER DELETE ****");

        System.out.println("Enter user login name.");
        String userLogin = scan.nextLine();

        UserBase ub = UserDAO.FindUser(userLogin);

        if(ub != null && UserDAO.loggedUserBase.HasPermision(ub)) {

            UserDAO.users.remove(ub);
            UserDAO.loggedUserBase.Log(ub, Actions.Delete);
        }
        else{
            System.out.println("Error, Invalid Item or Permisson");

        }
        Main.consoleState = EnumConsoleState.DelMenu.getMachineState();
        return false;
    }
}

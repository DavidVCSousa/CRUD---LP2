package com.console.states.Read;

import com.business.Users.UserBase;
import com.commons.enums.Actions;
import com.console.Main;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;
import com.dao.UserDAO;

import java.io.IOException;
import java.util.Scanner;

public class ReadUser extends StateMachine {
    @Override
    public boolean execute() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("**** USER READ ****");

        System.out.println("Enter user login name.");
        String userLogin = scan.nextLine();

        UserBase ub = UserDAO.FindUser(userLogin);

        if(ub != null && UserDAO.loggedUserBase.HasPermision(ub)) {

            System.out.println(ub.ToJson());
            UserDAO.loggedUserBase.Log(ub, Actions.Read);
        }
        else{
            System.out.println("Error, Invalid Item or Permisson");

        }
        Main.consoleState = EnumConsoleState.DelMenu.getMachineState();
        return false;
    }
}

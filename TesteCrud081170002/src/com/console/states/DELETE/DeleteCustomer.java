package com.console.states.DELETE;

import com.business.Client;
import com.commons.enums.Actions;
import com.console.Main;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;
import com.dao.ClientDAO;
import com.dao.UserDAO;

import java.io.IOException;
import java.util.Scanner;

public class DeleteCustomer extends StateMachine {
    @Override
    public boolean execute() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("**** Customer DELETE ****");

        System.out.println("Enter Customer cpf.");
        String userLogin = scan.nextLine();

        Client ub = ClientDAO.FindClient(userLogin);

        if(ub != null && UserDAO.loggedUserBase.HasPermision(ub)) {

            ClientDAO.Clients.remove(ub);
            UserDAO.loggedUserBase.Log(ub, Actions.Delete);
        }
        else{
            System.out.println("Error, Invalid Item or Permisson");

        }
        Main.consoleState = EnumConsoleState.DelMenu.getMachineState();
        return false;
    }
}

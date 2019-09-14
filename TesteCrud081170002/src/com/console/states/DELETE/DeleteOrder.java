package com.console.states.DELETE;

import com.business.Order;
import com.commons.enums.Actions;
import com.console.Main;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;
import com.dao.OrderDAO;
import com.dao.UserDAO;

import java.io.IOException;
import java.util.Scanner;

public class DeleteOrder extends StateMachine {
    @Override
    public boolean execute() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("**** oRDER DELETE ****");

        System.out.println("Enter user Order Key.");
        String userLogin = scan.nextLine();


        Order ub = OrderDAO.FindOrder(userLogin);

        if(ub != null && UserDAO.loggedUserBase.HasPermision(ub)) {

            OrderDAO.Orders.remove(ub);
            UserDAO.loggedUserBase.Log(ub, Actions.Delete);
        }
        else{
            System.out.println("Error, Invalid Item or Permisson");
        }
        Main.consoleState = EnumConsoleState.DelMenu.getMachineState();
        return false;
    }
}

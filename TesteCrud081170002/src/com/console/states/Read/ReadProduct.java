package com.console.states.Read;

import com.business.Product;
import com.commons.enums.Actions;
import com.console.Main;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;
import com.dao.ProductDAO;
import com.dao.UserDAO;

import java.io.IOException;
import java.util.Scanner;

public class ReadProduct extends StateMachine {
    @Override
    public boolean execute() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("**** Product READ ****");

        System.out.println("Enter pRODUCT sku");
        String userLogin = scan.nextLine();

        Product ub = ProductDAO.FindProduct(userLogin);

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

package com.console.states.DELETE;

import com.business.Product;
import com.commons.enums.Actions;
import com.console.Main;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;
import com.dao.ProductDAO;
import com.dao.UserDAO;

import java.io.IOException;
import java.util.Scanner;

public class DeleteProduct extends StateMachine {
    @Override
    public boolean execute() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("**** Product DELETE ****");

        System.out.println("Enter pRODUCT sku");
        String userLogin = scan.nextLine();

        Product ub = ProductDAO.FindProduct(userLogin);

        if(ub != null && UserDAO.loggedUserBase.HasPermision(ub)) {

            ProductDAO.products.remove(ub);
            UserDAO.loggedUserBase.Log(ub, Actions.Delete);
        }
        else{
            System.out.println("Error, Invalid Item or Permisson");
        }
        Main.consoleState = EnumConsoleState.DelMenu.getMachineState();
        return false;
    }
}

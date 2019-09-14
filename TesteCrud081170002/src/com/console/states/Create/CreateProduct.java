package com.console.states.Create;

import com.business.Product;
import com.business.Users.UserBase;
import com.commons.enums.Actions;
import com.console.Main;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;
import com.dao.ProductDAO;

import java.io.IOException;
import java.util.Scanner;

import static com.dao.UserDAO.loggedUserBase;

public class CreateProduct extends StateMachine {

    public UserBase registeredUserBase;

    @Override
    public boolean execute() {
        ProductDAO repository = new ProductDAO();
        try {
            String sku = null, title;
            double price;
            boolean skuIsUnique = false;
            Scanner scan = new Scanner(System.in);
            System.out.println("**** Product ****");
            while (!skuIsUnique) {
                System.out.println("Enter sku product");
                sku = scan.nextLine();
                if (!repository.idfyIsAlreadyRegistered(sku))
                    skuIsUnique = true;
                else
                    System.out.println("This sku code is already registered.");
            }

            System.out.println("Enter product price");
            price = Double.parseDouble(scan.nextLine()) * 100;

            System.out.println("Enter product title");
            title = scan.nextLine();

            Product product = new Product(sku, price, title);

            loggedUserBase.registerObject(product, Actions.Create);
            Main.consoleState = EnumConsoleState.CadMENU.getMachineState();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}


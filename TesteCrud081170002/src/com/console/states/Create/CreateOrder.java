package com.console.states.Create;

import com.business.Order;
import com.business.OrderItem;
import com.business.Users.UserBase;
import com.commons.enums.Actions;
import com.console.Main;
import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;
import com.dao.ClientDAO;
import com.dao.ProductDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.dao.UserDAO.loggedUserBase;

public class CreateOrder extends StateMachine {

    public UserBase registeredUserBase;

    @Override
    public boolean execute() {
        ClientDAO clientDAO = new ClientDAO();
        ProductDAO productDAO = new ProductDAO();
        try {
            int amount;
            String sku, ynProduct,key = null ,cpf = null;
            boolean customerIsRegistered = false, allProductsRegistered = false;
            ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
            Scanner scan = new Scanner(System.in);
            System.out.println("**** Order ****");
            while (!customerIsRegistered) {
                System.out.println("Enter a customer cpf");
                cpf = scan.nextLine();
                if (clientDAO.clientIsAlreadyRegistered(cpf))
                    customerIsRegistered = true;
                else
                    System.out.println("Customer not found.");
            }

            while (!allProductsRegistered) {
                System.out.println("Enter a Order Key");
                key = scan.nextLine();
                System.out.println("Enter a product sku");
                sku = scan.nextLine();
                if (productDAO.idfyIsAlreadyRegistered(sku)) {
                    System.out.println("Enter the product amount");
                    amount = Integer.valueOf(scan.nextLine());
                    orderItems.add(new OrderItem(sku, amount));
                    System.out.println("Product added!");
                    System.out.println("Do you want to register one more product? Y/n");
                    ynProduct = scan.nextLine();
                    if (!ynProduct.toUpperCase().equals("Y"))
                        allProductsRegistered = true;
                } else
                    System.out.println("Sku not found");
            }

            Order product = new Order(orderItems, cpf,key);
            loggedUserBase.registerObject(product, Actions.Create);

            Main.consoleState = EnumConsoleState.CadMENU.getMachineState();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}


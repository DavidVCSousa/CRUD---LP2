package com.console.states;

import com.console.states.Create.CreateCustomer;
import com.console.states.Create.CreateOrder;
import com.console.states.Create.CreateProduct;
import com.console.states.Create.CreateUser;
import com.console.states.DELETE.*;
import com.console.states.Read.*;

public enum EnumConsoleState {
    WELCOME(new StateWelcome()),

    LOGIN(new StateLogin()),

    CadMENU(new StateMenu()),

    CadUser(new CreateUser()),

    CadPRODUCT(new CreateProduct()),

    CadORDER(new CreateOrder()),

    CadCUSTOMER(new CreateCustomer()),

    DelMenu( new DeleteMenu()),
    MainMenu(new MainMenu()),
    DelUser(new DeleteUser()),
    DelOrder(new DeleteOrder()),
    DelProduct(new DeleteProduct()),
    DelCustomer(new DeleteCustomer()),

    RDMenu(new ReadMenu()),
    RDUser(new ReadUser()),
    RDOrder(new ReadOrder()),
    RDProduct(new ReadProduct()),
    RDCustomer(new ReadCustomer())
    ;


    private final StateMachine machineState;

    EnumConsoleState(StateMachine machineState) {
        this.machineState = machineState;
    }

    public StateMachine getMachineState() {
        return machineState;
    }
}

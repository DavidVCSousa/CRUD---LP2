package Enums;

import Console.Screens.BaseScreen;
import Console.Screens.LoginScreen;
import Console.Screens.MainMenu;
import Console.Screens.Register.*;
import Console.Screens.WelcomeScreen;

public enum Screens {

    welcome(new WelcomeScreen()),

    login(new LoginScreen()),

    mainMenu (new MainMenu()),

    registerMenu(new RegisterMenu()),

    registerClient(new ClientRegisterScreen()),

    registerManager(new ManagerRegisterScreen()),

    registerSalesman(new SalesmanRegisterScreen()),

    registerProduct(new ProductRegisterScreen()),

    registerOrder(new OrderRegisterScreen())
    ;
    private final BaseScreen screen;

    Screens(BaseScreen state) {
        this.screen = state;
    }

    public BaseScreen getScreen() {
        return screen;
    }
}

package Console.Screens;

import Console.Main;
import Enums.Screens;

public class WelcomeScreen extends BaseScreen {

    public WelcomeScreen() {

    }

    @Override
    public void WriteOptions() {
        System.out.println("-------------------");
        System.out.println("---- Bem Vindo ----");
        System.out.println("-------------------");
        super.WriteOptions();
        System.out.println("1 - Login");
    }

    @Override
    public void NextScreenChoose(int x) {
        switch (x) {
            case 0:
                Exit = true;
                break;
            case 1:
                Main.screen = Screens.login.getScreen();
                break;

        }

    }
}

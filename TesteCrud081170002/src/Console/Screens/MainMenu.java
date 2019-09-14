package Console.Screens;

import Console.Main;
import Enums.Screens;

public class MainMenu extends BaseScreen {

    public  MainMenu(){
        backMessage = "Logoff";
    }
    public void WriteOptions() {
        System.out.println("-------------------");
        System.out.println("- Menu  Principal -");
        System.out.println("-------------------");
        super.WriteOptions();
        System.out.println("1 - Menu Cadastrar");
        System.out.println("2 - Menu Consultar");
        System.out.println("3 - Menu Alterar");
        System.out.println("4 - Menu Deletar");
    }
    @Override
    public void NextScreenChoose(int x) {

        switch (x){
            case 0:
                Main.screen = Screens.welcome.getScreen();
                break;
            case 1:
                Main.screen = Screens.registerMenu.getScreen();
                break;
        }


    }
}

package Console.Screens;

import Bussines.Acess.Acess;
import Console.Main;
import Enums.Screens;

import java.util.Scanner;

public class LoginScreen extends BaseScreen {

    public  LoginScreen(){
        backMessage = "Voltar";
    }

    @Override
    public boolean Run() {
        ClearConsole();
        Scanner scan = new Scanner(System.in);
        System.out.println("**** LOGIN ****");
        System.out.println("Digite seu usuário");
        String login = (scan.nextLine());
        System.out.println("Digite sua senha");
        String pass = (scan.nextLine());
        boolean log = Acess.Login(login,pass);
        if(log == false) {
            WriteOptions();
            int x = ReadOptions();
            NextScreenChoose(x);
        }
        else{
            Main.screen = Screens.mainMenu.getScreen();
        }

        return Exit;
    }

    @Override
    public void WriteOptions() {
        super.WriteOptions();
        System.out.println("1 - Tentar Novamente");
    }

    @Override
    public void NextScreenChoose(int x) {
        switch (x) {
            case 0:
                Main.screen = Screens.welcome.getScreen();
                break;
            case 1:
                Main.screen = Screens.login.getScreen();
                break;
        }
    }
}

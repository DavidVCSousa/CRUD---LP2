package Console;

import Bussines.Acess.Acess;
import Bussines.Acess.LoadBussiness;
import Console.Screens.BaseScreen;
import DataObject.DAO.BaseDAO;
import DataObject.VO.User;
import Enums.Screens;

import java.io.IOException;

public class Main {

    public static BaseScreen screen;

    public static void main(String[] args) throws IOException {
        LoadBussiness.Load();

        screen = Screens.welcome.getScreen();;
        Boolean saida = false;
        while (!saida){
            saida = screen.Run();
        }
        BaseDAO.SaveStatus();
    }
}

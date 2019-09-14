package Console.Screens.Register;

import Bussines.Acess.Acess;
import Console.Main;
import Console.Screens.BaseScreen;
import DataObject.VO.Manager;
import DataObject.VO.Master;
import Enums.Screens;

public class RegisterMenu extends BaseScreen {
    {
        backMessage = "Voltar";
    }
    public void WriteOptions() {
        System.out.println("-------------------");
        System.out.println("- Menu  Cadastro -");
        System.out.println("-------------------");
        super.WriteOptions();
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Produto");
        System.out.println("3 - Cadastrar Pedido");
        if(Acess.GetLogedUser() instanceof Manager) {
            System.out.println("4 - Cadastrar Vendedor");
        }
        if(Acess.GetLogedUser() instanceof Master) {
            System.out.println("5 - Cadastrar Gerente");
        }
    }
    @Override
    public void NextScreenChoose(int x) {

        switch (x){
            case 0:
                Main.screen = Screens.mainMenu.getScreen();
                break;
            case 1:
                Main.screen = Screens.registerClient.getScreen();
                break;
            case 2:
                Main.screen = Screens.registerProduct.getScreen();
                break;
            case 4:
                if(Acess.GetLogedUser() instanceof Manager)
                     Main.screen = Screens.registerSalesman.getScreen();
                else
                    return;
                break;
            case 5:
                if(Acess.GetLogedUser() instanceof Master)
                    Main.screen = Screens.registerManager.getScreen();
                else
                    return;;
        }


    }
}

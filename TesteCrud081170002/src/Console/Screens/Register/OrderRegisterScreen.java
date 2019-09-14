package Console.Screens.Register;

import Bussines.Controller.MyArrays;
import Console.Main;
import Console.Screens.BaseScreen;
import DataObject.DAO.BaseDAO;
import DataObject.VO.*;
import Enums.Screens;
import Other.Util.ValidaCPF;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class OrderRegisterScreen extends BaseScreen {

    public  OrderRegisterScreen(){backMessage = "Voltar";}
    protected Order p;
    protected String error;

    @Override
    public boolean Run() throws IOException {
        ClearConsole();
        p = new Order();

        Scanner scan = new Scanner(System.in);
        System.out.println("------ Cadastro de " + p.Type() +" -----");
        System.out.println("Digite o Id do Cliente");
        String name = (scan.nextLine());
        boolean sair = false;

        int x = Integer.MAX_VALUE;
        try {
            x = Integer.parseInt(name);
        }catch (NumberFormatException ex)
        {
            x = Integer.MAX_VALUE;
        }
        Client c = MyArrays.FindClient(x);

        if(c!=null){
            while (!sair) {
                System.out.println("Digite o ID do Produto");
                int y = Integer.MAX_VALUE;
                try {
                    y = Integer.parseInt(name);
                }catch (NumberFormatException ex)
                {
                    y = Integer.MAX_VALUE;
                }
                Product produto = MyArrays.FindProducts(y);
                System.out.println("Digite a Qtd do Produto");
                int z = Integer.MAX_VALUE;
                try {
                    z = Integer.parseInt(name);
                }catch (NumberFormatException ex)
                {
                    z = Integer.MAX_VALUE;
                }

                ((Order)p).AddProduct(produto,z);


            }

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
                Main.screen = Screens.registerMenu.getScreen();
                break;
            case 1:
                 Main.screen = Screens.registerOrder.getScreen();
                break;
        }
    }



}

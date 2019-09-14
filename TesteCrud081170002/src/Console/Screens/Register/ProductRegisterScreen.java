package Console.Screens.Register;

import Bussines.Acess.Acess;
import Bussines.Controller.MyArrays;
import Bussines.Controller.Registers;
import Console.Main;
import Console.Screens.BaseScreen;
import DataObject.DAO.BaseDAO;
import DataObject.VO.Client;
import DataObject.VO.People;
import DataObject.VO.Product;
import DataObject.VO.Salesman;
import Enums.Screens;
import Other.Util.ValidaCPF;

import java.io.IOException;
import java.util.Scanner;

public class ProductRegisterScreen extends BaseScreen {
    public  ProductRegisterScreen(){backMessage = "Voltar";}

    @Override
    public boolean Run() throws IOException {
        ClearConsole();
        Scanner scan = new Scanner(System.in);
        System.out.println("------ Cadastro de Produtos -----");
        System.out.println("Digite o Nome");
        String name = (scan.nextLine());
        System.out.println("Digite o Preço");
        String sprice = (scan.nextLine());

        Double dprice ;
        try {
            dprice = Double.parseDouble(sprice.replace(',', '.'));
        }catch (NumberFormatException ex)
        {
            dprice = null;
        }

        if(!name.isBlank() && dprice != null) {

            Product p = new Product();
            p.setName(name);
            p.setPrice(dprice);

            System.out.println("Sucesso");
            ReportAndAdd(p);
            Main.screen = Screens.registerMenu.getScreen();
            BaseDAO.SaveAllProducts();
        }
        else if(name.isBlank()){
            System.out.println("Falha nome inválido");
            this.WriteOptions();
            int x = this.ReadOptions();
            this.NextScreenChoose(x);
        }
        else{

            System.out.println("Falha preço inválido");
            this.WriteOptions();
            int x = this.ReadOptions();
            this.NextScreenChoose(x);
        }
        return Exit;
    }

    protected  void  ReportAndAdd(Product p ) throws IOException{

        Registers.RegisterProduct((Salesman) Acess.GetLogedUser(),(Product) p);
        MyArrays.AddOnListWithID(p,p.getClass(),MyArrays.products);

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
                Main.screen = Screens.registerProduct.getScreen();
                break;
        }
    }
}

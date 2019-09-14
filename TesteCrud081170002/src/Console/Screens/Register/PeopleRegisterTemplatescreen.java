package Console.Screens.Register;

import Bussines.Acess.Acess;
import Console.Main;
import Console.Screens.BaseScreen;
import DataObject.DAO.BaseDAO;
import DataObject.VO.People;
import Enums.Screens;
import Other.Util.ValidaCPF;

import java.io.IOException;
import java.util.Scanner;

public abstract class PeopleRegisterTemplatescreen extends BaseScreen {

    public  PeopleRegisterTemplatescreen(){backMessage = "Voltar";}
    protected People p;
    protected String error;
    @Override
    public boolean Run() throws IOException {
        ClearConsole();
        p = DoObject();

        Scanner scan = new Scanner(System.in);
        System.out.println("------ Cadastro de " +p.Type() +" -----");
        System.out.println("Digite o Nome");
        String name = (scan.nextLine());
        System.out.println("Digite o CPF");
        String cpf = (scan.nextLine());


        boolean validcpf = ValidaCPF.isCPF(cpf);

       if(!name.isBlank() && validcpf && ContinueResgisterText()) {

           p.setName(name);
           p.setCPF(cpf);

           System.out.println("Sucesso");
           ReportAndAdd(p);
           Main.screen = Screens.registerMenu.getScreen();
           BaseDAO.SaveAllClients();
           BaseDAO.SaveAllUsers();
       }
       else{

           if(name.isBlank()){
               error = "Falha Nome Inválido";
           }
           else if(!validcpf){
               error = "Falha CPF Inválido";
           }
           System.out.println(error);
           this.WriteOptions();
           int x = this.ReadOptions();
           this.NextScreenChoose(x);
       }
        return Exit;
    }
    protected abstract boolean ContinueResgisterText();
    protected abstract Screens Current();
    protected abstract void  ReportAndAdd(People p ) throws IOException;
    protected abstract People DoObject();

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
                Main.screen = Current().getScreen();
                break;
        }
    }

}

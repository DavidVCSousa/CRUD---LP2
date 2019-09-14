package Console.Screens.Register;

import Bussines.Controller.MyArrays;
import DataObject.VO.People;
import DataObject.VO.User;
import Enums.Screens;

import java.io.IOException;
import java.util.Scanner;

public abstract class UserRegisterTemplateScreen extends PeopleRegisterTemplatescreen {
    @Override
    protected boolean ContinueResgisterText() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite seu usuário");
        String login = (scan.nextLine());
        if(login.isBlank() || MyArrays.UserExists(login)){
            error = "Falha Usuário Inválido";
            return  false;
        }
        System.out.println("Digite sua senha");
        String pass = (scan.nextLine());
        if(pass.isBlank()){
            error = "Falha senha Inválido";
            return  false;
        }
        ((User)p).setLogin(login);
        ((User)p).setPassword(pass);

        return true;
    }




}

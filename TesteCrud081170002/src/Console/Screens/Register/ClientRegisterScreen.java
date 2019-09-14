package Console.Screens.Register;

import Bussines.Acess.Acess;
import Bussines.Controller.MyArrays;
import Bussines.Controller.Registers;
import Console.Main;
import DataObject.VO.Client;
import DataObject.VO.People;
import DataObject.VO.Salesman;
import Enums.Screens;

import java.io.IOException;

public class ClientRegisterScreen extends PeopleRegisterTemplatescreen {

    @Override
    public boolean Run() throws IOException {
        return super.Run();

    }

    @Override
    protected boolean ContinueResgisterText() {
            return true;
    }

    @Override
    protected Screens Current() {
        return Screens.registerClient;
    }

    @Override
    protected void ReportAndAdd(People p) throws IOException {

        Registers.RegisterClient((Salesman) Acess.GetLogedUser(),(Client)p);
        MyArrays.AddOnListWithID(p,p.getClass(),MyArrays.clients);
    }

    @Override
    protected People DoObject() {
        return new Client();
    }


}

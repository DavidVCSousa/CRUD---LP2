package Console.Screens.Register;

import Bussines.Acess.Acess;
import Bussines.Controller.MyArrays;
import Bussines.Controller.Registers;
import DataObject.VO.Manager;
import DataObject.VO.Master;
import DataObject.VO.People;
import DataObject.VO.Salesman;
import Enums.Screens;

import java.io.IOException;

public class SalesmanRegisterScreen extends  UserRegisterTemplateScreen {
    @Override
    protected Screens Current() {
        return Screens.registerSalesman;
    }

    @Override
    protected void ReportAndAdd(People p) throws IOException {
        Registers.RegisterSalesman((Manager) Acess.GetLogedUser(),(Salesman) p);
        MyArrays.AddOnListWithID(p,p.getClass(),MyArrays.users);
    }

    @Override
    protected People DoObject() {
        return new Salesman();
    }
}

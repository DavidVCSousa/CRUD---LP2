package Console.Screens.Register;

import Bussines.Acess.Acess;
import Bussines.Controller.MyArrays;
import Bussines.Controller.Registers;
import DataObject.VO.Manager;
import DataObject.VO.Master;
import DataObject.VO.People;
import Enums.Screens;

import java.io.IOException;

public class ManagerRegisterScreen extends UserRegisterTemplateScreen {

    @Override
    protected Screens Current() {
        return Screens.registerManager;
    }

    @Override
    protected void ReportAndAdd(People p) throws IOException {
        Registers.RegisterManager((Master)Acess.GetLogedUser(),(Manager) p);
        MyArrays.AddOnListWithID(p,p.getClass(),MyArrays.users);
    }

    @Override
    protected People DoObject() {
        return new Manager();
    }
}

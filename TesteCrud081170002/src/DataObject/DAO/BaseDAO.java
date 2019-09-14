package DataObject.DAO;

import Bussines.Acess.Acess;
import Bussines.Controller.MyArrays;
import DataObject.VO.*;
import Other.Json.JSONObject;
import DataObject.VO.*;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static Bussines.Acess.Acess.ordersTXT;

abstract public class BaseDAO {

    public abstract BaseVO Read(JSONObject obj);

    public  JSONObject Save(BaseVO obj){return obj.ToJsonString();};

    static public void  SaveStatus() throws IOException {
        SaveAllUsers();
        SaveAllProducts();
        SaveAllOrders();
        SaveAllClients();
    }

    static public  void SaveAllUsers() throws IOException {
        List<String> ls = new LinkedList<>();
        for (User c:
                MyArrays.users ) {
            ls.add(c.ToJsonString().toString());
        }
        WriteFile(Acess.usersTXT.toPath().toString(),ls);
    }
    static public  void SaveAllOrders() throws IOException {
        List<String> ls = new LinkedList<>();
        for (Order c:
                MyArrays.orders ) {
            ls.add(c.ToJsonString().toString());
        }
        WriteFile(ordersTXT.toPath().toString(),ls);
    }
    static public  void SaveAllClients() throws IOException {
        List<String> ls = new LinkedList<>();
        for (Client c:
                MyArrays.clients ) {
            ls.add(c.ToJsonString().toString());
        }
        WriteFile(Acess.clientsTXT.toPath().toString(),ls);
    }
    static public  void SaveAllProducts() throws IOException {
        List<String> ls = new LinkedList<>();
        for (Product c:
                MyArrays.products ) {
            ls.add(c.ToJsonString().toString());
        }
        WriteFile(Acess.productsTXT.toPath().toString(),ls);
    }

    private static void WriteFile(String path,List ls) throws IOException {

        File fout = new File(path);
        FileOutputStream fos = new FileOutputStream(fout);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        for (int i = 0; i < ls.size(); i++) {
            bw.write(ls.get(i).toString());
            bw.newLine();
        }

        bw.close();
    }


}

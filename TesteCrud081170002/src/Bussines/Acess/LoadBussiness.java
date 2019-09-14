package Bussines.Acess;

import Bussines.Controller.MyArrays;
import DataObject.DAO.*;
import DataObject.VO.*;
import Other.Json.JSONObject;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class LoadBussiness {


    static public void Load() throws IOException {

        File directory = new File(System.getProperty("user.dir") + "\\Texts\\");
        if (!directory.exists()) {
            directory.mkdir();
        }
        if (!Acess.LogsTXT.exists()) {

            Acess.LogsTXT.createNewFile();
        }
        if (!Acess.clientsTXT.exists()) {

            Acess.clientsTXT.createNewFile();
        }
        if (!Acess.productsTXT.exists()) {

            Acess.productsTXT.createNewFile();
        }
        if (!Acess.ordersTXT.exists()) {

            Acess.ordersTXT.createNewFile();
        }
        if (!Acess.usersTXT.exists()) {

            Acess.usersTXT.createNewFile();
        }

        List<String> allUsers = Files.readAllLines(Acess.usersTXT.toPath());
        if (allUsers.size() == 0) {
            Master ms = new Master();
            ms.setID(0);
            ms.setName("Master");
            ms.setLogin("master");
            ms.setPassword("master");
            ms.setCPF("000.000.000-00");

            MyArrays.users.add(ms);
        }
        else {
            var m = new MasterDAO();
            var k = new SalesmanDAO();
            var g = new ManagerDAO();

            for (String s : allUsers) {

                var json = new JSONObject(s);
                if (json.getString("Type").equals("Master")) {
                    MyArrays.users.add((Master) m.Read(json));
                } else if (json.getString("Type").equals("Salesman")) {
                    MyArrays.users.add((Salesman) k.Read(json));
                } else if (json.getString("Type").equals("Manager")) {
                    MyArrays.users.add((Manager) g.Read(json));
                }
            }
        }

        List<String> allClients = Files.readAllLines(Acess.clientsTXT.toPath());
        if (allClients.size() > 0) {
            var c = new ClientDAO();
            for (String s : allClients) {
                var json = new JSONObject(s);
                MyArrays.clients.add((Client) c.Read(json));
            }
        }

        List<String> allOrders = Files.readAllLines(Acess.ordersTXT.toPath());
        if (allOrders.size() > 0) {
            var c = new OrderDAO();
            for (String s : allOrders) {
                var json = new JSONObject(s);
                MyArrays.orders.add((Order) c.Read(json));
            }
        }

        List<String> allproducts = Files.readAllLines(Acess.productsTXT.toPath());
        if (allproducts.size() > 0) {
            var c = new OrderDAO();
            for (String s : allproducts) {
                var json = new JSONObject(s);
                MyArrays.products.add((Product) c.Read(json));
            }
        }
    }

}




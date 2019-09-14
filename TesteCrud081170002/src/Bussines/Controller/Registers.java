package Bussines.Controller;

import Bussines.Acess.Acess;
import DataObject.VO.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Registers {


    public static void RegisterProduct(Salesman v, Product p)throws IOException {
        Writer output;
        output = new BufferedWriter(new FileWriter(Acess.LogsTXT.getName()));  //clears file every time
        output.append(v.getName() + " registered product " + p.getName());
        output.close();
    }

    public static void RegisterOrder(Salesman v, Order p)throws IOException {
        Writer output;
        output = new BufferedWriter(new FileWriter(Acess.LogsTXT.getName()));  //clears file every time
        output.append(v.getName() + " request order " + p.getID());
        output.close();
    }

    public static void RegisterClient(Salesman v,Client c)throws IOException {
        Writer output;
        output = new BufferedWriter(new FileWriter(Acess.LogsTXT.getName()));  //clears file every time
        output.append(v.getName() + " registered client " + c.getName());
        output.close();
    }

    public static void RegisterSalesman(Manager g,Salesman v)throws IOException {
        Writer output;
        output = new BufferedWriter(new FileWriter(Acess.LogsTXT.getName()));  //clears file every time
        output.append(g.getName() + " registered salesman" + v.getName());
        output.close();
    }

    public static void RegisterManager(Master g, Manager v)throws IOException {
        Writer output;
        output = new BufferedWriter(new FileWriter(Acess.LogsTXT.getName()));  //clears file every time
        output.append(g.getName() + " registered manager" + v.getName());
        output.close();
    }




}

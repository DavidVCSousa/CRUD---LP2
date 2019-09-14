package Bussines.Acess;

import Bussines.Controller.MyArrays;
import DataObject.VO.User;

import java.io.File;

public class Acess {
    
    static private User loggedUser;
    static final public File usersTXT = new File(System.getProperty("user.dir")+"\\Texts\\user.txt");
    static final public File productsTXT = new File(System.getProperty("user.dir")+"\\Texts\\products.txt");
    static final public File ordersTXT = new File(System.getProperty("user.dir")+"\\Texts\\orders.txt");
    static final public File clientsTXT = new File(System.getProperty("user.dir")+"\\Texts\\clients.txt");
    static final public File LogsTXT = new File(System.getProperty("user.dir")+"\\Texts\\logs.txt");

    static public User GetLogedUser(){return loggedUser;}

    public static boolean Login (String login,String password)
    {
        var s = MyArrays.users;
        for (User u: MyArrays.users) {
            if(login.equals(u.getLogin()) && password.equals(u.getPassword())) {
                loggedUser = u;
                return true;
            }
        }
        return  false;
    }    
}

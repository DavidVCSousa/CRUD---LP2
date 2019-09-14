package com.dao;

import com.business.Users.Manager;
import com.business.Users.Salesman;
import com.business.Users.UserBase;
import com.commons.Util.Json.JSONObject;
import com.commons.enums.FilePath;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {
    public static UserBase loggedUserBase;
    public static List<UserBase>     users    = new LinkedList<UserBase>();



    public static void LoadUsers() {
        try {
            FileManager manager = new FileManager();
            users = new LinkedList<UserBase>();
            String[] allUsers = manager.readLines(FilePath.User.getPath());
            for (String s : allUsers) {

                var json = new JSONObject(s);
                if (json.getString("Type").equals("Salesman")) {
                    users.add(new Salesman(json.getString("UserName"), json.getString("Password"), json.getString("Name")));
                } else if (json.getString("Type").equals("Manager")) {
                    users.add(new Manager(json.getString("UserName"), json.getString("Password"), json.getString("Name")));
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void registerEmployee(UserBase userBase) {
        FileManager manager = new FileManager();
        try {
            manager.writeFile(
                    FilePath.User.getPath(),
                    userBase.ToJson().toString()
            );
            System.out.println("Usuário salvo com sucesso!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public boolean login(String user, String pass) {
        for (UserBase u: users) {
            if(u.ValidCredentials(user,pass)) {
                loggedUserBase = u;
                return true;
            }
        }
        return  false;
    }

    public static UserBase FindUser(String user){
        for (UserBase u: users) {
            if(u.getName().equals(user)){
                return u;
            }
        }
        return  null;
    }


}

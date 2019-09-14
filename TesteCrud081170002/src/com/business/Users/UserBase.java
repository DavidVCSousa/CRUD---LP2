package com.business.Users;

import com.business.RegistrableObject;
import com.commons.Util.Json.JSONObject;
import com.commons.enums.Actions;
import com.commons.enums.Permissions;
import com.commons.enums.Types;
import com.commons.enums.UserFunciton;
import com.dao.LogRepository;
import com.dao.UserDAO;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class UserBase extends RegistrableObject {

    public UserBase(String userName, String password, String name, UserFunciton userFunciton) {
        if(userName.isEmpty() || name.isEmpty() || password.isEmpty())
            throw new IllegalArgumentException();

        this.userName = userName;
        this.password = password;
        this.name = name;
        this.userFunciton = userFunciton;
    }

    public String getName() {
        return name;
    }

    @Override
    public void register(RegistrableObject obj) {
        UserDAO repository = new UserDAO();
        repository.registerEmployee((UserBase) obj);
    }

    @Override
    public Types Type() {
        return null ;
    }

    public void registerObject(RegistrableObject obj, Actions a) throws IOException {
        String className = obj.getClass().getSimpleName();
        System.out.println(className);

        if (HasPermision(obj)) {
            if(a != Actions.Delete) {
                obj.register(obj);
            }
           Log(obj,a);
        } else {
            throw new IllegalArgumentException("Permissão de usuário negada.");
        }
    }
    public boolean HasPermision(RegistrableObject obj){
        return Arrays.asList(userFunciton.getPermisions()).contains(Permissions.valueOf(
                obj.getClass().getSimpleName()));
    }
    public void Log(RegistrableObject obj, Actions a) throws IOException {
        LogRepository.registerLog(obj.getClass().getSimpleName() + "|" + userName + "|" +a.getAction() + "|" + new Date());
    }

    @Override
    public JSONObject ToJson() {
        JSONObject obj =  new JSONObject();
        obj.put("Type",Type().getTypeName());
        obj.put("UserName",userName);
        obj.put("Name",name);
        obj.put("Password",password);
        return obj;
    }
    public boolean isManager() {
        return userFunciton == UserFunciton.Manager;
    }

    public boolean ValidCredentials(String user,String password){ return (user.equals(userName)&&password.equals(this.password));}

    public String getUserName() {
        return userName;
    }

    private UserFunciton userFunciton;
    private String name;
    private String userName;
    private String password;
}

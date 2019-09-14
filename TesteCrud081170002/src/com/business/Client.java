package com.business;

import com.commons.Util.Json.JSONObject;
import com.commons.enums.Types;
import com.dao.ClientDAO;

import java.io.IOException;

public class Client extends RegistrableObject {
    private String cpf;
    private String name;


    public String getCpf() {
        return cpf;
    }

    public Client(String cpf, String name) {
        if(cpf.isEmpty() || name.isEmpty())
            throw new IllegalArgumentException();
        this.cpf = cpf;
        this.name = name;
    }

    @Override
    public void register(RegistrableObject obj) throws IOException {
        ClientDAO repository = new ClientDAO();
        repository.registerClient((Client) obj);
    }

    @Override
    public JSONObject ToJson() {
        JSONObject obj =  new JSONObject();
        obj.put("Type",Type().getTypeName());
        obj.put("cpf",cpf);
        obj.put("Name",name);
        return obj;
    }

    @Override
    public Types Type() {
        return Types.Client;
    }

    @Override
    public String toString() {
        return cpf + "|" + name;
    }

}

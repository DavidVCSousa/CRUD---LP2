package com.dao;

import com.business.Client;
import com.commons.Util.Json.JSONObject;
import com.commons.enums.FilePath;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ClientDAO {

    public static List<Client> Clients    = new LinkedList<Client>();


    public static void LoadClients() {
        try {
            FileManager manager = new FileManager();
            Clients = new LinkedList<Client>();
            String[] allClients = manager.readLines(FilePath.Client.getPath());
            for (String s : allClients) {

                var json = new JSONObject(s);
                Clients.add(new Client(json.getString("cpf"),json.getString("Name")));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void registerClient(Client client) throws IOException {
        FileManager actions = new FileManager();
        actions.writeFile(
                FilePath.Client.getPath(),
                client.ToJson().toString()
        );
        System.out.println("Customer successfully saved!");
    }

    public boolean clientIsAlreadyRegistered(String idtfy) throws IOException {

        return FindClient(idtfy) == null;
    }

    public static Client FindClient(String Client){
        for (Client u: Clients) {
            if(u.getCpf().equals(Client)){
                return u;
            }
        }
        return  null;
    }
}

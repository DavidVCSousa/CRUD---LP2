package DataObject.VO;

import DataObject.DAO.ClientDAO;
import DataObject.DAO.ProductDAO;
import DataObject.DAO.SalesmanDAO;
import Other.Json.JSONArray;
import Other.Json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class Order extends BaseVO {

    Salesman  salesman;
    Client client;
    List<Product> products  = new LinkedList<Product>();
    List<Integer> productsqtd  = new LinkedList<Integer>();

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void AddProduct(Product p,int qtd){
        products.add(p);
        productsqtd.add(qtd);
    }
    public void RemoveProduct(int index){
        products.remove(index);
        productsqtd.remove(index);
    }
    public  int TotalProductsTypes() {
        return  products.size();
    }
    @Override
    public JSONObject ToJsonString() {
        var j = super.ToJsonString();
        var jarray = new JSONArray();
        var jiarray = new JSONArray();
        for (Product p: products ) {
            jarray.put(p.ToJsonString());
        }
        for(int i:productsqtd){
            jiarray.put(i);
        }

        j.put("Products",jarray);
        j.put("Client",client.ToJsonString());
        j.put("Salesman",salesman.ToJsonString());
        j.put("Qtds",jiarray);
        return j;
    }

    @Override
    public void SetFromJsonString(JSONObject obj) {
        super.SetFromJsonString(obj);
        var dao  =  new ProductDAO();
        var dao2 =  new ClientDAO();
        var dao3 =  new SalesmanDAO();

        for (Object j : obj.getJSONArray("Products")){

            products.add((Product) dao.Read((JSONObject)j));
        }
        var ls  =obj.getJSONArray("Qtds");
        for (int i = 0; i <ls.length() ; i++) {
           productsqtd.add(ls.getInt(i));
        }
        client = (Client) dao2.Read(new JSONObject(obj.getJSONObject("Client")));
        salesman = (Salesman) dao3.Read(new JSONObject(obj.getJSONObject("Salesman")));

    }
    @Override
    public String Type() {
        return "Order";
    }
}

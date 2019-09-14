package DataObject.VO;

import Other.Json.JSONObject;

public class Product extends BaseVO {

    String Name;
    double Price;

    public  String getName(){return  Name;}
    public  void setName(String agr){Name = agr;}

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    @Override
    public JSONObject ToJsonString() {
        var j = super.ToJsonString();
        j.put("Name",Name);
        j.put("Price",Price);
        return j;
    }

    @Override
    public void SetFromJsonString(JSONObject obj) {
        super.SetFromJsonString(obj);
        Name  = obj.getString("Name");
        Price = obj.getDouble("Price");
    }


    @Override
    public String Type() {
        return "Product";
    }
}

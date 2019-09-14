package DataObject.VO;

import Other.Json.JSONObject;

public abstract class BaseVO {

    int Id;

    public int getID(){return Id;}
    public void setID(int id){Id = id;}

    public abstract String Type();

    public JSONObject ToJsonString()
    {
        var obj =  new JSONObject();
        obj.put("Type",Type());
        obj.put("ID",Id);
        return  obj;
    }

    public void SetFromJsonString(JSONObject obj)
    {
        Id = obj.getInt("ID");
    }

}

package DataObject.VO;

import Other.Json.JSONObject;

public class People extends BaseVO {


    String Name;
    String   CPF;
   // Long   RG;

    public String getCPF(){return CPF;}
    public void setCPF(String cpf){CPF = cpf;}
    //public Long getRG(){return RG;}
    //public void SetRG(long rg){RG = rg;}

    public  String getName(){return  Name;}
    public  void setName(String agr){Name = agr;}


    @Override
    public JSONObject ToJsonString() {
        var j = super.ToJsonString();
        j.put("CPF",CPF);
        j.put("Name",Name);
        //j.put("RG",RG);
        return j;
    }

    @Override
    public void SetFromJsonString(JSONObject obj) {
        super.SetFromJsonString(obj);

        Name  = obj.getString("Name");
        CPF = obj.getString("CPF");
       // RG = obj.getLong("RG");
    }

    @Override
    public String Type() {
        return "People";
    }
}

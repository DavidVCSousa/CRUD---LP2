package DataObject.VO;

import Other.Json.JSONObject;

public class User extends People {


    private String password;
    private String login;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getLogin() {
        return  login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    @Override
    public String Type() {
        return "User";
    }

    @Override
    public JSONObject ToJsonString() {
        var j = super.ToJsonString();
        j.put("login",login);
        j.put("password",password);

        return j ;
    }

    @Override
    public void SetFromJsonString(JSONObject obj) {
        super.SetFromJsonString(obj);
        login = obj.getString("login");
        password = obj.getString("password");
    }
}

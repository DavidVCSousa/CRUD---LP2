package DataObject.DAO;

import DataObject.DAO.BaseDAO;
import DataObject.VO.BaseVO;
import Other.Json.JSONObject;
import DataObject.VO.Client;

public class ClientDAO extends BaseDAO {

    @Override
    public BaseVO Read(JSONObject obj) {
        var c = new Client();
        c.SetFromJsonString(obj);
        return  c;
    }

}

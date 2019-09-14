package DataObject.DAO;

import DataObject.DAO.BaseDAO;
import DataObject.VO.BaseVO;
import DataObject.VO.Salesman;
import Other.Json.JSONObject;

public class SalesmanDAO extends BaseDAO {

    @Override
    public BaseVO Read(JSONObject obj) {
        var c = new Salesman();
        c.SetFromJsonString(obj);
        return  c;
    }
}

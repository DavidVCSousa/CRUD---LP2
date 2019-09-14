package DataObject.DAO;

import DataObject.DAO.BaseDAO;
import DataObject.VO.BaseVO;
import Other.Json.JSONObject;
import DataObject.VO.Order;

public class OrderDAO extends BaseDAO {

    @Override
    public BaseVO Read(JSONObject obj) {
        Order mg =  new Order();
        mg.SetFromJsonString(obj);
        return mg;
    }



}

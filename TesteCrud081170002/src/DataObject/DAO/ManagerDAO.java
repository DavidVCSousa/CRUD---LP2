package DataObject.DAO;

import DataObject.DAO.BaseDAO;
import DataObject.VO.BaseVO;
import DataObject.VO.Manager;
import Other.Json.JSONObject;

public class ManagerDAO extends BaseDAO {
    @Override
    public BaseVO Read(JSONObject obj) {
        Manager mg =  new Manager();
        mg.SetFromJsonString(obj);
        return mg;
    }

}

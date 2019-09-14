package DataObject.DAO;

import DataObject.DAO.BaseDAO;
import DataObject.VO.BaseVO;
import DataObject.VO.Master;
import Other.Json.JSONObject;

public class MasterDAO extends BaseDAO {

    @Override
    public BaseVO Read(JSONObject obj) {
        Master mg =  new Master();
        mg.SetFromJsonString(obj);
        return mg;
    }

}

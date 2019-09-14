package DataObject.DAO;

import DataObject.VO.BaseVO;
import DataObject.VO.Product;
import Other.Json.JSONObject;

public class ProductDAO extends BaseDAO {
    @Override
    public BaseVO Read(JSONObject obj) {
        Product p =  new Product();
        p.SetFromJsonString(obj);
        return  p;
    }
}

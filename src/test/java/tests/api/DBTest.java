package tests.api;

import core.db.DBUtils;
import org.testng.annotations.Test;

public class DBTest {

   // @Test
    public void testDBConnection(){

        String query="SELECT 1";
        String result= DBUtils.getSingleValue(query);
        System.out.println("DB Result:" + result);

        assert result.equals("1");
    }
}

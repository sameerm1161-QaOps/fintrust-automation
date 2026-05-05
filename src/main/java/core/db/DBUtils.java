package core.db;

import com.mysql.cj.protocol.Resultset;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtils {

    public static String getSingleValue(String query){
        String result="";

        try{
            Connection conn=DBManager.getConnection();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);

            if(rs.next()){
                result=rs.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}

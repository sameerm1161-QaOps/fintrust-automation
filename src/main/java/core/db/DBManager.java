package core.db;

import config.ConfigManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    private static Connection connection;

    public static Connection getConnection(){
        try{
            if(connection==null || getConnection().isClosed()){
                String url= ConfigManager.getInstance().getProperty("dbUrl");
                String user= ConfigManager.getInstance().getProperty("dbUser");
                String password= ConfigManager.getInstance().getProperty("dbPassword");

                connection = DriverManager.getConnection(url, user, password);

                System.out.println("✅ DB Connected Successfully");
            }

        }catch (Exception e){
            System.out.println("❌ DB Connection FAILED");
            e.printStackTrace();
        }
        return connection;
    }
}

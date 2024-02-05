package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
    private final Properties prop;

    public DBHelper() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream("properties/settings.properties"));
        } catch (IOException e) {
            System.out.println("Problem loading properties");
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(prop.getProperty("url"),
                                           prop.getProperty("userName"),
                                           prop.getProperty("password"));

    }
}

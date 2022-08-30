
package adapterproject.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseConnection {
    private static DatabaseConnection instance;
    private java.sql.Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {

    }

    public void connectToDatabase(){   
        String server = "DESKTOP-3T2SIH8";
        String port = "1433";
        String database = "Adapter";
        String userName = "sa";
        String password = "123";
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://" + server + ":" + port + "/" + database, userName, password);
            if(connection != null){
                System.out.println("Connection OK");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
    }

    public java.sql.Connection getConnection() {
        return connection;
    }

    public void setConnection(java.sql.Connection connection) {
        this.connection = connection;
    }
}

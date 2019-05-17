import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBC {

    private static Connection connection = null;
    private final static String ADRESS   = "";
    private final static String DATABASE = "";
    private final static String PORT     = "";
    private final static String DRIVER   = "";

    private static void loadDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch (Exception e) {
            errorHandler("Failed to load the driver " + DRIVER, e);
        }
    }

    private static void loadConnection() {
        try {
            connection  = DriverManager.getConnection("jdbc:sqlite:C:/Users/User/Desktop/BD/src/sample/klass\\kyrsachok");

        }
        catch (SQLException e) {
            errorHandler("Failed to connect to the database " + getFormatedUrl(), e);
        }
    }


    private static void errorHandler(String message, Exception e) {
        System.out.println(message);
        if (e != null) System.out.println(e.getMessage());
    }


    private static String getFormatedUrl() {
        return ADRESS + ":" + PORT + "/" + DATABASE;
    }


    public static Connection getConnection() {
        if (connection == null) {
            loadDriver();
            loadConnection();
        }
        return connection;
    }


    public static void closeConnection() {
        if (connection == null) {
            errorHandler("No connection found", null);
        }
        else {
            try {
                connection.close();
                connection = null;
            }
            catch (SQLException e) {
                errorHandler("Failed to close the connection", e);
            }
        }
    }
}

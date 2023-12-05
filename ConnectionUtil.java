import java.sql.*;
public class ConnectionUtil {
    public Connection connect_to_db(String dbname, String user, String pass) {

        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Подключение успешно");
            } else {
                System.out.println("Ошибка(");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}

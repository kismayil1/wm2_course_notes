package az.edu.ada.wm2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/wm2_db";
    private static final String USERNAME = "Mysql@localhost:3306";
    private static final String PASSWORD = "ilahe8116861";

    public static void main(String[] args) {
        try {
            new App().getStudents();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void getStudents() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");

            ResultSet rs = ps.executeQuery();

            System.out.printf("%11s%20s%20s%10s\n", "id", "fname", "lname", "gpa");
            while (rs.next()) {
                System.out.printf("%11d%20s%20s%10.2f\n", rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getFloat(4));
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            
        }
    }

}

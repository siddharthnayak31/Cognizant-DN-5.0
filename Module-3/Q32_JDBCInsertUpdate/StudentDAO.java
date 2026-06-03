package Q32_JDBCInsertUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/studentdb";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void insertStudent(int id, String name) {

        try {
            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            String query =
                    "INSERT INTO students(id,name) VALUES(?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateStudent(int id, String name) {

        try {
            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            String query =
                    "UPDATE students SET name=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
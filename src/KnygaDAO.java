import java.sql.*;
import java.util.ArrayList;

public class KnygaDAO {

    public static void insert(Knyga knyg) {

        String url = "jdbc:mysql://localhost:3306/database";

        String query = "INSERT INTO knygos "
                + "(vardas, pavarde, isleidimo_metai, leidimas, pavadinimas) "
                + "VALUES (?,?,?,?,?)";

        try {
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, kn1.getVardas());
            st.setString(2, user.getSurname());
            st.setDouble(3, user.getSalary());

            st.executeUpdate();
            st.close();

            System.out.println("Completed successfully");

        } catch (SQLException e) {

            System.out.println("Can't login");
            e.printStackTrace();
        }
    }

    public static void edit(Employee user) {

        String url = "jdbc:mysql://localhost:3306/database";

        String query = " UPDATE employees "
                + " SET name = ?, "
                + " surname = ?, "
                + " salary = ?, "
                + " data = ? "
                + " WHERE id = ? ";

        try {
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setDouble(3, user.getSalary());
            st.setString(4, user.getData());
            st.setInt(5, user.getId());

            st.executeUpdate();
            st.close();

            System.out.println("Database edited");

        } catch (SQLException e) {

            System.out.println("Can't login");
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> searchById(int id) {

        String url = "jdbc:mysql://localhost:3306/database";

        String query = "SELECT * FROM employees WHERE id = ?";

        ArrayList employeeList = new ArrayList<Employee>();

        try {
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement st = conn.prepareStatement(query);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                employeeList.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getDouble("salary"),
                        rs.getString("data"))
                );
            }

            st.close();

            System.out.println("Search by id successful");

        } catch (SQLException e) {

            System.out.println("Problemyte ieskant");
            e.printStackTrace();
        }

        return employeeList;
    }

    public static void delete(int id) {

        String url = "jdbc:mysql://localhost:3306/database";

        String query = " DELETE FROM employees "
                + " WHERE id = ? ";

        try {
            Connection conn = DriverManager.getConnection(url, "root", "");
            PreparedStatement st = conn.prepareStatement(query);

            st.setInt(1, id);

            st.executeUpdate();
            st.close();

            System.out.println("Database deleted");

        } catch (SQLException e) {

            System.out.println("Can't delete record");
            e.printStackTrace();
        }
    }
}

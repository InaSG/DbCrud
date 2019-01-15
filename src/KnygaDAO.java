import java.sql.*;
import java.util.ArrayList;

public class KnygaDAO {

    static String url = "jdbc:mysql://localhost:3306/Biblioteka";

    public static void insert(Knyga knygaNr) {

        String query = "INSERT INTO knygos "
                + "(vardas, pavarde, isleidimo_metai, leidimas, pavadinimas) "
                + "VALUES (?,?,?,?,?)";

        try {
            Connection conn = DriverManager.getConnection(url, "ina", "ina123456789");
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, knygaNr.getVardas());
            st.setString(2, knygaNr.getPavarde());
            st.setInt(3, knygaNr.getIsleidimo_metai());
            st.setInt(4, knygaNr.getLeidimas());
            st.setString( 5, knygaNr.getPavadinimas());

            st.executeUpdate();
            st.close();

            System.out.println("Completed successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void edit(Knyga knygaNr) {

        String query = " UPDATE knygos "
                + " SET vardas = ?, "
                + " pavarde = ?, "
                + " isleidimo_metai = ?, "
                + " leidimas = ?, "
                + " pavadinimas = ? "
                + " WHERE id = ? ";

        try {
            Connection conn = DriverManager.getConnection(url, "ina", "ina123456789");
            PreparedStatement st = conn.prepareStatement(query);

            st.setString(1, knygaNr.getVardas());
            st.setString(2, knygaNr.getPavarde());
            st.setInt(3, knygaNr.getIsleidimo_metai());
            st.setInt(4, knygaNr.getLeidimas());
            st.setString( 5, knygaNr.getPavadinimas());
            st.setInt(6, knygaNr.getId());

            st.executeUpdate();
            st.close();

            System.out.println("Database edited");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Knyga> searchById(int id) {

        String query = "SELECT * FROM knygos WHERE id = ?";

        ArrayList knygaList = new ArrayList<Knyga>();

        try {
            Connection conn = DriverManager.getConnection(url, "ina", "ina123456789");
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                knygaList.add(new Knyga(
                        rs.getInt("id"),
                        rs.getString("vardas"),
                        rs.getString("pavarde"),
                        rs.getInt("isleidimo_metai"),
                        rs.getInt ("leidimas"),
                        rs.getString("pavadinimas"))
                );
            }

            st.close();

            System.out.println("Search by id successful");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return knygaList;
    }

    public static void delete(int id) {

        String query = "DELETE FROM knygos WHERE id = ? ";

        try {
            Connection conn = DriverManager.getConnection(url, "ina", "ina123456789");
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
            st.close();

            System.out.println("Data deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int knyguIsleidimoMetai(int metai) {
        int rezultatas = 0;

        String query = "SELECT COUNT(*) FROM knygos WHERE isleidimo_metai = ?";

        try {
            Connection conn = DriverManager.getConnection(url, "ina", "ina123456789");
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, metai);
            ResultSet resultSet = st.executeQuery();
            if(resultSet.next()) {
                rezultatas = resultSet.getInt(1);
            }
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rezultatas;
    }
}

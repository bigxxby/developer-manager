import java.math.BigDecimal;
import java.sql.*;

public class DeveloperManager {
    private Statement statement;
    private Connection сonnection;

    public DeveloperManager(Statement st, Connection connection) {
        this.statement = st;
        this.сonnection = connection;
    }

    public void addDeveloper(Developer developer) throws SQLException {
        String q = "INSERT INTO developers (name, specialty, salary) VALUES ('" + developer.getName() + "', '" + developer.getSpecialty() + "', " + developer.getSalary() + ");";
        this.statement.execute(q);


    }

    public void filterByName(String namethis) throws SQLException {
        String q = "SELECT * FROM developers WHERE name = ?";

        PreparedStatement preparedStatement = this.сonnection.prepareStatement(q);

        preparedStatement.setString(1, namethis);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            System.out.println("id: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Specialty: " + rs.getString("specialty"));
            System.out.println("Salary: " + rs.getBigDecimal("salary"));
            System.out.println();
        }
        rs.close();
    }

    public void filterBySalary() throws SQLException {
        String q = "SELECT * FROM developers ORDER BY salary";
        statement.executeQuery(q);
        ResultSet rs = statement.getResultSet();

        while (rs.next()) {
            System.out.println("id: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Specialty: " + rs.getString("specialty"));
            System.out.println("Salary: " + rs.getBigDecimal("salary"));
            System.out.println();
        }
        rs.close();
    }

    public void changeDeveloper(int id, String nm, String sp, BigDecimal sl) throws SQLException {
        String q = "UPDATE developers SET name = ?, specialty = ?, salary = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = this.сonnection.prepareStatement(q)) {
            preparedStatement.setString(1, nm);
            preparedStatement.setString(2, sp);
            preparedStatement.setBigDecimal(3, sl);
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        }
    }


    public void showDevelopers() throws SQLException {
        ResultSet rs = statement.getResultSet();
        rs = statement.executeQuery("SELECT * FROM developers");
        System.out.println("All devs:");
        while (rs.next()) {
            System.out.println("id: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Specialty: " + rs.getString("specialty"));
            System.out.println("Salary: " + rs.getBigDecimal("salary"));
            System.out.println();
        }
        rs.close();
    }

    public void showDeveloper(int idd) throws SQLException {
        String q = "SELECT * FROM developers WHERE id = ?";
        PreparedStatement preparedStatement = this.сonnection.prepareStatement(q);
        preparedStatement.setInt(1, idd);


        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {

            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("Name: " + resultSet.getString("name"));
            System.out.println("Specialty: " + resultSet.getString("specialty"));
            System.out.println("Salary: " + resultSet.getBigDecimal("salary"));
        }
        resultSet.close();
    }

    public void drop() throws SQLException {
        statement.execute("DELETE FROM developers");
    }

    public void deleteDeveloper(int idd) throws SQLException {
        String q = "DELETE FROM developers WHERE id = ?";
        try (PreparedStatement preparedStatement = this.сonnection.prepareStatement(q)) {
            preparedStatement.setInt(1, idd);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR " + ex.getMessage());
        }

    }

    public void closeManager() throws SQLException {
        this.statement.close();
    }
}

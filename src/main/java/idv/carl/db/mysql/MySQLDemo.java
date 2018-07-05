package idv.carl.db.mysql;

import java.sql.*;

/**
 * @author Carl Lu
 */
public class MySQLDemo {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

    private static final String USER_NAME = "root";
    private static final String PASSWORD = "idsl";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open the connection
            System.out.println("Connect to database...");
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

            // Execute the query
            System.out.println("Init statement instance...");
            statement = connection.createStatement();

            String sql = "select * from users";

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("User info: ID = " + id + ", NAME = " + name);
            }
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Query done...");
    }

}

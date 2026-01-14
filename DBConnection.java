import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:librarydb.db";
            conn = DriverManager.getConnection(url);

            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS books (" +
                    "book_id INTEGER PRIMARY KEY, " +
                    "title TEXT NOT NULL, " +
                    "author TEXT NOT NULL, " +
                    "quantity INTEGER NOT NULL)");
            stmt.close();

        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection failed!");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error during database connection.");
            e.printStackTrace();
        }
        return conn;
    }
}

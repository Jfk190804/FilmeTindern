import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
        private static final String DB_URL = "jdbc:mysql://localhost:3306/Filme_Tindern";
        private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "root1234";
        private static Connection connection = null;

        public Connection connect() throws Exception {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }

        public static Connection getConnection() {
                if (connection == null) {
                        try {
                                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                                System.out.println("Verbindung erfolgreich hergestellt!");
                        } catch (SQLException e) {
                                e.printStackTrace();
                                System.out.println("Verbindung fehlgeschlagen.");
                        }
                }
                return connection;
        }

        // Verbindung auflösen
        public static void closeConnection() {
                if (connection != null) {
                        try {
                                connection.close();
                                System.out.println("Verbindung erfolgreich geschlossen!");
                        } catch (SQLException e) {
                                e.printStackTrace();
                                System.out.println("Fehler beim Schließen der Verbindung.");
                        } finally {
                                connection = null;  // Verbindung auf null setzen
                        }
                }
        }
}

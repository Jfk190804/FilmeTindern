import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBOperations {
    public static void insertMovie(String title, String genre, String releaseDate, int runtime,
                                   String language, String director, double rating, long budget, String country) {
        String sql = "INSERT INTO Filme_Tindern.Movies (Title, Genre, ReleaseDate, Runtime, Language, Director, Rating, Budget, Country) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the values for the PreparedStatement
            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setDate(3, java.sql.Date.valueOf(releaseDate)); // Ensure releaseDate is in the format YYYY-MM-DD
            pstmt.setInt(4, runtime);
            pstmt.setString(5, language);
            pstmt.setString(6, director);
            pstmt.setDouble(7, rating);
            pstmt.setLong(8, budget);
            pstmt.setString(9, country);

            // Execute the update
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Ein Film wurde erfolgreich hinzugefügt.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fehler beim Einfügen des Films.");
        }
    }

}
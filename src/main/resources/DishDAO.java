import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDAO {
    // Thêm món ăn mới vào cơ sở dữ liệu
    public void addDish(String name, double price) {
        String query = "INSERT INTO Dish (name, price) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy danh sách món ăn từ cơ sở dữ liệu
    public List<Dish> getAllDishes() {
        List<Dish> dishes = new ArrayList<>();
        String query = "SELECT * FROM Dish";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                dishes.add(new Dish(id, name, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dishes;
    }

    // Xóa món ăn
    public void deleteDish(int id) {
        String query = "DELETE FROM Dish WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

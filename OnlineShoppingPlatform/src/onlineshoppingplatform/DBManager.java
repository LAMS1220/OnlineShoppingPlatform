package onlineshoppingplatform;

import java.sql.*;

public class DBManager {
    private Connection conn;
    private static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
    private static final String USER = "username"; 
    private static final String PASSWORD = "password"; 

    public DBManager() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void registerAdmin(String username, String password) throws SQLException {
        String sql = "INSERT INTO admins(username, password) VALUES(?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        }
    }

    public boolean loginAdmin(String username, String password) throws SQLException {
        String sql = "SELECT * FROM admins WHERE username = ? AND password = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        }
    }

    public void addItemToCart(String name, String description, double price) throws SQLException {
        String query = "INSERT INTO cart (item, description, price, quantity) VALUES (?, ?, ?, 1)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, description);
            statement.setDouble(3, price);
            statement.executeUpdate();
        }
    }

    public void updateCartItem(int itemId, int quantity) throws SQLException {
        String sql = "UPDATE cart SET quantity = ? WHERE item_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, itemId);
            pstmt.executeUpdate();
        }
    }

    public void deleteCartItem(int itemId) throws SQLException {
        String sql = "DELETE FROM cart WHERE item_id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, itemId);
            pstmt.executeUpdate();
        }
    }

    public ResultSet getCartItems() throws SQLException {
        String sql = "SELECT * FROM cart";

        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void addPayment(String name, String address, String contact, double amount, String paymentMethod) throws SQLException {
        String query = "INSERT INTO payments (name, address, contact, amount, payment_method) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, contact);
            statement.setDouble(4, amount);
            statement.setString(5, paymentMethod);
            statement.executeUpdate();
        }
    }

    public ResultSet getAllItems() throws SQLException {
        String sql = "SELECT * FROM items";

        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }
}

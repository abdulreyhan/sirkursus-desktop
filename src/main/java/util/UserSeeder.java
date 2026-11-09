package util;

import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public final class UserSeeder {

    /** Membuat akun demo jika belum ada. Aman dipanggil berulang kali. */
    public static void ensureDemoUsers() throws SQLException {
        seedIfMissing("admin", "Admin@123", "ADMIN");
        seedIfMissing("operator", "Operator@123", "OPERATOR");
    }

    private static void seedIfMissing(String username, String password, String role)
        throws SQLException {
    try (Connection conn = Database.getConnection();
         PreparedStatement ps = conn.prepareStatement(
                 "SELECT password_hash, aktif FROM users WHERE username=?")) {
        ps.setString(1, username);
        try (java.sql.ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                boolean ok = rs.getBoolean("aktif")
                        && PasswordUtil.verify(password.toCharArray(),
                                rs.getString("password_hash"));
                if (!ok) {
                    try (PreparedStatement up = conn.prepareStatement(
                            "UPDATE users SET password_hash=?, role=?, aktif=1 WHERE username=?")) {
                        up.setString(1, PasswordUtil.hash(password.toCharArray()));
                        up.setString(2, role);
                        up.setString(3, username);
                        up.executeUpdate();
                    }
                }
                return;
            }
        }
    }
    seed(username, password.toCharArray(), role);
}

    private UserSeeder() {}

    public static void main(String[] args) {
        try {
            seed("admin", "Admin@123".toCharArray(), "ADMIN");
            seed("operator", "Operator@123".toCharArray(), "OPERATOR");
            System.out.println("User demo siap. Jalankan aplikasi lalu login.");
        } catch (SQLException ex) {
            System.err.println("Gagal membuat user demo: " + ex.getMessage());
        }
    }

    private static void seed(String username, char[] password, String role)
            throws SQLException {
        String sql = "INSERT IGNORE INTO users"
                + "(username,password_hash,role,aktif) VALUES (?,?,?,1)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, PasswordUtil.hash(password));
            ps.setString(3, role);
            ps.executeUpdate();
        } finally {
            Arrays.fill(password, '\0');
        }
    }
}

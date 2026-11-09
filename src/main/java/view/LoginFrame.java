package view;

import dao.UserDAO;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import model.User;
import util.UserSession;

public class LoginFrame extends JFrame {
    private final UserDAO userDAO = new UserDAO();

    private JTextField txtUsername;
    private JPasswordField pwdPassword;
    private JCheckBox chkShowPass;
    private JButton btnLogin;
    private JButton btnKeluar;
    private char defaultEchoChar;

    // Palet Warna Modern (Warm Sunset & Vibrant Orange Theme)
    private final Color primaryDark = new Color(194, 65, 12);   // Oranye Tua / Terracotta (Gradient atas)
    private final Color primaryLight = new Color(249, 115, 22); // Oranye Cerah (Gradient bawah & aksen)
    private final Color primaryHover = new Color(234, 88, 12);  // Oranye Hover
    private final Color dangerColor = new Color(220, 38, 38);   // Merah Tegas (Saat tombol keluar di-hover)
    private final Color textDark = new Color(28, 25, 23);       // Hitam Hangat / Charcoal (Judul)
    private final Color textMuted = new Color(120, 113, 108);   // Abu-abu Hangat (Subjudul & Label)
    private final Color inputBg = new Color(255, 251, 235);     // Background Textfield (Krem sangat muda/hangat)
    private final Color borderIdle = new Color(231, 229, 228);  // Warna garis saat tidak fokus

    public LoginFrame() {
        initComponents();
        setSize(850, 520);
        setMinimumSize(new Dimension(750, 480));
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnLogin);
    }

    private void initComponents() {
        setTitle("Login - SIKURSUS Desktop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel Utama menggunakan GridLayout 1 Baris 2 Kolom (Kiri: Branding, Kanan: Form)
        JPanel mainPanel = new JPanel(new GridLayout(1, 2));

        // ==========================================
        // 1. PANEL KIRI (BRANDING & GRADIENT ORANYE)
        // ==========================================
        JPanel leftPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Background Gradient Oranye
                GradientPaint gp = new GradientPaint(0, 0, primaryDark, getWidth(), getHeight(), primaryLight);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Ornamen Lingkaran Transparan agar lebih estetis
                g2d.setColor(new Color(255, 255, 255, 22));
                g2d.fill(new Ellipse2D.Double(-80, -80, 260, 260));
                g2d.fill(new Ellipse2D.Double(getWidth() - 140, getHeight() - 140, 280, 280));
                g2d.setColor(new Color(255, 255, 255, 12));
                g2d.fill(new Ellipse2D.Double(getWidth() / 2.0 - 100, getHeight() / 2.0 - 100, 200, 200));

                g2d.dispose();
            }
        };

        GridBagConstraints lc = new GridBagConstraints();
        lc.gridx = 0;
        lc.gridy = 1;
        lc.insets = new Insets(15, 25, 5, 25);
        lc.anchor = GridBagConstraints.CENTER;

        JLabel lblBrandTitle = new JLabel("SIKURSUS-DESKTOP", SwingConstants.CENTER);
        lblBrandTitle.setFont(new Font("Segoe UI", Font.BOLD, 30));
        lblBrandTitle.setForeground(Color.WHITE);
        leftPanel.add(lblBrandTitle, lc);

        lc.gridy = 2;
        lc.insets = new Insets(0, 30, 15, 30);
        JLabel lblBrandSub = new JLabel(
                "<html><div style='text-align: center; line-height: 1.4;'>"
                + ""
                + "</div></html>", SwingConstants.CENTER);
        lblBrandSub.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblBrandSub.setForeground(new Color(255, 237, 213));
        leftPanel.add(lblBrandSub, lc);

        // ==========================================
        // 2. PANEL KANAN (FORM LOGIN)
        // ==========================================
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);

        JPanel formContainer = new JPanel(new GridBagLayout());
        formContainer.setBackground(Color.WHITE);
        GridBagConstraints fc = new GridBagConstraints();
        fc.fill = GridBagConstraints.HORIZONTAL;
        fc.gridx = 0;
        fc.weightx = 1.0;

        // Header Form
        JLabel lblWelcome = new JLabel("Selamat Datang Kembali");
        lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblWelcome.setForeground(textDark);
        fc.gridy = 0;
        fc.insets = new Insets(0, 0, 4, 0);
        formContainer.add(lblWelcome, fc);

        JLabel lblInstruction = new JLabel("Silakan masuk ke akun Anda untuk melanjutkan");
        lblInstruction.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblInstruction.setForeground(textMuted);
        fc.gridy = 1;
        fc.insets = new Insets(0, 0, 25, 0);
        formContainer.add(lblInstruction, fc);

        // Input Username
        JLabel lblUser = new JLabel("Username");
        lblUser.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblUser.setForeground(textDark);
        fc.gridy = 2;
        fc.insets = new Insets(0, 0, 6, 0);
        formContainer.add(lblUser, fc);

        txtUsername = new JTextField(20);
        JPanel userWrapper = createInputWrapper(txtUsername);
        fc.gridy = 3;
        fc.insets = new Insets(0, 0, 16, 0);
        formContainer.add(userWrapper, fc);

        // Input Password
        JLabel lblPass = new JLabel("Password");
        lblPass.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblPass.setForeground(textDark);
        fc.gridy = 4;
        fc.insets = new Insets(0, 0, 6, 0);
        formContainer.add(lblPass, fc);

        pwdPassword = new JPasswordField(20);
        defaultEchoChar = pwdPassword.getEchoChar();
        JPanel passWrapper = createInputWrapper(pwdPassword);
        fc.gridy = 5;
        fc.insets = new Insets(0, 0, 8, 0);
        formContainer.add(passWrapper, fc);

        // Checkbox Tampilkan Password
        chkShowPass = new JCheckBox("Tampilkan Password");
        chkShowPass.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        chkShowPass.setForeground(textMuted);
        chkShowPass.setBackground(Color.WHITE);
        chkShowPass.setFocusPainted(false);
        chkShowPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        chkShowPass.addActionListener(e -> {
            if (chkShowPass.isSelected()) {
                pwdPassword.setEchoChar((char) 0);
            } else {
                pwdPassword.setEchoChar(defaultEchoChar);
            }
        });
        fc.gridy = 6;
        fc.insets = new Insets(0, 0, 22, 0);
        formContainer.add(chkShowPass, fc);

        // Tombol Login (Oranye Solid) & Keluar (Abu-abu netral -> Merah saat di-hover)
        btnLogin = createModernButton("MASUK KE AKUN", primaryLight, primaryHover, Color.WHITE);
        fc.gridy = 7;
        fc.insets = new Insets(0, 0, 10, 0);
        formContainer.add(btnLogin, fc);

        btnKeluar = createModernButton("KELUAR APLIKASI", new Color(245, 245, 244), dangerColor, textMuted);
        fc.gridy = 8;
        fc.insets = new Insets(0, 0, 0, 0);
        formContainer.add(btnKeluar, fc);

        // Event Listeners
        btnLogin.addActionListener(this::btnLoginActionPerformed);
        btnKeluar.addActionListener(this::btnKeluarActionPerformed);

        // Masukkan formContainer ke rightPanel dengan margin proporsional
        GridBagConstraints rc = new GridBagConstraints();
        rc.fill = GridBagConstraints.HORIZONTAL;
        rc.weightx = 1.0;
        rc.insets = new Insets(20, 45, 20, 45);
        rightPanel.add(formContainer, rc);

        // Gabungkan Kiri & Kanan
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);
        setContentPane(mainPanel);
    }

    /**
     * Membungkus JTextField/JPasswordField ke dalam panel bersudut membulat (Rounded)
     * yang otomatis berubah warna garis tepinya menjadi Oranye ketika sedang diketik.
     */
    private JPanel createInputWrapper(JComponent field) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setForeground(textDark);
        field.setOpaque(false);
        field.setBorder(new EmptyBorder(10, 14, 10, 14));

        JPanel wrapper = new JPanel(new BorderLayout()) {
            private boolean isFocused = false;

            {
                field.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        isFocused = true;
                        repaint();
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        isFocused = false;
                        repaint();
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Warna Latar Input
                g2.setColor(isFocused ? Color.WHITE : inputBg);
                g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);

                // Warna Garis Tepi (Oranye tebal saat aktif, abu-abu tipis saat diam)
                if (isFocused) {
                    g2.setColor(primaryLight);
                    g2.setStroke(new BasicStroke(1.8f));
                } else {
                    g2.setColor(borderIdle);
                    g2.setStroke(new BasicStroke(1f));
                }
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        wrapper.setOpaque(false);
        wrapper.add(field, BorderLayout.CENTER);
        return wrapper;
    }

    /**
     * Membuat tombol custom bersudut membulat dengan transisi warna Hover.
     */
    private JButton createModernButton(String text, Color bgNormal, Color bgHover, Color textColorNormal) {
        JButton btn = new JButton(text) {
            private boolean isHovered = false;

            {
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (isEnabled()) {
                            isHovered = true;
                            setForeground(Color.WHITE);
                            repaint();
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        isHovered = false;
                        setForeground(textColorNormal);
                        repaint();
                    }
                });
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (!isEnabled()) {
                    g2.setColor(new Color(214, 211, 209));
                } else if (isHovered) {
                    g2.setColor(bgHover);
                } else {
                    g2.setColor(bgNormal);
                }

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                g2.dispose();
                super.paintComponent(g);
            }
        };

        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setForeground(textColorNormal);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setBorder(new EmptyBorder(12, 15, 12, 15));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        String username = txtUsername.getText().trim();
        char[] password = pwdPassword.getPassword();

        if (username.isEmpty() || password.length == 0) {
            JOptionPane.showMessageDialog(this,
                    "Username dan password wajib diisi.",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
            if (username.isEmpty()) {
                txtUsername.requestFocus();
            } else {
                pwdPassword.requestFocus();
            }
            return;
        }

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        btnLogin.setEnabled(false);
        btnLogin.setText("MEMPROSES...");

        new Thread(() -> {
            try {
                User user = userDAO.authenticate(username, password);
                SwingUtilities.invokeLater(() -> {
                    if (user == null) {
                        JOptionPane.showMessageDialog(this,
                                "Login gagal. Periksa username, password, atau status user.",
                                "Login Gagal", JOptionPane.ERROR_MESSAGE);
                        pwdPassword.setText("");
                        pwdPassword.requestFocus();
                    } else {
                        UserSession.setCurrentUser(user);
                        dispose();
                        new DashboardFrame().setVisible(true);
                    }
                });
            } catch (SQLException ex) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this,
                            "Tidak dapat mengakses database: " + ex.getMessage(),
                            "Database Error", JOptionPane.ERROR_MESSAGE);
                });
            } finally {
                Arrays.fill(password, '\0');
                SwingUtilities.invokeLater(() -> {
                    btnLogin.setEnabled(true);
                    btnLogin.setText("MASUK KE AKUN");
                    setCursor(Cursor.getDefaultCursor());
                });
            }
        }).start();
    }

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
}
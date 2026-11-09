package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import model.User;
import util.UserSession;
import util.WindowManager;

public class DashboardFrame extends JFrame {
    private JLabel lblUser;
    private JLabel lblRole;
    private JLabel lblWelcomeBanner;
    private JLabel lblSection;
    private JPanel panelDashboard;
    private JPopupMenu popupDashboard;

    private JMenu menuMaster, menuTransaksi, menuLaporan, menuKeluar;
    private JMenuItem miPeserta, miInstruktur, miKursus, miKelas;
    private JMenuItem miPendaftaran, miPembayaran;
    private JMenuItem miLaporanPeserta, miLaporanPendaftaran;
    private JMenuItem miLogout, miTutup;
    private JMenuItem miTentang, miRefresh;

    // Kartu Pintasan Cepat (ikut diatur hak aksesnya di applySession)
    private JPanel cardPeserta, cardInstruktur, cardKursus, cardKelas, cardPendaftaran, cardPembayaran;

    // Palet Warna Tema Oranye Modern (Serasi dengan LoginFrame)
    private final Color primaryDark = new Color(194, 65, 12);    // Oranye Tua / Terracotta
    private final Color primaryLight = new Color(249, 115, 22);  // Oranye Cerah
    private final Color bgMain = new Color(250, 250, 249);       // Abu-abu Hangat Terang (Background)
    private final Color textDark = new Color(28, 25, 23);        // Hitam Charcoal
    private final Color textMuted = new Color(120, 113, 108);    // Abu-abu Teks
    private final Color borderIdle = new Color(231, 229, 228);   // Garis Tepi Kartu
    private final Color badgeBg = new Color(255, 237, 213);     // Latar Badge Oranye Muda

    public DashboardFrame() {
        initComponents();
        setLocationRelativeTo(null);
        miPeserta.setIcon(loadIcon("/icons/peserta.png"));
        miInstruktur.setIcon(loadIcon("/icons/instruktur.png"));
        miKursus.setIcon(loadIcon("/icons/kursus.png"));
        miKelas.setIcon(loadIcon("/icons/kelas.png"));
        applySession();
    }

    private void initComponents() {
        setTitle("Dashboard - SIKURSUS DESKTOP");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(960, 640);
        setMinimumSize(new Dimension(850, 560));

        // ==========================================
        // 1. MENU BAR MODERN
        // ==========================================
        JMenuBar bar = new JMenuBar();
        bar.setBackground(Color.WHITE);
        bar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, borderIdle));
        bar.setPreferredSize(new Dimension(800, 36));

        menuMaster = createStyledMenu("Master Data");
        miPeserta = createStyledMenuItem("Data Peserta");
        miInstruktur = createStyledMenuItem("Data Instruktur");
        miKursus = createStyledMenuItem("Data Kursus");
        miKelas = createStyledMenuItem("Data Kelas");
        menuMaster.add(miPeserta);
        menuMaster.add(miInstruktur);
        menuMaster.add(miKursus);
        menuMaster.add(miKelas);

        menuTransaksi = createStyledMenu("Transaksi");
        miPendaftaran = createStyledMenuItem("Pendaftaran Kursus");
        miPembayaran = createStyledMenuItem("Pembayaran");
        menuTransaksi.add(miPendaftaran);
        menuTransaksi.add(miPembayaran);

        menuLaporan = createStyledMenu("Laporan");
        miLaporanPeserta = createStyledMenuItem("Laporan Peserta");
        miLaporanPendaftaran = createStyledMenuItem("Laporan Pendaftaran");
        menuLaporan.add(miLaporanPeserta);
        menuLaporan.add(miLaporanPendaftaran);

        menuKeluar = createStyledMenu("Sistem");
        miLogout = createStyledMenuItem("Logout Akun");
        miTutup = createStyledMenuItem("Tutup Aplikasi");
        menuKeluar.add(miLogout);
        menuKeluar.addSeparator();
        menuKeluar.add(miTutup);

        bar.add(menuMaster);
        bar.add(menuTransaksi);
        bar.add(menuLaporan);
        bar.add(menuKeluar);
        setJMenuBar(bar);

        // ==========================================
        // 2. HEADER ATAS (TOP BAR)
        // ==========================================
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        header.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, borderIdle),
                new EmptyBorder(12, 28, 12, 28)
        ));

        // Brand di Kiri
        JPanel brandPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        brandPanel.setOpaque(false);

        JLabel lblDot = new JLabel("●");
        lblDot.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblDot.setForeground(primaryLight);

        JLabel lblTitle = new JLabel("SIKURSUS DESKTOP");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(textDark);

        JLabel lblSubBrand = new JLabel("");
        lblSubBrand.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblSubBrand.setForeground(textMuted);

        brandPanel.add(lblDot);
        brandPanel.add(lblTitle);
        brandPanel.add(lblSubBrand);

        // Info User, Badge Role & Tombol Logout Cepat di Kanan
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        infoPanel.setOpaque(false);

        lblUser = new JLabel("-");
        lblUser.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblUser.setForeground(textDark);

        lblRole = new JLabel("-");
        lblRole.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblRole.setForeground(primaryDark);
        lblRole.setOpaque(true);
        lblRole.setBackground(badgeBg);
        lblRole.setBorder(new EmptyBorder(4, 10, 4, 10));

        JButton btnQuickLogout = new JButton("Logout");
        btnQuickLogout.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnQuickLogout.setForeground(new Color(220, 38, 38));
        btnQuickLogout.setBackground(new Color(254, 242, 242));
        btnQuickLogout.setFocusPainted(false);
        btnQuickLogout.setBorderPainted(false);
        btnQuickLogout.setBorder(new EmptyBorder(6, 14, 6, 14));
        btnQuickLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnQuickLogout.addActionListener(this::miLogoutActionPerformed);

        JLabel lblUserTitle = new JLabel("User:");
        lblUserTitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblUserTitle.setForeground(textMuted);

        infoPanel.add(lblUserTitle);
        infoPanel.add(lblUser);
        infoPanel.add(lblRole);
        infoPanel.add(btnQuickLogout);

        header.add(brandPanel, BorderLayout.WEST);
        header.add(infoPanel, BorderLayout.EAST);

        // ==========================================
        // 3. AREA TENGAH (PANEL DASHBOARD)
        // ==========================================
        panelDashboard = new JPanel(new BorderLayout(0, 22));
        panelDashboard.setBackground(bgMain);
        panelDashboard.setBorder(new EmptyBorder(24, 28, 24, 28));

        // 3A. Banner Sambutan Bergradasi Oranye
        JPanel bannerPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                GradientPaint gp = new GradientPaint(0, 0, primaryDark, getWidth(), getHeight(), primaryLight);
                g2.setPaint(gp);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 18, 18);

                // Siluet Lingkaran Dekoratif
                g2.setColor(new Color(255, 255, 255, 22));
                g2.fill(new Ellipse2D.Double(getWidth() - 180, -50, 240, 240));
                g2.fill(new Ellipse2D.Double(getWidth() - 90, 40, 160, 160));

                g2.dispose();
                super.paintComponent(g);
            }
        };
        bannerPanel.setOpaque(false);
        bannerPanel.setBorder(new EmptyBorder(26, 30, 26, 30));

        GridBagConstraints bc = new GridBagConstraints();
        bc.gridx = 0;
        bc.gridy = 0;
        bc.weightx = 1.0;
        bc.fill = GridBagConstraints.HORIZONTAL;

        lblWelcomeBanner = new JLabel("Selamat Datang di SIKURSUS Desktop!");
        lblWelcomeBanner.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblWelcomeBanner.setForeground(Color.WHITE);
        bannerPanel.add(lblWelcomeBanner, bc);

        bc.gridy = 1;
        bc.insets = new Insets(6, 0, 0, 0);
        JLabel lblBannerSub = new JLabel("Kelola data peserta, instruktur, kursus, jadwal kelas, dan transaksi pelatihan melalui satu panel terpadu.");
        lblBannerSub.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblBannerSub.setForeground(new Color(255, 237, 213));
        bannerPanel.add(lblBannerSub, bc);

        // 3B. Grid Kartu Menu Cepat (Quick Access)
        JPanel centerContent = new JPanel(new BorderLayout(0, 12));
        centerContent.setOpaque(false);

        lblSection = new JLabel("Akses Cepat Modul");
        lblSection.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblSection.setForeground(textDark);
        centerContent.add(lblSection, BorderLayout.NORTH);

        JPanel gridCards = new JPanel(new GridLayout(2, 3, 18, 18));
        gridCards.setOpaque(false);

        cardPeserta = createModuleCard("Data Peserta", "Kelola biodata & riwayat peserta", "PESERTA",
                new Color(249, 115, 22), () -> miPeserta.doClick());
        cardInstruktur = createModuleCard("Data Instruktur", "Manajemen pengajar & keahlian", "INSTRUKTUR",
                new Color(234, 88, 12), () -> miInstruktur.doClick());
        cardKursus = createModuleCard("Program Kursus", "Daftar materi, kurikulum & biaya", "KURSUS",
                new Color(217, 119, 6), () -> miKursus.doClick());
        cardKelas = createModuleCard("Jadwal Kelas", "Atur ruang, kuota & jadwal", "KELAS",
                new Color(194, 65, 12), () -> miKelas.doClick());
        cardPendaftaran = createModuleCard("Pendaftaran", "Registrasi peserta ke kelas baru", "TRANSAKSI",
                new Color(16, 185, 129), () -> miPendaftaran.doClick());
        cardPembayaran = createModuleCard("Pembayaran", "Verifikasi tagihan & bukti bayar", "KEUANGAN",
                new Color(59, 130, 246), () -> miPembayaran.doClick());

        gridCards.add(cardPeserta);
        gridCards.add(cardInstruktur);
        gridCards.add(cardKursus);
        gridCards.add(cardKelas);
        gridCards.add(cardPendaftaran);
        gridCards.add(cardPembayaran);

        centerContent.add(gridCards, BorderLayout.CENTER);

        // 3C. Footer Petunjuk Klik Kanan
        JLabel lblFooter = new JLabel("Tips: Klik kartu di atas untuk membuka modul, atau klik kanan di area kosong untuk menu pintasan.", SwingConstants.LEFT);
        lblFooter.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblFooter.setForeground(textMuted);

        panelDashboard.add(bannerPanel, BorderLayout.NORTH);
        panelDashboard.add(centerContent, BorderLayout.CENTER);
        panelDashboard.add(lblFooter, BorderLayout.SOUTH);

        // ==========================================
        // 4. POPUP MENU (KLIK KANAN)
        // ==========================================
        popupDashboard = new JPopupMenu();
        miTentang = new JMenuItem("Tentang Aplikasi");
        miRefresh = new JMenuItem("Refresh Dashboard");
        miTentang.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        miRefresh.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        popupDashboard.add(miTentang);
        popupDashboard.add(miRefresh);
        panelDashboard.setComponentPopupMenu(popupDashboard);

        add(header, BorderLayout.NORTH);
        add(panelDashboard, BorderLayout.CENTER);

        // ==========================================
        // 5. ACTION LISTENERS (TETAP SAMA)
        // ==========================================
        miPeserta.addActionListener(e -> WindowManager.open(PesertaFrame.class, PesertaFrame::new));
        miInstruktur.addActionListener(e -> WindowManager.open(InstrukturFrame.class, InstrukturFrame::new));
        miKursus.addActionListener(e -> WindowManager.open(KursusFrame.class, KursusFrame::new));
        miKelas.addActionListener(e -> WindowManager.open(KelasFrame.class, KelasFrame::new));

        miPendaftaran.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Modul Pendaftaran sedang dikembangkan pada tahap project berikutnya."));
        miPembayaran.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Modul Pembayaran sedang dikembangkan pada tahap project berikutnya."));
        miLaporanPeserta.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Modul laporan diaktifkan pada Pertemuan 12 dengan Jaspersoft Studio."));
        miLaporanPendaftaran.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Modul laporan diaktifkan pada Pertemuan 12 dengan Jaspersoft Studio."));

        miLogout.addActionListener(this::miLogoutActionPerformed);
        miTutup.addActionListener(this::miTutupActionPerformed);
        miTentang.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "SIKURSUS Desktop\nProject PBO - Program Studi Informatika"));
        miRefresh.addActionListener(e -> {
            applySession();
            panelDashboard.repaint();
        });
    }

    private JMenu createStyledMenu(String text) {
        JMenu menu = new JMenu(text);
        menu.setFont(new Font("Segoe UI", Font.BOLD, 13));
        menu.setForeground(textDark);
        menu.setBorder(new EmptyBorder(4, 10, 4, 10));
        return menu;
    }

    private JMenuItem createStyledMenuItem(String text) {
        JMenuItem item = new JMenuItem(text);
        item.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        item.setForeground(textDark);
        item.setBackground(Color.WHITE);
        item.setBorder(new EmptyBorder(6, 12, 6, 16));
        item.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return item;
    }

    /**
     * Membuat kartu modul interaktif tanpa garis aksen kiri.
     */
    private JPanel createModuleCard(String title, String subtitle, String tag, Color accentColor, Runnable onClick) {
        JLabel lblTag = new JLabel(tag);
        JLabel lblArrow = new JLabel("→");
        JLabel lblCardTitle = new JLabel(title);
        JLabel lblCardSub = new JLabel(subtitle);

        JPanel card = new JPanel(new BorderLayout(0, 8)) {
            private boolean isHovered = false;

            {
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (isEnabled()) {
                            isHovered = true;
                            repaint();
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        isHovered = false;
                        repaint();
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            if (isEnabled()) {
                                onClick.run();
                            } else {
                                JOptionPane.showMessageDialog(DashboardFrame.this,
                                        "Akses Ditolak!\nModul \"" + title + "\" hanya dapat diakses oleh role ADMIN.",
                                        "Akses Terbatas (Role OPERATOR)",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        }
                    }
                });
            }

            @Override
            public void setEnabled(boolean enabled) {
                super.setEnabled(enabled);
                if (enabled) {
                    lblTag.setText(tag);
                    lblTag.setForeground(accentColor);
                    lblTag.setBackground(new Color(accentColor.getRed(), accentColor.getGreen(), accentColor.getBlue(), 25));

                    lblArrow.setText("→");
                    lblArrow.setFont(new Font("Segoe UI", Font.BOLD, 16));
                    lblArrow.setForeground(textMuted);
                    lblArrow.setOpaque(false);
                    lblArrow.setBorder(null);

                    lblCardTitle.setForeground(textDark);
                    lblCardSub.setText(subtitle);
                    lblCardSub.setForeground(textMuted);
                } else {
                    lblTag.setText(tag);
                    lblTag.setForeground(new Color(168, 162, 158));
                    lblTag.setBackground(new Color(231, 229, 228));

                    lblArrow.setText("TERKUNCI (ADMIN)");
                    lblArrow.setFont(new Font("Segoe UI", Font.BOLD, 10));
                    lblArrow.setForeground(new Color(185, 28, 28));
                    lblArrow.setOpaque(true);
                    lblArrow.setBackground(new Color(254, 226, 226));
                    lblArrow.setBorder(new EmptyBorder(2, 7, 2, 7));

                    lblCardTitle.setForeground(new Color(168, 162, 158));
                    lblCardSub.setText("Khusus hak akses Administrator");
                    lblCardSub.setForeground(new Color(180, 175, 170));
                }
                repaint();
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Background Kartu
                if (!isEnabled()) {
                    g2.setColor(new Color(240, 239, 237));
                } else {
                    g2.setColor(Color.WHITE);
                }
                g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 14, 14);

                // Garis Tepi (Putus-putus saat terkunci, menyala saat aktif & di-hover)
                if (isHovered && isEnabled()) {
                    g2.setColor(accentColor);
                    g2.setStroke(new BasicStroke(1.8f));
                } else if (!isEnabled()) {
                    g2.setColor(new Color(214, 211, 209));
                    g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f, new float[]{4f, 4f}, 0f));
                } else {
                    g2.setColor(borderIdle);
                    g2.setStroke(new BasicStroke(1f));
                }
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 14, 14);

                g2.dispose();
                super.paintComponent(g);
            }
        };

        card.setOpaque(false);
        card.setBorder(new EmptyBorder(16, 18, 16, 18));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Bagian Atas Kartu: Tag Kategori & Indikator Akses
        JPanel topRow = new JPanel(new BorderLayout());
        topRow.setOpaque(false);

        lblTag.setFont(new Font("Segoe UI", Font.BOLD, 10));
        lblTag.setForeground(accentColor);
        lblTag.setOpaque(true);
        lblTag.setBackground(new Color(accentColor.getRed(), accentColor.getGreen(), accentColor.getBlue(), 25));
        lblTag.setBorder(new EmptyBorder(3, 8, 3, 8));

        lblArrow.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblArrow.setForeground(textMuted);

        topRow.add(lblTag, BorderLayout.WEST);
        topRow.add(lblArrow, BorderLayout.EAST);

        // Bagian Tengah & Bawah Kartu: Judul & Deskripsi
        JPanel textPanel = new JPanel(new GridLayout(2, 1, 0, 2));
        textPanel.setOpaque(false);

        lblCardTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblCardTitle.setForeground(textDark);

        lblCardSub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblCardSub.setForeground(textMuted);

        textPanel.add(lblCardTitle);
        textPanel.add(lblCardSub);

        card.add(topRow, BorderLayout.NORTH);
        card.add(textPanel, BorderLayout.CENTER);

        return card;
    }

    private void setCardAccess(JPanel card, boolean enabled) {
        if (card != null) {
            card.setEnabled(enabled);
            card.setCursor(new Cursor(enabled ? Cursor.HAND_CURSOR : Cursor.DEFAULT_CURSOR));
            card.setToolTipText(enabled ? "Klik untuk membuka modul" : "Akses dibatasi (Khusus Administrator)");
        }
    }

    private ImageIcon loadIcon(String path) {
        URL url = getClass().getResource(path);
        return url == null ? null : new ImageIcon(url);
    }

    private void applySession() {
        User user = UserSession.getCurrentUser();
        if (user == null) {
            JOptionPane.showMessageDialog(this, "Session tidak ditemukan. Silakan login ulang.");
            dispose();
            SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
            return;
        }
        lblUser.setText(user.getUsername());
        lblRole.setText(user.getRole().toUpperCase());
        lblWelcomeBanner.setText("Selamat Datang, " + user.getUsername() + "!");

        boolean admin = user.isAdmin();
        lblSection.setText(admin
                ? "Akses Cepat Modul (Mode Administrator - Akses Penuh)"
                : "Akses Cepat Modul (Mode Operator - Akses Terbatas)");

        miInstruktur.setEnabled(admin);
        miKursus.setEnabled(admin);
        miKelas.setEnabled(admin);
        miPeserta.setEnabled(true);
        menuTransaksi.setEnabled(true);
        menuLaporan.setEnabled(true);

        // Sinkronkan hak akses ke Kartu Pintasan
        setCardAccess(cardInstruktur, admin);
        setCardAccess(cardKursus, admin);
        setCardAccess(cardKelas, admin);
        setCardAccess(cardPeserta, true);
    }

    private void miLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        int pilihan = JOptionPane.showConfirmDialog(this,
                "Logout dari aplikasi?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (pilihan == JOptionPane.YES_OPTION) {
            WindowManager.closeAll();
            UserSession.clear();
            dispose();
            SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
        }
    }

    private void miTutupActionPerformed(java.awt.event.ActionEvent evt) {
        int pilihan = JOptionPane.showConfirmDialog(this,
                "Tutup aplikasi SIKURSUS?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (pilihan == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
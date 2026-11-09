package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/** Kerangka sementara. Ganti dengan CRUD (DAO + JTable) seperti PesertaFrame. */
public class KelasFrame extends JFrame {
    public KelasFrame() {
        setTitle("Master Kelas");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        add(new JLabel("Master Kelas", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
}

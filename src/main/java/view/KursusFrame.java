package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/** Kerangka sementara. Ganti dengan CRUD (DAO + JTable) seperti PesertaFrame. */
public class KursusFrame extends JFrame {
    public KursusFrame() {
        setTitle("Master Kursus");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        add(new JLabel("Master Kursus", SwingConstants.CENTER), BorderLayout.CENTER);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
}

package report;

import config.Database;
import java.awt.Component;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Membuka laporan Jasper dari resource project.
 * Urutan: pakai /report/laporan_peserta.jasper bila ada dan cocok;
 * jika tidak ada, laporan dikompilasi langsung dari .jrxml.
 */
public final class ReportService {

    private static final String JASPER = "/report/laporan_peserta.jasper";
    private static final String JRXML = "/report/laporan_peserta.jrxml";

    private ReportService() {}

    public static void tampilkanLaporanPeserta() {
        tampilkanLaporanPeserta(null);
    }

    public static void tampilkanLaporanPeserta(final Component parent) {
        new SwingWorker<JasperPrint, Void>() {
            @Override
            protected JasperPrint doInBackground() throws Exception {
                return buatLaporanPeserta();
            }

            @Override
            protected void done() {
                try {
                    JasperPrint print = get();
                    JasperViewer.viewReport(print, false); // false = jangan matikan aplikasi
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                } catch (ExecutionException ex) {
                    Throwable sebab = ex.getCause() != null ? ex.getCause() : ex;
                    sebab.printStackTrace();
                    JOptionPane.showMessageDialog(parent,
                            "Gagal membuka laporan: " + sebab.getMessage(),
                            "Laporan Peserta", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    public static JasperPrint buatLaporanPeserta() throws Exception {
        JasperReport report = muatReport();
        Map<String, Object> params = new HashMap<String, Object>();
        try (Connection conn = Database.getConnection()) {
            return JasperFillManager.fillReport(report, params, conn);
        }
    }

    private static JasperReport muatReport() throws JRException {
        // 1) coba file .jasper hasil compile Jaspersoft Studio
        try (InputStream in = ReportService.class.getResourceAsStream(JASPER)) {
            if (in != null) {
                return (JasperReport) JRLoader.loadObject(in);
            }
        } catch (IOException | JRException | RuntimeException ex) {
            System.err.println("File .jasper tidak dapat dipakai, memakai .jrxml: "
                    + ex.getMessage());
        }
        // 2) cadangan: kompilasi .jrxml saat runtime
        try (InputStream in = ReportService.class.getResourceAsStream(JRXML)) {
            if (in == null) {
                throw new IllegalStateException(
                        "File laporan_peserta.jasper/.jrxml tidak ditemukan di "
                        + "src/main/resources/report/.");
            }
            return JasperCompileManager.compileReport(in);
        } catch (IOException ex) {
            throw new IllegalStateException("Gagal membaca laporan: " + ex.getMessage(), ex);
        }
    }
}

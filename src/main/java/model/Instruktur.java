package model;

<<<<<<< HEAD
public class Instruktur extends Orang {
    private String keahlian;

    public Instruktur(int id, String nama, String noHp, String keahlian) {
        super(id, nama, noHp);
        setKeahlian(keahlian);
    }

    public String getKeahlian() { return keahlian; }

    public void setKeahlian(String keahlian) {
        if (keahlian == null || keahlian.trim().isEmpty())
            throw new IllegalArgumentException("Keahlian wajib diisi");
        this.keahlian = keahlian.trim();
    }

    @Override
    public String getInfo() {
        return "INSTRUKTUR | " + super.getInfo() + " | Keahlian: " + getKeahlian();
=======
// Menunjukkan bagian inheritance dengan kata kunci extends
public class Instruktur extends Orang {
    private String keahlian;

    public Instruktur(int id, String nama, String noHp, String keahlian) {
        // Pemanggilan super untuk meneruskan data umum ke constructor Orang
        super(id, nama, noHp);
        this.keahlian = keahlian;
    }

    public String getKeahlian() { return keahlian; }
    public void setKeahlian(String keahlian) { this.keahlian = keahlian; }

    @Override
    public String getInfo() {
        return "[Instruktur] " + super.getInfo() + " | Keahlian: " + keahlian;
>>>>>>> origin/master
    }
}

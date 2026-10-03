package model;

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
    }
}
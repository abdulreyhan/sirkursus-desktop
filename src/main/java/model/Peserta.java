package model;

<<<<<<< HEAD
public class Peserta extends Orang {
    private String nim;
    private String prodi;

    public Peserta(int id, String nama, String noHp, String nim, String prodi) {
        super(id, nama, noHp);
        setNim(nim);
        setProdi(prodi);
    }

    public String getNim() { return nim; }
    public String getProdi() { return prodi; }

    public void setNim(String nim) {
        if (nim == null || nim.trim().isEmpty())
            throw new IllegalArgumentException("NIM wajib diisi");
        this.nim = nim.trim();
    }

    public void setProdi(String prodi) {
        if (prodi == null || prodi.trim().isEmpty())
            throw new IllegalArgumentException("Prodi wajib diisi");
        this.prodi = prodi.trim();
    }

    @Override
    public String getInfo() {
        return "PESERTA | " + super.getInfo() + " | NIM: " + getNim() + " | Prodi: " + getProdi();
=======
// Menunjukkan bagian inheritance dengan kata kunci extends
public class Peserta extends Orang {
    private String nim;
    private String prodi;

    public Peserta(int id, String nama, String noHp, String nim, String prodi) {
        // Pemanggilan super untuk meneruskan data umum ke constructor Orang
        super(id, nama, noHp);
        this.nim = nim;
        this.prodi = prodi;
    }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    
    public String getProdi() { return prodi; }
    public void setProdi(String prodi) { this.prodi = prodi; }

    @Override
    public String getInfo() {
        return "[Peserta] " + super.getInfo() + " | NIM: " + nim + " | Prodi: " + prodi;
>>>>>>> origin/master
    }
}

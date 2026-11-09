package model;

public class Peserta extends Orang {
    private String nim;
    private String jenisKelamin;
    private String prodi;
    private String email;

    public Peserta() {
        // Constructor kosong
    }

    public Peserta(int id, String nama, String noHp, String nim, String jenisKelamin, String prodi, String email) {
        super(id, nama, noHp);
        setNim(nim);
        this.jenisKelamin = jenisKelamin;
        setProdi(prodi);
        this.email = email;
    }

    public Peserta(String nim, String nama, String jenisKelamin, String prodi, String noHp, String email) {
        super(0, nama, noHp);
        setNim(nim);
        this.jenisKelamin = jenisKelamin;
        setProdi(prodi);
        this.email = email;
    }

    public Peserta(int id, String nama, String noHp, String nim, String prodi) {
        super(id, nama, noHp);
        setNim(nim);
        setProdi(prodi);
    }

    public String getNim() { return nim; }
    public void setNim(String nim) {
        if (nim == null || nim.trim().isEmpty())
            throw new IllegalArgumentException("NIM wajib diisi");
        this.nim = nim.trim();
    }

    public String getProdi() { return prodi; }
    public void setProdi(String prodi) {
        if (prodi == null || prodi.trim().isEmpty())
            throw new IllegalArgumentException("Prodi wajib diisi");
        this.prodi = prodi.trim();
    }

    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getInfo() {
        return "PESERTA | " + super.getInfo() + " | NIM: " + getNim() + " | Prodi: " + getProdi();
    }
}
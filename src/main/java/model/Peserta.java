package model;

public class Peserta {

    private int idPeserta;
    private String nim;
    private String nama;
    private String jenisKelamin;
    private String prodi;
    private String noHp;
    private String email;

    public Peserta(String nim, String nama, String jenisKelamin,
                   String prodi, String noHp, String email) {
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.prodi = prodi;
        this.noHp = noHp;
        this.email = email;
    }

    public int getIdPeserta() { return idPeserta; }
    public void setIdPeserta(int idPeserta) { this.idPeserta = idPeserta; }
    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public String getJenisKelamin() { return jenisKelamin; }
    public String getProdi() { return prodi; }
    public String getNoHp() { return noHp; }
    public String getEmail() { return email; }
}
package com.example.pertemuan1;

public class Mahasiswa {
    private String nama, nim, noHp;

    public Mahasiswa(String nama, String nim, String nohp){
        this.nama = nama;
        this.nim = nim;
        this.noHp = nohp;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}

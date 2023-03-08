package com.example.pertemuan1.model;

public class Mahasiswa {
    private String nama, nim, alamat;

    public Mahasiswa(String nama, String nim, String alamat){
        this.nama = nama;
        this.nim = nim;
        this.alamat = alamat;
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
        return alamat;
    }

    public void setNoHp(String noHp) {
        this.alamat = alamat;
    }
}

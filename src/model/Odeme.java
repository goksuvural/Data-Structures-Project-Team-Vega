package model;

import java.time.LocalDate;

public class Odeme {
    private int id;
    private int abonelikId;
    private String abonelikAdi;
    private double tutar;
    private LocalDate tarih;

    public Odeme(int id, int abonelikId, String abonelikAdi, double tutar, LocalDate tarih) {
        this.id = id;
        this.abonelikId = abonelikId;
        this.abonelikAdi = abonelikAdi;
        this.tutar = tutar;
        this.tarih = tarih;
    }

    public int getId() { return id; }
    public int getAbonelikId() { return abonelikId; }
    public String getAbonelikAdi() { return abonelikAdi; }
    public double getTutar() { return tutar; }
    public LocalDate getTarih() { return tarih; }
}

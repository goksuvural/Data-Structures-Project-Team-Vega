package model;

import java.time.LocalDate;

public class Abonelik {
    private int id;
    private String ad;
    private double tutar;
    private int odemeGunu;      
    private String kategori;

    public Abonelik(int id, String ad, double tutar, int odemeGunu, String kategori) {
        this.id = id;
        this.ad = ad;
        this.tutar = tutar;
        this.odemeGunu = odemeGunu;
        this.kategori = kategori;
    }

    public int getId() { return id; }
    public String getAd() { return ad; }
    public double getTutar() { return tutar; }
    public int getOdemeGunu() { return odemeGunu; }
    public String getKategori() { return kategori; }

    //yaklaşan ödemeler kısmında kullanılır.
    public LocalDate sonrakiOdemeTarihi() {
        LocalDate bugun = LocalDate.now();
        LocalDate aday = bugun.withDayOfMonth(odemeGunu);
        if (aday.isBefore(bugun)) {
            aday = aday.plusMonths(1);
        }
        return aday;
    }

    @Override
    public String toString() {
        return ad + " - " + tutar + " TL - " + sonrakiOdemeTarihi();
    }
}

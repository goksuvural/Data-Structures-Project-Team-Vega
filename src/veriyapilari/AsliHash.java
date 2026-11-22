package veriyapilari;

import model.Odeme;

public class HashTablosu {
  private class Dugum {
    Odeme veri;
    Dugum sonraki;
    Dugum(Odeme veri) { this.veri = veri; }
  }
  private Dugum[] tablo;
  private int boyu;

  public HashTablosu(int kapasite) {
    tablo = new Dugum[kapasite];
    boyut = 0;
  }

  private int hash(int id) { return id % tablo.length; }

  public void ekle(Odeme o) {  }
  public Odeme bul(int id) { return null; }
  public boolean sil(int id) {return false; }
  public int boyut() { return boyut; }

}
  

package veriyapilari;

import model.Abonelik;

public class CiftYonluListe {

    private class Dugum {
        Abonelik veri;
        Dugum onceki;
        Dugum sonraki;

        Dugum(Abonelik veri) {
            this.veri = veri;
        }
    }

    private Dugum bas;
    private Dugum son;
    private int boyut;

    public void ekle(Abonelik a) {
    }

    public boolean sil(int id) {
        return false;
    }

    public Abonelik bul(int id) {
        return null;
    }

    public int boyut() {
        return boyut;
    }

    //ortak belirtilen listele() metodu:
    public Abonelik[] listele() {
        return null;
    }
}

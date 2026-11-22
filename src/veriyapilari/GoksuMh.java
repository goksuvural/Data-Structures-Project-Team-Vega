package veriyapilari;

import model.Abonelik;

public class GoksuMh {
    private Abonelik[] dizi;
    private int boyut;

    public MinHeap(int kapasite) {
        dizi = new Abonelik[kapasite];
        boyut = 0;
    }

    public void ekle(Abonelik a) { }
    public Abonelik enKucuguCikar() { return null; }
    public Abonelik enKucuguGor() { return null; }
    public int boyut() { return boyut; }
    public boolean bosMu() { return boyut == 0; }
}

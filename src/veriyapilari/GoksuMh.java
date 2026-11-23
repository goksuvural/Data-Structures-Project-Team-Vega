package veriyapilari;

import model.Abonelik;

public class MinHeap {
    private Abonelik[] dizi;
    private int boyut;

    public MinHeap(int kapasite) {
        if (kapasite < 1) {
            kapasite = 1;                 // 0 kapasite büyütmeyi bozar
        }
        dizi = new Abonelik[kapasite];
        boyut = 0;
    }

    // ---- Yardımcı metotlar ----
    private int ebeveyn(int i) { return (i - 1) / 2; }
    private int solCocuk(int i) { return 2 * i + 1; }
    private int sagCocuk(int i) { return 2 * i + 2; }

    // a, b'den ÖNCE mi ödenecek? (karşılaştırma ölçütü: sonraki ödeme tarihi)
    private boolean oncemi(Abonelik a, Abonelik b) {
        return a.sonrakiOdemeTarihi().isBefore(b.sonrakiOdemeTarihi());
    }

    private void takas(int i, int j) {
        Abonelik gecici = dizi[i];
        dizi[i] = dizi[j];
        dizi[j] = gecici;
    }

    private void kapasiteBuyut() {
        Abonelik[] yeni = new Abonelik[dizi.length * 2];
        for (int i = 0; i < boyut; i++) {
            yeni[i] = dizi[i];
        }
        dizi = yeni;
    }

    // ---- Ana metotlar ----
    public void ekle(Abonelik a) {
        if (a == null) {
            return;
        }
        if (boyut == dizi.length) {
            kapasiteBuyut();
        }
        dizi[boyut] = a;          // sona koy
        yukariTasi(boyut);        // yerine oturt
        boyut++;
    }

    private void yukariTasi(int i) {
        while (i > 0 && oncemi(dizi[i], dizi[ebeveyn(i)])) {
            takas(i, ebeveyn(i));
            i = ebeveyn(i);
        }
    }

    public Abonelik enKucuguCikar() {
        if (bosMu()) {
            return null;
        }
        Abonelik en = dizi[0];            // çıkarılacak kök
        dizi[0] = dizi[boyut - 1];        // son elemanı köke al
        dizi[boyut - 1] = null;           // eski yeri temizle
        boyut--;
        if (boyut > 0) {
            asagiTasi(0);
        }
        return en;
    }

    private void asagiTasi(int i) {
        while (true) {
            int sol = solCocuk(i);
            int sag = sagCocuk(i);
            int kucuk = i;

            if (sol < boyut && oncemi(dizi[sol], dizi[kucuk])) {
                kucuk = sol;
            }
            if (sag < boyut && oncemi(dizi[sag], dizi[kucuk])) {
                kucuk = sag;
            }
            if (kucuk == i) {
                break;                    // kural sağlandı, dur
            }
            takas(i, kucuk);
            i = kucuk;
        }
    }

    public Abonelik enKucuguGor() {
        if (bosMu()) {
            return null;
        }
        return dizi[0];
    }

    public int boyut() { return boyut; }
    public boolean bosMu() { return boyut == 0; }
}

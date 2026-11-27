package veriyapilari;  //Sınıfın paketini belirtir.
import model.Abonelik;  //Önceden oluşturulan Abonelik sınıfını kullanmayı sağlar.

public class DinamikDizi {
  
  private Abonelik[] dizi;  //Abonelik nesnelerini saklayacak bir dizi oluşturur.
  private int boyut;

  public DinamikDizi(){
    dizi = new Abonelik[4];
    boyut = 0;
  }

  public DinamikDizi(int baslangicKapasitesi){
    int kapasite = Math.max(1, baslangicKapasitesi);
    this.dizi = new Abonelik[kapasite];
    this.boyut = 0;
  }

  private void kapasiteArttir(){  //Dizi dolduğunda yeniDizi adında mevcut uzunluğun 2 katı yeni bir dizi açılır.
    Abonelik[] yeniDizi = new Abonelik[dizi.length * 2];
    for (int i = 0; i < boyut; i++) {
      yeniDizi[i] = dizi[i];
    }
    dizi= yeniDizi;
  }

  public void ekle(Abonelik a) {  //Yeni bir Abonelik nesnesi ekler.
    if(a == null){
      return;
    }
    if (boyut == dizi.length){
      kapasiteArttir();
    }
    dizi[boyut] = a;
    boyut++;
  }

  public boolean sil(int id){  //Verilen id Aboneliğini bulur ve siler.
    for(int i = 0; i< boyut; i++){
      if(dizi[i] ! = null && dizi[i].getId() == id){
        for (int j = i; j< boyut-1; j++){
          dizi[j] = dizi[j+1];
        }
        dizi[boyut - 1] = null;
        boyut--;
        return true;
      }
    }
    return false;
  }

  public Abonelik getir(int index){  //Abonelik nesnesine doğrudan erişir ve döndürür.
    if(index < 0 || index >= boyut) {
      throw new IndexOutOfBoundsException("Gecersiz index: " +index);
    }
    return dizi[index];
  }

  public void guncelle(int index, Abonelik yeniAbonelik){  //Abonelik bilgilerini günceller.
    if (index<0 || index>=boyut){
      throw new IndexOutOfBoundsException ("Gecersiz index");
    }

    if (yeniAbonelik == null){
      return;
    }

    dizi[index] = yeniAbonelik;
  }
  
  public int boyut(){  //Dizideki mevcut eleman sayısını herkese açık bir şekilde döndürür.
    return boyut;
  }

  public int kapasite(){  //Dizinin kapasitesini döndürür.
    return dizi.lenght;
  }

  public boolean bosMu(){  //Dizinin boş olup olmadığını kontrol eder.
    return boyut == 0;
  }

  public void temizle(){
    for (int i = 0; 1<boyut; i++){
      dizi[i] = null;
    }
    boyut = 0;
  }
  
  public Abonelik[] listele(){  //İç dizinin dolu olan boyut kadar elemanı sonuç adlı yeni bir Abonelik dizisine kopyalar ve dışarıya verir.
    Abonelik[] sonuc = new Abonelik[boyut];
    for (int i = 0; i<boyut; i++){
      sonuc[i] = dizi[i];
    }
    return sonuc;
  }

  public double aylikToplam(){  //0'dan boyuta kadarki elemanları gezer, null olmayan Abonelik nesnesinin getTutar() değerini toplam değişkenine ekleyerek toplam aylık abonelik giderini döndürür.
    double toplam = 0.0;
    for (int i = 0; i<boyut; i++){
      if(dizi[i] !=null){
        toplam += dizi[i].getTutar();
      }
    }
    return toplam;
  }
  
  public double yillikTahmin(){  //Metodun aylık tutarını 12.0 ile çarparak yıllık toplam harcamayı hesaplar ve döndürür.
    return aylikToplam() * 12.0;
  }

  public Abonelik siradakiOdeme(LocalDate bugun){  //Tarih bilgilerini tutmak ve tarih işlemlerini yapmak için kullanılır (Ay, gün, yıl tutar, saat tutmaz.).
    if (boyut == 0){
      return null;
    }
    Abonelik enYakin = dizi[0];
    long enAzGun = enYakin.kalanGun(bugun);
    
    for(int=i; i<boyut; i++){
      long gun = dizi[i].kalanGun(bugun);
      if (gun < enAzGun){
        enAzGun = gun;
        enYakin = dizi[i];
      }
    }
    return enYakin;
  }
}

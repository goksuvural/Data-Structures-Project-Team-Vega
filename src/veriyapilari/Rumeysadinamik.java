package veriyapilari; //Sınıfın paketini belirtir.
import model.Abonelik; //Önceden oluşturulan Abonelik sınıfını kullanmayı sağlar.

public class DinamikDizi {
  
  private Abonelik[] dizi; //Abonelik nesnelerini saklayacak bir dizi oluşturur.
  private int boyut;

  public DinamikDizi(){
    dizi = new Abonelik[4];
    boyut = 0;
  }

  public void ekle(Abonelik a) { //Yeni bir Abonelik nesnesi ekler.
  }

  public boolean sil(int id){ //Verilen id Aboneliğini bulur ve siler.
    return false;
  }

  public Abonelik getir(int index){ //Abonelik nesnesine doğrudan erişir ve döndürür.
    return null;
  }

  public int boyut(){ //Dizideki mevcut eleman sayısını herkese açık bir şekilde döndürür.
    return boyut;
  }
}

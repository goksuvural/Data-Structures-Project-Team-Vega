# Ortak Kanal

Bu dosyayı sadece proje lideri değiştirir. Değişiklik gerekirse Issue açılır.

## Ortak sınıflar (src/model)
| Sınıf | Alanlar |
|---|---|
| Abonelik | id (int), ad (String), tutar (double), odemeGunu (int, 1-28), kategori (String) |
| Odeme | id (int), abonelikId (int), abonelikAdi (String), tutar (double), tarih (LocalDate) |

Sabit değerler `Sabitler.java` içindedir. Kategori adlarını elle yazmayın.

## Veri yapısı metot isimleri
| Veri yapısı | Sahibi | Metotlar |
|---|---|---|
| MinHeap | Göksu | ekle(Abonelik), enKucuguCikar(), enKucuguGor(), boyut(), bosMu() |
| HashTablosu | Aslı | ekle(Odeme), bul(int id), sil(int id), boyut(), listele() |
| CiftYonluListe | Zeynep | ekle(Abonelik), sil(int id), bul(int id), boyut(), listele() |
| DinamikDizi | Rümeysa | ekle(Abonelik), sil(int id), getir(int index), boyut(), listele() |

## Kurallar
1. Hazır Java veri yapıları (ArrayList, HashMap, LinkedList, PriorityQueue vb.) kullanılmaz.
2. `main` dalına doğrudan push yok, sadece Pull Request.
3. Herkes sadece kendi dosyasında çalışır.
4. Branch adları: `feature/min-heap`, `feature/hash-tablosu`, `feature/cift-yonlu-liste`, `feature/dinamik-dizi`.

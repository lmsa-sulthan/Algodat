# Implementasi Struktur Data Queue

Kumpulan program Java ini memperlihatkan beberapa penerapan queue dan satu contoh penggunaan stack bersama queue. Program dibuat tanpa `import java.util.*`.

## Daftar berkas

1. `Queue.java` — antrean menggunakan singly linked list.
2. `DoublyLinkedListQueue.java` — antrean dengan node yang memiliki tautan ke node sebelum dan sesudahnya.
3. `PalindromeChecker.java` — memeriksa palindrome dengan bantuan stack dan queue.
4. `CircularArrayQueue.java` — antrean berbasis array melingkar dengan kapasitas tetap.
5. `PriorityQueue.java` — antrean yang mengurutkan elemen berdasarkan prioritas.
6. `Stack.java` — struktur stack linked list yang dipakai oleh pemeriksa palindrome.
7. `Main.java` — menjalankan contoh seluruh program.

## Kompilasi dan menjalankan

Simpan seluruh file dalam satu folder. Buka terminal pada folder tersebut, lalu jalankan:

```bash
javac *.java
java Main
```

Setiap kelas demo juga dapat dijalankan secara terpisah, misalnya `java Queue` atau `java CircularArrayQueue`.

## Keterangan

- Queue biasa menggunakan prinsip FIFO (*First In, First Out*).
- Pada circular queue, kapasitas ditentukan saat objek dibuat. Posisi array kembali ke awal menggunakan operasi modulo.
- Pada priority queue, angka prioritas lebih besar akan diproses lebih dahulu. Jika nilainya sama, urutan masuk tetap dipertahankan.
- Pemeriksaan palindrome mengabaikan spasi dan tanda baca serta tidak membedakan huruf besar dan kecil.

# Implementasi Singly Linked List (ADT) di Java

## 1. Gambaran Umum (Overview)
Proyek ini mengimplementasikan struktur data *Singly Linked List* menggunakan konsep *Abstract Data Type* (ADT). Kelas abstrak `Data` berfungsi sebagai cetakan dasar, sehingga struktur *Linked List* yang sama bisa digunakan kembali (reusable) untuk menyimpan berbagai macam jenis objek yang berbeda. Dalam kasus proyek ini, *Linked List* dapat menampung objek `Komputer` dan `Siswa`.

## 2. Struktur File
| File | Deskripsi |
|---|---|
| `Data.java` | Kelas abstrak induk (ADT) yang menyimpan properti umum (`nama`) dan memiliki aturan `equals` untuk keperluan pencarian atau penghapusan data. |
| `Komputer.java` | *Subclass* pertama dari `Data` yang merepresentasikan data laptop/komputer dengan tambahan atribut spesifik `ram`. |
| `Siswa.java` | *Subclass* kedua dari `Data` yang merepresentasikan mahasiswa dengan tambahan atribut spesifik `nim`. |
| `Node.java` | Kelas pembentuk simpul. Menyimpan isi dari objek `Data` dan memiliki referensi/petunjuk (`next`) ke *Node* berikutnya. |
| `LinkedList.java` | Kelas wadah operasional yang memiliki `head` (kepala) dan `tail` (ekor) untuk mengelola fungsi `tambah`, `tampilkan`, dan `hapus`. |
| `Main.java` | Program utama untuk mengetes pembuatan dua *Linked List* terpisah, satu untuk objek `Komputer` dan satu untuk `Siswa`. |

## 3. Konsep ADT yang Digunakan
Kekuatan dari program ini ada pada kelas `Node` dan `LinkedList`. Kedua kelas ini **tidak mempedulikan** apakah mereka sedang menyimpan objek `Komputer` atau `Siswa`. Selama objek tersebut merupakan turunan (*extends*) dari kelas `Data`, maka *Linked List* bisa menyimpannya secara valid. 

## 4. Penjelasan Kelas & Fungsi Utama

* **Kelas `Data` (Entity)**: Kelas abstrak ini memastikan setiap *subclass* memiliki nama. Ia melakukan *override* pada `equals()` sehingga dua data dianggap sama cukup dengan mencocokkan nama teksnya saja, yang sangat mempermudah proses hapus data.
* **Fungsi `tambah(Data dataBaru)`**: Memasukkan data baru selalu di posisi paling belakang (*append*). Karena kita menggunakan variabel bantu `tail` (ekor), penambahan data sangat cepat O(1) tanpa perlu menelusuri list dari titik awal.
* **Fungsi `tampilkan()`**: Menelusuri seluruh *Node* (Traverse). Dimulai dari `head` (depan) bergeser terus ke penunjuk `lanjut` hingga bertemu dengan *Node* yang bernilai `null` (batas akhir). Saat ditelusuri, metode `toString()` otomatis dieksekusi.
* **Fungsi `hapus(Data kunciHapus)`**: Mencari data dari depan. Jika nama string cocok (menggunakan `equals`), rantai (link) ke simpul tersebut akan dilompati. Pemutus rantai ini otomatis membuat data tersebut terhapus dari memori secara permanen.

## 5. Cara Menjalankan Program
1. Pastikan semua file Java berada dalam satu folder yang sama.
2. Buka Terminal atau *Command Prompt* di folder tersebut.
3. Ketik perintah berikut untuk melakukan kompilasi:
   `javac *.java`
4. Jalankan program dengan perintah:
   `java Main`

## 6. Output Program
Berikut adalah representasi hasil keluaran di konsol saat program dijalankan:
<img width="622" height="297" alt="Screenshot 2026-09-29 204920" src="https://github.com/user-attachments/assets/cee64510-9d3a-4754-86bf-556f8dcc3340" />

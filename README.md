# Tugas Linked List Sederhana dengan Implementasi ADT

**1. Gambaran Umum (Overview)**
Proyek ini mengimplementasikan struktur data *Singly Linked List* dalam bahasa Java dengan versi yang disederhanakan. Program ini menggunakan kelas abstrak `DataUtama` sebagai *Abstract Data Type* (ADT). Dengan menggunakan ADT, satu *Linked List* dapat menampung tipe data yang mewarisi sifat dari kelas induknya (dalam contoh ini adalah `Komputer`). Tujuan utamanya adalah untuk menunjukkan operasi dasar *Linked List* seperti menambah data (*insert*), menelusuri data (*traverse/display*), dan menghapus data (*delete*).

**Struktur Proyek**

| File | Peran |
| :--- | :--- |
| `DataUtama.java` | Kelas induk abstrak (ADT) untuk semua data yang akan disimpan di dalam *list* (menyimpan nama, menyediakan fungsi `equals` dan `toString`). |
| `Komputer.java` | Kelas spesifik (*subclass*) dari `DataUtama` yang merepresentasikan objek komputer (memiliki tambahan memori RAM). |
| `Simpul.java` | Kelas yang merepresentasikan satu *Node*: berisi satu data (ADT) dan petunjuk ke simpul berikutnya. |
| `Senarai.java` | Wadah utama (*Linked List*): memiliki `kepala` (head), `ekor` (tail), dan operasi pengolahan *list*. |
| `Main.java` | Program utama untuk menguji setiap fungsi (tambah, tampil, hapus) tanpa menu interaktif agar alur mudah dipahami. |

**Cara Menjalankan (How to Run)**
Buka terminal/command prompt di dalam folder proyek, lalu jalankan perintah:
```bash
javac *.java
java Main
```

**Ilustrasi Struktur Data**
Gambar di bawah ini menunjukkan *Senarai* (list) setelah tiga objek Komputer ditambahkan di `Main`. `kepala` menunjuk ke simpul pertama, `ekor` menunjuk ke simpul terakhir, dan petunjuk (*lanjut*) dari simpul terakhir bernilai `null`.

[kepala] -> [Komputer: Asus ROG] -> [Komputer: Lenovo Thinkpad] -> [Komputer: Acer Swift] <- [ekor] -> null

---

**2. DataUtama.java (Kelas Induk / Entity)**
Kelas abstrak yang berfungsi sebagai tipe elemen utama dari ADT. Karena bersifat abstrak, `DataUtama` tidak bisa dibuat objeknya secara langsung, melainkan harus diwariskan.
*   **Atribut:** Memiliki `nama` yang bersifat *private* (enkapsulasi), dan hanya bisa diambil melalui `getNama()`.
*   **Fungsi `toString()`:** Ditimpa (*override*) agar saat objek dicetak, yang keluar adalah teks namanya, bukan kode unik memori.
*   **Fungsi `equals()`:** Sangat penting untuk proses *Delete*. Fungsi ini diatur ulang agar dua objek dianggap "sama" jika kelasnya sama dan string namanya sama (misalnya: `nama.equals(dataLain.nama)`). Hal ini memungkinkan kita menghapus data dengan membuat objek baru bertipe sama hanya bermodalkan namanya saja.

**3. Komputer.java (Kelas Spesifik / Subclass)**
Merupakan *subclass* (turunan) dari `DataUtama` yang merepresentasikan data fisik komputer.
*   **Atribut Khusus:** Menambahkan variabel `ram` (integer) yang spesifik hanya dimiliki komputer.
*   **Konstruktor:** Memiliki konstruktor utama untuk mendaftar data (dengan nama dan RAM), dan konstruktor sederhana (hanya nama) untuk keperluan pencarian saat akan menghapus data (memanfaatkan `super(nama)`).

**4. Simpul.java (Node)**
Bongkahan dasar penyusun rantai *Linked List*. Setiap simpul menyimpan satu buah data dan satu referensi untuk menunjuk ke simpul depannya.
*   **Atribut:** `data` bertipe `DataUtama` (sehingga bisa diisi turunan apa saja, seperti `Komputer`), dan `lanjut` yang bertipe `Simpul` untuk menyambung rantai.
*   Saat dibuat (`new Simpul()`), nilai `lanjut` otomatis diset ke `null`.

**5. Senarai.java (Linked List Utama)**
Kelas yang merangkai dan mengelola semua kumpulan `Simpul`.
*   **Atribut:** Memiliki `kepala` (head) untuk menyimpan alamat simpul pertama, dan `ekor` (tail) untuk menyimpan alamat simpul terakhir agar penambahan data ke belakang memakan waktu yang sangat cepat, yaitu O(1).
*   **Fungsi `tambah(DataUtama)`:** Menambahkan simpul baru di ujung *list*. Jika *list* kosong, data tersebut menjadi `kepala` sekaligus `ekor`. Jika sudah ada isi, data diikat ke belakang `ekor`, lalu status `ekor` dipindah ke data baru tersebut.
*   **Fungsi `tampilkan()`:** Menelusuri seluruh *list* (Traverse). Dimulai dengan membuat penunjuk `saatIni` di `kepala`, lalu terus bergeser (`saatIni = saatIni.lanjut`) sambil mencetak data ke layar sampai menyentuh batas akhir (`null`).
*   **Fungsi `hapus(DataUtama)`:** Menghapus data spesifik. Memiliki tiga skenario: (1) Jika *list* kosong, batalkan. (2) Jika yang dihapus ada di paling depan, geser `kepala` ke simpul nomor 2. (3) Jika yang dihapus di tengah/akhir, gunakan bantuan penunjuk `sebelum` untuk melompati rantai simpul yang dihapus (`sebelum.lanjut = saatIni.lanjut`).

**6. Main.java**
Program utama yang membuat wadah senarai bernama `listKomputer`, mengisi 3 data, menampilkannya, lalu menguji *behavior* penghapusan dengan menghapus salah satu data (Lenovo Thinkpad), dan menampilkannya kembali untuk membuktikan rantai berhasil disambung ulang.

**7. Output Program (Hasil Jalannya Program)**
Saat program dieksekusi (`java Main`), berikut adalah hasil keluarannya di konsol:

```text
=== DAFTAR KOMPUTER AWAL ===
- Laptop Asus ROG (RAM: 16 GB)
- Laptop Lenovo Thinkpad (RAM: 8 GB)
- Laptop Acer Swift (RAM: 8 GB)

=== PROSES MENGHAPUS ===
Lenovo Thinkpad berhasil dihapus.

=== DAFTAR KOMPUTER SETELAH DIHAPUS ===
- Laptop Asus ROG (RAM: 16 GB)
- Laptop Acer Swift (RAM: 8 GB)
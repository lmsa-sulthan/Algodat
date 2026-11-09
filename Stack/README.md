# Program Stack untuk Ekspresi Matematika

Proyek ini berisi program Java yang menerapkan struktur data **Stack** dalam tiga proses:

1. `ParenthesisChecker.java` memeriksa pasangan tanda kurung `()`, `[]`, dan `{}`.
2. `InfixToPostfix.java` mengubah ekspresi infix menjadi postfix dengan aturan prioritas operator.
3. `EvaluatePostfix.java` menghitung hasil ekspresi postfix yang operand-nya berupa bilangan bulat.
4. `Main.java` menggabungkan ketiga proses tersebut agar dapat dijalankan melalui satu input.

Operator yang dikenali adalah `+`, `-`, `*`, `/`, `%`, dan `^`. Untuk evaluasi, pisahkan setiap operand dan operator postfix menggunakan spasi.

## Menjalankan program

Pastikan JDK sudah terpasang. Simpan seluruh file `.java` dalam folder yang sama, lalu jalankan perintah berikut di terminal:

```bash
javac Main.java
java Main
```

Contoh input:

```text
(8 + 2) * 3
```

Program akan memeriksa tanda kurung, menampilkan bentuk postfix, kemudian menghitung hasilnya.

Setiap class juga mempunyai metode `main()` untuk mencoba contoh masing-masing secara terpisah.

# 💱 Currency Converter - Java Swing

Aplikasi konversi mata uang sederhana berbasis **Java Swing** dengan konsep **Object Oriented Programming (OOP)**.

---

## 📌 Features

- Konversi mata uang:
  - IDR
  - USD
  - EUR
  - MYR
- Custom icon pada dropdown mata uang
- Clean & simple GUI
- Pemisahan logic dan tampilan (OOP)
- Struktur package terorganisir

---

## 🛠 Tech Stack

- Java 17+
- Java Swing (GUI)
- OOP Concept

---

## 📂 Project Structure

```text
src/
└── projek/
    ├── Main.java
    ├── gui.java
    ├── Fungsi.java
    ├── Fungsi2.java
    ├── ikon.java
    └── img/
        ├── idr.png
        ├── usd.png
        ├── eur.png
        └── myr.png
```

---

## 🧠 Architecture Overview

- **Main.java** → Entry point aplikasi
- **gui.java** → Tampilan dan event handling
- **Fungsi.java** → Data nilai kurs (logic)
- **Fungsi2.java** → Perhitungan konversi
- **ikon.java** → Custom ListCellRenderer untuk icon mata uang

---

## 🖼 Resource Handling

Gambar mata uang disimpan di:

```
projek/img/
```

Icon dimuat menggunakan:

```java
new ImageIcon("/projek/img/idr.png");
```

---

## ▶️ How To Run

1. Buka project di IDE (IntelliJ / NetBeans / Eclipse)
2. Pastikan folder `img` berada dalam package `projek`
3. Jalankan `Main.java`

---

## 🎯 Concept Applied

- Object Oriented Programming
- Encapsulation
- Separation of Concern
- Custom Renderer (Swing)

---

## 📄 Author

Project dibuat untuk tugas akhir PBO (Pemrograman Berorientasi Objek).

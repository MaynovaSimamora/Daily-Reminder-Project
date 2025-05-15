**Daily Reminder Project - README**

**Deskripsi Singkat Proyek**
Aplikasi Task Manager adalah program berbasis Java untuk mengelola tugas-tugas harian. Aplikasi ini memungkinkan pengguna untuk:
1. Menambahkan tugas baru dengan deadline dan prioritas
2. Melihat daftar tugas yang ada
3. Menandai tugas sebagai selesai
4. Menghapus tugas yang sudah selesai
5. Melihat tugas berdasarkan deadline terdekat

**Struktur Class**
1. Package manager
   TaskManager: Kelas utama yang mengelola operasi-operasi terkait tugas
   1. Menyimpan daftar tugas dalam List
   2. Menyediakan metode untuk menambah, menghapus, dan memodifikasi tugas
   3. Memiliki fitur sorting berdasarkan deadline
2. Package model
   1. ITask: Interface yang mendefinisikan kontrak untuk kelas Task
   2. Task: Implementasi dasar dari ITask
   3. PriorityTask: Kelas turunan dari Task yang menambahkan fitur prioritas
3. Package storage
   1. FileStorage: Kelas yang menangani penyimpanan dan pembacaan data dari file
      - Menyimpan data dalam format CSV
      - Mendukung serialisasi dan deserialisasi untuk kedua jenis Task
4. Kelas Main
   1. Menyediakan antarmuka pengguna berbasis konsol
   2. Menghubungkan semua komponen aplikasi
   3. Menangani input/output pengguna

**Cara Menjalankan Program**
1. Menjalankan di VS Code (Paling Mudah)
   Langkah-langkah:
   - Buka folder project di VS Code dengan struktur:
    task-manager/
    └── src/
        ├── manager/
        ├── model/
        ├── storage/
        └── Main.java
    Install extension Java di VS Code:
   - Buka Extensions (Ctrl+Shift+X)
   - Cari "Extension Pack for Java" (by Microsoft)
   - Install
   - Run Program:
   - Buka file Main.java
   - Klik tombol Run (ikon segitiga hijau di bagian atas editor)
   - Atau tekan Ctrl+F5 (Run tanpa debug)
   - Jika muncul prompt "Create launch.json", pilih Java.

2. Menjalankan via Terminal/CMD
   Langkah-langkah:
   1. Buka terminal di folder project (pastikan ada folder src).
   2. Compile semua file:
      bash
      javac -d bin src/**/*.java
      (Ini akan membuat folder bin berisi file .class)
   3. Jalankan program:
      bash
      java -cp bin Main

**Pembagian Tugas**
Anggota 1: Diani
  - Mendesain interface ITask
  - Mengimplementasikan kelas dasar Task
  - Membuat kelas PriorityTask sebagai turunan Task
Anggota 2: Geby
  - Mengimplementasikan TaskManager dengan semua fitur manajemen tugas
  - Membuat dokumentasi
  - Membantu pengerjaan di tugas anggota 4
Anggota 3:
  - Menangani input pengguna dan validasi
  - Mengintegrasikan semua komponen
  - Membantu pengerjaan di tugas anggota 1
Anggota 4: Aril
  - Membuat antarmuka pengguna (Main class)
  - Mengimplementasikan menu dan alur program
  - Mengintegrasikan semua komponen


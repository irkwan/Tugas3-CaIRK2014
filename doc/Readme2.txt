Author : Varian Caesar
NIM    : 13514041

----------------------------------------------------------------------------------------------------------------
Cara Menggunakan Wordament Solver
----------------------------------------------------------------------------------------------------------------
1. Jalankan aplikasi
2. Input wordament pada tempat yang disediakan
3. Click Solve
4. Done
5. Jika ingin memulai sesi baru, click clear untuk membersihkan hasil pekerjaan sebelumnya

----------------------------------------------------------------------------------------------------------------
Keterangan Tambahan
----------------------------------------------------------------------------------------------------------------
Tools yang digunakan adalah Visual Studio 2015, Windows Form Application C++

Versi aplikasi yang dikumpulkan yaitu versi release, tetapi pengembang juga menyertakan versi debug pada folder :
~/src/WordamentSolver/x64/Debug/WordamentSolver.exe
Hal ini dilakukan karena pada versi release, proses berjalan sangat cepat ( <  1 sekon ) sehingga timer pada 
aplikasi menjadi tidak teramati perubahan dan kerja thread nya. Pada versi debug, karena berjalan lebih lambat 
dibandingkan versi release, timer dapat diamati dengan baik karena proses rata-rata memakan waktu 5-6 sekon pada
versi ini. Sehingga penyertaan versi debug ini hanya untuk menguji kinerja timer yang dibuat apabila dibutuhkan.
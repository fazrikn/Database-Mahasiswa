
import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nim, nama, jurusan;

    Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }
}

public class DatabaseMahasiswa {
    static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n===== MENU DATABASE MAHASISWA =====");
            System.out.println("1. Tampilkan Data Mahasiswa");
            System.out.println("2. Input Data Mahasiswa");
            System.out.println("3. Cari Data Mahasiswa");
            System.out.println("4. Ubah Data Mahasiswa");
            System.out.println("5. Hapus Data Mahasiswa");
            System.out.println("6. Exit");
            System.out.print("Pilih menu (1-6): ");
            pilihan = input.nextInt();
            input.nextLine(); // menghindari error scanner

            switch (pilihan) {
                case 1 -> tampilkanData();
                case 2 -> inputData();
                case 3 -> cariData();
                case 4 -> ubahData();
                case 5 -> hapusData();
                case 6 -> System.out.println("Keluar dari program...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 6);
    }

    static void tampilkanData() {
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
        } else {
            System.out.println("\nData Mahasiswa:");
            for (Mahasiswa mhs : dataMahasiswa) {
                System.out.println("NIM: " + mhs.nim + ", Nama: " + mhs.nama + ", Jurusan: " + mhs.jurusan);
            }
        }
    }

    static void inputData() {
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Jurusan: ");
        String jurusan = input.nextLine();

        dataMahasiswa.add(new Mahasiswa(nim, nama, jurusan));
        System.out.println("Data berhasil ditambahkan!");
    }

    static void cariData() {
        System.out.print("Masukkan NIM yang dicari: ");
        String cariNim = input.nextLine();
        for (Mahasiswa mhs : dataMahasiswa) {
            if (mhs.nim.equals(cariNim)) {
                System.out.println("Data ditemukan: " + mhs.nim + ", " + mhs.nama + ", " + mhs.jurusan);
                return;
            }
        }
        System.out.println("Data tidak ditemukan.");
    }

    static void ubahData() {
        System.out.print("Masukkan NIM yang akan diubah: ");
        String nim = input.nextLine();
        for (Mahasiswa mhs : dataMahasiswa) {
            if (mhs.nim.equals(nim)) {
                System.out.print("Masukkan Nama baru: ");
                mhs.nama = input.nextLine();
                System.out.print("Masukkan Jurusan baru: ");
                mhs.jurusan = input.nextLine();
                System.out.println("Data berhasil diubah.");
                return;
            }
        }
        System.out.println("Data tidak ditemukan.");
    }

    static void hapusData() {
        System.out.print("Masukkan NIM yang akan dihapus: ");
        String nim = input.nextLine();
        for (Mahasiswa mhs : dataMahasiswa) {
            if (mhs.nim.equals(nim)) {
                dataMahasiswa.remove(mhs);
                System.out.println("Data berhasil dihapus.");
                return;
            }
        }
        System.out.println("Data tidak ditemukan.");
    }
}

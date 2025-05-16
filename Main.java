import manager.TaskManager;
import model.PriorityTask;
import model.Task;
import storage.FileStorage;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static TaskManager tm = new TaskManager();
    private static FileStorage fs = new FileStorage();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        fs.loadTasks(tm);
        System.out.println("=== APLIKASI MANAJER TUGAS ===");

        while (true) {
            printMenu();
            try {
                int choice = Integer.parseInt(input.nextLine()); // Hindari input mismatch
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        viewTasks();
                        break;
                    case 3:
                        completeTask();
                        break;
                    case 4:
                        deleteCompleted(); // Akan otomatis simpan setelah hapus
                        break;
                    case 5:
                        saveAndExit();
                        return;
                    case 6:
                        viewTasksByDeadline();
                        break;
                    default:
                        System.out.println("Pilihan tidak tersedia!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    }


    private static void printMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Tambah Tugas");
        System.out.println("2. Lihat Tugas");
        System.out.println("3. Tandai Selesai");
        System.out.println("4. Hapus Tugas Selesai");
        System.out.println("5. Keluar");
        System.out.print("Pilih: ");
    }

  
    private static void addTask() {
        System.out.print("\nJudul: ");
        String title = input.nextLine();

        LocalDate dueDate = null;
        while (true) {
            try {
                System.out.print("Deadline (yyyy-mm-dd): ");
                dueDate = LocalDate.parse(input.nextLine());

                if (dueDate.isBefore(LocalDate.now())) {
                    System.out.println("Deadline tidak boleh di masa lalu!");
                    continue;
                }
                break;   
            } catch (Exception e) {
                System.out.println("Mohon masukkan tanggal deadline yang valid.");
            }
        }

        while (true) {
            System.out.print("Pilih prioritas tugas (low / medium / high) : ");
            String isPriority = input.nextLine().trim().toLowerCase();
            if (isPriority.equals("low") || isPriority.equals("medium") || isPriority.equals("high")) {
                tm.addTask(new PriorityTask(title, dueDate, isPriority));
                break;
            } else {
                System.out.println("Prioritas tidak valid. Harus 'low', 'medium', atau 'high'.");
            }
        }  
    } 
        

    private static void viewTasks() {
        System.out.println("\n=== DAFTAR TUGAS ===");
        tm.showAllTasks();
        tm.checkOverdueTasks();
    }

    private static void completeTask() {
        while (true) {
            System.out.print("\nNomor tugas yang selesai: ");
            try {
                String inputStr = input.nextLine();
                int taskNum = Integer.parseInt(inputStr) - 1;
                tm.markTaskAsCompleted(taskNum);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan nomor tugas yang valid!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Nomor tugas tidak ditemukan. Mohon masukkan angka yang valid!");
            }
        }
    }


    private static void deleteCompleted() {
        if (!tm.hasCompletedTasks()) {
            System.out.println(" \nTidak ada tugas yang telah diselesaikan untuk dihapus.");
            return;
        }

        System.out.println("\nMenghapus tugas selesai...");
        tm.removeCompletedTasks();
        fs.saveTasks(tm.getAllTasks());
        System.out.println("Tugas selesai berhasil dihapus.");
    }


    private static void saveAndExit() {
        fs.saveTasks(tm.getAllTasks());
        System.out.println("Data disimpan. Sampai jumpa!");
    }

    private static void viewTasksByDeadline() {
        tm.showTasksByDeadline();
}
}
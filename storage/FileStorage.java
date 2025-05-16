package storage;

import model.ITask;
import model.PriorityTask;
import model.Task;
import manager.TaskManager;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class FileStorage {
    private static final String FILE_NAME = "tasks.txt";

    public void saveTasks(List<ITask> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("title,dueDate,completed,priority\n");
            for (ITask task : tasks) {
                String priority = (task instanceof PriorityTask) ? 
                    ((PriorityTask) task).getPriority() : "";
                writer.write(String.join(",",
                    task.getTitle(),
                    task.getDueDate().toString(),
                    String.valueOf(task.isCompleted()),
                    priority
                ));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    public void loadTasks(TaskManager tm) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            reader.readLine(); 
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    LocalDate dueDate = LocalDate.parse(parts[1]);
                    boolean completed = Boolean.parseBoolean(parts[2]);
                    
                    ITask task;
                    if (parts.length > 3 && !parts[3].isEmpty()) {
                        task = new PriorityTask(parts[0], dueDate, parts[3]);
                    } else {
                        task = new Task(parts[0], dueDate);
                    }
                    
                    if (completed) task.markAsCompleted();
                    tm.addTask(task);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Buat file baru...");
        } catch (Exception e) {
            System.err.println("Error baca file: " + e.getMessage());
        }
    }
}